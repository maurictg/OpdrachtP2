package netflix.models;

public class WatchedProgram {

    private Program program;
    private int percentageWatched;

    public WatchedProgram(Program program, int percentageWatched){
        this.program = program;
        this.percentageWatched = percentageWatched;
    }



}
