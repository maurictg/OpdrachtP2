package com.maurict.orm;

import java.lang.reflect.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Database {
    private Connection connection;
    private PreparedStatement pS;
    private StringBuilder qb;
    private String cstring;

    //This will set the default global database a table would use
    public static Database global;

    //Constructors
    public Database(String database, String username, String password){ this("localhost", database, username, password); }
    public Database(String server, String database, String username, String password) { this("jdbc:sqlserver://"+server+";databaseName="+database+";user="+username+";password="+password+";"); }
    public Database(String server, String database){ this("jdbc:sqlserver://"+server+";databaseName="+database+";integratedSecurity=true;"); }
    public Database(String connectionString) {
        this.cstring = connectionString;
        if(test()){
            System.out.println("Connection established!");
            global = this;
        }else{
            System.out.println("ERROR: Could not connect to the database");
        }
    }

    //Test the connection
    private boolean test() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver was not found, or can't connect to DB.");
            return false;
        }
    }

    //Opens the connection if closed
    private boolean open() {
        try {
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(cstring);
            }
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    //Close the connection if open
    private boolean close() {
        try {
            if(!connection.isClosed()){
                connection.close();
            }
            return true;
        } catch (SQLException e){
            return false;
        }
    }

    //Compile prepared statement
    private boolean compile(String query, ArrayList<Object> pstmts) {
        try{
            open();
            System.out.println(query);
            pS = connection.prepareStatement(query);
            if(pstmts != null && pstmts.size() > 0){
                for (int i = 1; i <= pstmts.size(); i++) {
                    pS.setObject(i, pstmts.get(i-1));
                }
            }
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            close();
            return false;
        }
    }

    public boolean raw(String query) throws Exception { return execute(query, new ArrayList<>()); }
    public boolean execute(String query, ArrayList<Object> pstmts) throws Exception {
        if(!compile(query, pstmts)){
            throw new Exception("Compilation of PreparedStatement failed");
        }

        try {
            pS.execute();
            close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            close();
            return false;
        }
    }

    public Object executeSingle(String query, ArrayList<Object> pstmts) throws Exception {
        if(!compile(query, pstmts)){
            throw new Exception("Compilation of PreparedStatement failed");
        }

        try{
            ResultSet rs = pS.executeQuery();
            Object obj = null;
            if(rs.next()){
                obj =  rs.getObject(1);
            }
            close();
            return obj;
        }catch (SQLException e){
            e.printStackTrace();
            close();
            return null;
        }
    }

    public ArrayList<Object> executeQuery(Object type, String query, ArrayList<Object> pstmts) throws Exception {
        if(!compile(query, pstmts)){
            throw new Exception("Compilation of PreparedStatement failed");
        }

        try {
            ResultSet rs = pS.executeQuery();
            ArrayList<Object> objects = new ArrayList<>();

            //Get constructor of class
            Constructor[] ctors = type.getClass().getDeclaredConstructors();
            Constructor ctor = null;
            for (int i = 0; i < ctors.length; i++) {
                ctor = ctors[i];
                if (ctor.getGenericParameterTypes().length == 0)
                    break;
            }
            assert ctor != null;
            ctor.setAccessible(true);

            while (rs.next()){ //get one row
                //CLONE OBJECT HIER
                Object o = ctor.newInstance();

                for (Field f: o.getClass().getFields()){
                    try{
                        if(f.getType() == int.class){
                            f.set(o, rs.getInt(f.getName()));
                        }
                        else if(f.getType() == String.class){
                            f.set(o, rs.getString(f.getName()));
                        }
                        else if(f.getType() == LocalDate.class){
                            f.set(o, parse(rs.getDate(f.getName())));
                        }
                        else if(f.getType() == LocalTime.class){
                            f.set(o, parse(rs.getTime(f.getName())));
                        }
                    } catch (Exception ignored){

                    }
                }

                objects.add(o);
            }

            close();
            return objects;
        }catch (SQLException e){
            e.printStackTrace();
            close();
            return new ArrayList<>();
        }
    }

    private String getName(Object item) throws Exception{
        return (String)item.getClass().getMethod("getName").invoke(item);
    }

    private String getPK(Object item) throws Exception{
        return (String)item.getClass().getMethod("getPk").invoke(item);
    }

    public boolean add(Object item) throws Exception{
        String name = getName(item);
        String pk = getPK(item);
        ArrayList<Object> preparedStatements = new ArrayList<>();

        qb = new StringBuilder("INSERT INTO ");
        qb.append(name).append("(");
        Field[] fields = item.getClass().getFields();
        for (Field f: fields) {
            String n = f.getName();
            if(!n.equals(pk)){
                qb.append(n).append(",");
            }
        }
        qb.replace(qb.length()-1,qb.length(),")");
        qb.append(" VALUES (");
        for (Field f: fields) {
            String n = f.getName();
            if(!n.equals(pk)){
                qb.append("?,");
                preparedStatements.add(f.get(item));
            }
        }
        qb.replace(qb.length()-1,qb.length(),");");
        return this.execute(qb.toString(), preparedStatements);
    }

    public boolean remove(Object item) throws Exception{
        if(item == null){
            return false;
        }

        String pk = getPK(item);
        qb = new StringBuilder("DELETE FROM ");
        qb.append(getName(item)).append(" WHERE ").append(pk).append(" = ?;");
        ArrayList<Object> psms = new ArrayList<>();
        psms.add(item.getClass().getField(pk).get(item));
        return this.execute(qb.toString(), psms);
    }

    public boolean update(Object item) throws Exception{
        String pk = getPK(item);
        qb = new StringBuilder("UPDATE ").append(getName(item));
        qb.append(" SET ");
        Field[] fields = item.getClass().getFields();
        ArrayList<Object> psms = new ArrayList<>();
        for (Field f: fields) {
            String n = f.getName();
            if(!n.equals(pk)){
                qb.append(n).append("=?").append(",");
                psms.add(f.get(item).toString());
            }
        }
        qb.replace(qb.length()-1, qb.length(), " WHERE ");
        qb.append(pk).append(" = ?;");
        psms.add(item.getClass().getField(pk).get(item));
        return this.execute(qb.toString(), psms);
    }

    //Parsers for datetime
    private LocalDate parse(Date date) { return (date == null ? null : date.toLocalDate()); }
    private Date parse(LocalDate date){ return (date == null ? null : Date.valueOf(date)); }
    private LocalTime parse(Time time){ return (time == null ? null : time.toLocalTime()); }
    private Time parse(LocalTime time){ return (time == null ? null : Time.valueOf(time)); }
}