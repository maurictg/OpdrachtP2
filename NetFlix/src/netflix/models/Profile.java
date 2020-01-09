package netflix.models;
import com.maurict.orm.Table;

import java.util.ArrayList;

public class Profile extends Table {

    //database fields
    public int id;
    public int accountId;
    public String profileName;

    private ArrayList<WatchedProgram> programsWatched;
    private boolean includesProgramsWatched;

    private Account account;
    private boolean includesAccount;

    public Profile() {
        super("Profiles");
        this.programsWatched = new ArrayList<>();
        this.includesProgramsWatched = false;
        this.includesAccount = false;
    }

    public ArrayList<WatchedProgram> getProgramsWatched() {
        if(!includesProgramsWatched){
            this.includeProgramsWatched();
        }

        return programsWatched;
    }

    public void includeProgramsWatched(){
        try {
            ArrayList<Object> pws = new WatchedProgram().select().where("profileId",this.id).toList();
            for (Object p: pws) {
                programsWatched.add((WatchedProgram)p);
            }

            this.includesProgramsWatched = true;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Account getAccount() {
        if(!includesAccount){
            this.includeAccount();
        }

        return account;
    }

    public void includeAccount() {
        try{
            this.account = (Account)new Account().find(accountId);
            this.includesAccount = true;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //Helper function
    public boolean addProgramWatched(Program program, int timeWatched){
        WatchedProgram wp = new WatchedProgram();
        wp.programId = program.id;
        wp.timeWatched = timeWatched;
        return addProgramWatched(wp);
    }

    public boolean addProgramWatched(WatchedProgram watchedProgram){
        try{
            watchedProgram.profileId = this.id;
            //add to database
            this.add(watchedProgram);
            this.programsWatched.add(watchedProgram);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
