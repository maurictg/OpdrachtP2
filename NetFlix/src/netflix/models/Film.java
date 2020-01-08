package netflix.models;

import com.maurict.orm.Table;
import netflix.models.Program;

public class Film extends Table {

    public int id;
    public int programId;
    public int ageIndication;

    //1-1 relation = always get
    private Program program;


    public Film() {
        super("Film");

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
