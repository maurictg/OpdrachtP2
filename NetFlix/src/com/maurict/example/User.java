package com.maurict.example;

import com.maurict.orm.Table;

public class User extends Table {
    public int id;
    public String name;

    public User() {
        super("users");
    }

}
