package netflix.models;

import com.maurict.orm.Table;

public class Program extends Table {

    public int id;
    public String title;
    public int lengthInMinutes;

    public Program(){
        super("Program");
    }

}
