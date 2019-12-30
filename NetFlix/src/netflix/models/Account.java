package netflix.models;

import com.maurict.orm.Table;

public class Account extends Table {

    //Namen van database veld
    public int id;
    public String username;
    public String password;
    public String email;
    public String phone;

    public Account() {
        super("accounts");
    }



}
