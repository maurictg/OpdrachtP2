/*
 * Table.java
 * (C) 2020 maurictg
 * Licenced under MIT licence
 */

package com.maurict.orm;

import netflix.models.Account;

import java.util.*;

public class Table {
    //Class attributes
    private String name; //The table's name
    private String pk; //The primary key
    private Database db; //The database

    /*
    SELECT column_name(s) <--selector (ALL, DISTINCT, AS)
    FROM table_name
    WHERE condition <-- constraint
    GROUP BY column_name(s) <-- grouping
    HAVING condition <--having
    ORDER BY column_name(s); <-- order
     */

    //The query builder
    private StringBuilder qB; //Query Builder
    private ArrayList<Object> preparedStatements;

    //Constructors
    public Table(String tableName) { this(tableName, "id");}
    public Table(String tableName, String primaryKey) {
        this.pk = primaryKey;
        this.name = tableName;
        this.qB = new StringBuilder();
        this.preparedStatements = new ArrayList<>();
        this.db = Database.global;
    }

    public void clear(){
        //clear query builders
        qB = new StringBuilder();
        preparedStatements = new ArrayList<>();
    }

    //Set the database to use. Default = Database.global
    public Table useDatabase(Database database){
        this.db = database;
        return this;
    }

    //Test if database is set
    private void test() throws Exception {
        if(this.db == null){
            throw new Exception("Database is closed. Try to implement useDatabase() first!");
        }
    }

    //Getters
    public String getName() { return name; }
    public String getPk() { return pk; }

    //Helper functions for select and the select function
    public Table select() { return select("", new String[]{"*"}); }
    public Table selectDistinct(String... columns) { return select("DISTINCT", columns); }
    public Table selectCount(String... columns) { return select("COUNT", columns); }
    public Table selectAvg(String... columns) { return select("AVG", columns); }
    public Table selectSum(String... columns) { return select("SUM", columns); }
    public Table select(String... columns) { return select("",columns); }
    public Table select(String argument, String[] columns){
        boolean hasArgument = (argument.length()>0);
        qB.append("SELECT ").append((hasArgument)?argument+"(":"").append((columns.length>0)?String.join(",", columns):"*").append((hasArgument)?")":"").append(" FROM ").append(name);
        return this;
    }

    public Table selectTop(int amount, String... columns){
        qB.append("SELECT TOP(").append(amount).append(") ").append((columns.length>0)?String.join(",", columns):"*").append(" FROM ").append(name);
        return this;
    }

    //helper functions for where and the where function
    public Table where(String field, Object value) { return where(field,"=",value,"WHERE"); }
    public Table where(String field, String operator, Object value) { return where(field,operator,value,"WHERE"); }
    public Table whereNot(String field, String operator, Object value) { return where(field,operator,value,"WHERE NOT"); }
    public Table whereNot(String field, Object value) { return where(field,"=",value,"WHERE NOT"); }
    public Table and(String field, String operator, Object value) { return where(field,operator,value,"AND"); }
    public Table and(String field, Object value) { return where(field,"=",value,"AND"); }
    public Table or(String field, String operator, Object value) { return where(field,operator,value,"OR"); }
    public Table or(String field, Object value) { return where(field,"=",value,"OR"); }
    public Table where(String field, String operator, Object value, String prefix){
        qB.append(" ").append(prefix).append(" ").append(field).append(" ").append(operator).append(" ?");
        preparedStatements.add(value);
        return this;
    }

    public Table whereExists(String rawQuery){
        qB.append(" ").append("WHERE EXISTS (").append(rawQuery).append(")");
        return this;
    }

    public Table whereIn(String column, String arguments) {
        qB.append("WHERE").append(column).append(" IN (").append(arguments).append(")");
        return this;
    }

    //order functions
    public Table order(String field) { qB.append(" ORDER BY ").append(field).append(" ASC"); return this; }
    public Table orderDesc(String field) { qB.append(" ORDER BY ").append(field).append(" DESC"); return this; }

    //join functions
    public Table innerJoin(String table, String foreignKey){ return innerJoin(table, pk, foreignKey); }
    public Table innerJoin(String table, String primaryKey, String foreignKey) { return join("INNER", table, primaryKey, foreignKey); }
    private Table join(String type,String table, String primaryKey, String foreignKey){
        qB.append(" ").append(type).append(" JOIN ").append(table).append(" ON ").append(table).append(".").append(foreignKey).append("=").append(name).append(".").append(primaryKey);
        return this;
    }

    //group functions
    public Table groupBy(String field){
        qB.append(" GROUP BY ").append(field);
        return this;
    }

    //In-model helper functions for db class
    public boolean delete() throws Exception { test(); return db.remove(this); }
    public boolean save() throws Exception { test(); return db.update(this); }
    public boolean add(Object object) throws Exception { test(); return db.add(object); }

    public ArrayList<Object> toList() throws Exception{
        test();
        qB.append(";");
        ArrayList<Object> result = db.executeQuery(this, qB.toString(), preparedStatements);
        clear();
        return result;
    }

    public Table havingCount(String column, Object value) {return havingCount(column, "=", value); }
    public Table havingCount(String column, String operator, Object value){
        qB.append(" HAVING COUNT(").append(column).append(") ").append(operator).append(" ?");
        preparedStatements.add(value);
        return this;
    }

    //This function is a helper function for toList()
    public Object first() throws Exception { test(); return this.toList().get(0); }
    public Object last() throws Exception { test(); List<Object> i = this.toList(); return i.get(i.size()-1); }

    //find function
    public Object find(int id) throws Exception {
        ArrayList<Object> objs = this.selectTop(1).where(pk,id).toList();
        if(objs.size()>0){
            return objs.get(0);
        }else{
            return null;
        }
    }

    //FirstObject functions
    public int firstInt() throws Exception { return (Integer)firstObject(); }
    public String firstString() throws Exception { return (String)firstObject(); }
    public Object firstObject() throws Exception{
        String q = qB.toString();
        if(q.contains("SELECT")){
            q = q.replace("SELECT", "SELECT TOP(1)");
        }
        test();
        qB.append(";");
        Object obj = db.executeSingle(q, preparedStatements);
        clear();
        return obj;
    }

    //Add raw sql to query builder
    public Table raw(String rawQuery){
        qB.append(rawQuery);
        return this;
    }

    public ArrayList<Object> rawQuery(String query) throws Exception { return rawQuery(query, new ArrayList<>()); }
    public ArrayList<Object> rawQuery(String query, ArrayList<Object> preparedStatements) throws Exception {
        return db.executeQuery(this, query, preparedStatements);
    }



    //EXPERIMENTAL ZONE
    //https://www.w3schools.com/sql/sql_where.asp

}
