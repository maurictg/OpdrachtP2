package netflix.models;

import com.maurict.orm.Table;

public class Program extends Table {

    public int programId;
    public String title;
    public int lengthInMinutes;

    public Program(){
        super("Programs", "programId");
    }


}
