package netflix.models;

import com.maurict.orm.Table;
import netflix.models.Program;

public class Film extends Table {

    public int filmId;
    public int programId;

    //1-1 relation = always get
    private Program program;


    public Film() {
        super("Films");

        try{
            this.program = (Program)new Program().find(programId);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Program getProgram() {
        return program;
    }
}
