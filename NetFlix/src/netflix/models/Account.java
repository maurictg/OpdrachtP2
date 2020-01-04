package netflix.models;

import com.maurict.orm.Table;

import java.util.ArrayList;

public class Account extends Table {

    //Namen van database velden
    public int id;
    public String accountName;
    public String password;
    public String city;
    public String street;
    public int number;
    public String extension;
    public int phone;
    public int age;
    public ArrayList<Profile> profiles;

    public Account() {
        super("accounts");
        this.profiles = new ArrayList<>();
    }

}
