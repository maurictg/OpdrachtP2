package netflix.models;

import com.maurict.orm.Table;

public class Program extends Table {
    public int programId;
    public String title;
    public int time;
//    Misschien leuk om van genre/language een E-num van te maken/
    public String genre;
    public String language;
    public int ageIndication;


    public Program(){
        super("Programs");
    }

}
