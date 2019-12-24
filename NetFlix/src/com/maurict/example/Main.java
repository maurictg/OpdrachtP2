package com.maurict.example;

import com.maurict.orm.Database;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        //This code manually maps the Database object in the Table object
        Database db = new Database("localhost", "test");


        //select and print all
        ArrayList<Object> users =
                    new User()
                        .select()
                        .toList();

        for (Object user : users) {
            User u = (User)user;
            System.out.println(u.name+" ("+u.id+")");
        }

        //create
        User u = new User();
        u.name = "Henk";
        db.add(u);

        //retrieve & update
        User usr = (User)new User().find(1);
        usr.name = "Peter";
        db.update(usr); //or usr.save();







    }
}
