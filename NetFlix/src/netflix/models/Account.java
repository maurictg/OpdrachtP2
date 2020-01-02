package netflix.models;

import com.maurict.orm.Table;

public class Account extends Table {

    //Namen van database velden
    public int id;
    public String username;
    public String password;
    public String city;
    public String street;
    public int number;
    public String extension;
    public int phone;
    public int age;

    public Account() {
        super("accounts");
    }
}
