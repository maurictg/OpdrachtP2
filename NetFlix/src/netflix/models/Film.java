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
            ArrayList<Object> films = new Film()
                    .select().where("age","<=",16).toList();

            ArrayList<Film> filmsA16 = new ArrayList<>();
            films.forEach((f) -> filmsA16.add((Film)f));
            return filmsA16;
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
            if (films.get(i).getProgram().lengthInMinutes > longestDuration){
                longestDuration = films.get(i).getProgram().lengthInMinutes;
                longestFilm = films.get(i);
            }
        }
        return longestFilm.getProgram().title;
    }

}
