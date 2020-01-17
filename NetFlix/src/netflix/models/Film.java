package netflix.models;

import com.maurict.orm.Table;
import netflix.models.Program;

public class Film extends Table {

    public int filmId;
    public int age;
    public String language;
    public String genre;
    public int programId;

    //1-1 relation = always get
    private Program program;
    private boolean includesProgram;


    public Film() {
        super("Films", "filmId");
    }

    public Program getProgram() {
        if(!includesProgram){
            includeProgram();
        }

        return program;
    }

    public void includeProgram(){
        try{
            this.program = (Program)new Program().find(programId);
            includesProgram = true;
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
