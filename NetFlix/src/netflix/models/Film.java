package netflix.models;

import com.maurict.orm.Database;
import com.maurict.orm.Table;
import netflix.models.Program;

import java.util.ArrayList;

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

    public static ArrayList<Film> filmAgeSixteen(){
        try {
            Database db = Database.global;
            ArrayList<Object> films = new Film().select().toList();
            ArrayList<Film> filmsAgeSixteen = new ArrayList<>();
            for (int i = 0; i < films.size(); i++){
                if (((Film)films.get(i)).age < 16){
                    filmsAgeSixteen.add((Film)films.get(i));
                }
            }
            return filmsAgeSixteen;
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<Film>();
    }

    public static String longestFilmAgeSixteen(){
        ArrayList<Film> films = filmAgeSixteen();
        int longestDuration = 0;
        Film longestFilm = new Film();
        for (int i = 0; i < films.size(); i++){
            if (Program.ProgramLength(films.get(i).programId) > longestDuration){
                longestDuration = Program.ProgramLength(films.get(i).programId);
                longestFilm = films.get(i);
            }
        }
        return Program.getProgramFromProgramId(longestFilm.programId).title;
    }
}
