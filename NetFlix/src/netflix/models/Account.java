package netflix.models;

import com.maurict.orm.Table;

import java.time.LocalDate;
import java.util.ArrayList;

public class Account extends Table {

    //Field names in the database
    public int accountId;
    public String accountName;
    public String password;
    public String city;
    public String street;
    public int number;
    public String extension;
    public String phone;
    public LocalDate birthdate;

    //This one needs to be private, because you can't store ArrayLists in the database
    private ArrayList<Profile> profiles;
    private boolean includesProfiles;

    public Account() {
        super("Accounts");
        this.profiles = new ArrayList<>();
        this.includesProfiles = false;
    }

    public ArrayList<Profile> getProfiles() {
        if(!includesProfiles){
            this.includeProfiles();
        }

        return profiles;
    }

    public void includeProfiles(){
        try{
            ArrayList<Object> profiles = new Profile().select().where("accountId",this.accountId).toList();
            for (Object p : profiles){
                this.profiles.add((Profile)p);
            }

            this.includesProfiles = true;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Integer profileCount() {
        if(includesProfiles){
            return this.profiles.size();
        }

        try{
            return new Profile().selectCount().where("accountId",this.accountId).firstInt();
        } catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

}
