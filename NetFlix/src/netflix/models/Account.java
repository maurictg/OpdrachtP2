package netflix.models;

import com.maurict.orm.Table;

public class Account extends Table {

    //Namen van database veld
    public int id;
    public String username;
    public String password;
    public String city;
    public String street;
    public String number;
    public String extension;
    public String phone;
    public String age;

    public Account() {
        super("accounts");
    }



}
