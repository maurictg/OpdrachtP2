package netflix.models;

import java.util.ArrayList;

public class Profile {

    private String profileName;
    private ArrayList<WatchedProgram> programsWatched;

    public Profile(String profileName){
        this.profileName = profileName;
        this.programsWatched = new ArrayList<>();
    }

    public void addProgramWatched(WatchedProgram watchedProgram){
        this.programsWatched.add(watchedProgram);
    }

}
