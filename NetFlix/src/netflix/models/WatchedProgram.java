package netflix.models;

import com.maurict.orm.Table;
import netflix.models.Program;

public class WatchedProgram extends Table {

    public int id; //primary key
    public int programId; //foreign key: Program.id
    public int profileId; //foreign key: Profile.id
    public int timeWatched;

    //1-1 relations
    private Program program;
    private Profile profile;

    private boolean includesProgram;
    private boolean includesProfile;

    public WatchedProgram() {
        super("WatchedPrograms");
        this.includesProfile = false;
        this.includesProgram = false;
    }

    public double getPercentageWatched() {
        return (double)((this.timeWatched / this.getProgram().time) * 100);
    }

    public Program getProgram() {
        if(!includesProgram){
            this.includeProgram();
        }

        return program;
    }

    public Profile getProfile() {
        if(!includesProfile){
            this.includeProfile();
        }

        return profile;
    }

    public void includeProgram() {
        try {
            //Get program from database
            this.program = (Program)new Program().find(programId);
            this.includesProgram = true;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void includeProfile() {
        try {
            //Get profile from database
            this.profile = (Profile)new Profile().find(profileId);
            this.includesProfile = true;
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
