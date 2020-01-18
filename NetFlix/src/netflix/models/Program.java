package netflix.models;

import com.maurict.orm.Table;

import java.util.ArrayList;

public class Program extends Table {

    public int programId;
    public String title;
    public int lengthInMinutes;

    public Program(){
        super("Programs", "programId");
    }

    public static int ProgramLength(int programId){
        try {
            ArrayList<Object> programs = new Program().select().toList();
            for (int i = 0; i < programs.size(); i++){
                if (((Program)programs.get(i)).programId == programId){
                    return ((((Program) programs.get(i)).lengthInMinutes));
                }
            }
        } catch (Exception e){
            System.out.println("Mislukt");
        }
        return -1;
    }

    public static Program getProgramFromProgramId(int programId){
        try {
            ArrayList<Object> programs = new Program().select().toList();
            for (int i = 0; i < programs.size(); i++){
                if (((Program)programs.get(i)).programId == programId){
                    return ((Program)programs.get(i));
                }
            }
        } catch (Exception e){
            System.out.println("Mislukt");
        }
        return new Program();
    }
}
