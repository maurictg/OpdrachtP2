package netflix.app;

import netflix.models.Account;
import netflix.models.Film;
import netflix.models.Program;
import netflix.models.Serie;

import java.util.ArrayList;

public class Cache {
    //Class to save array's in to avoid redundant database queries
    public static ArrayList<Account> accounts = new ArrayList<>();
    public static ArrayList<Film> films = new ArrayList<>();
    public static ArrayList<Program> programs = new ArrayList<>();
    public static ArrayList<Serie> series = new ArrayList<>();

    public static void cacheAccounts(){ cacheAccounts(false);}
    public static void cacheAccounts(boolean force) {
        if(!force && accounts.size() > 0)
            return;

        try{
            accounts.clear();
            new Account().select().toList().forEach((f) -> accounts.add((Account)f));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void cacheFilms(){ cacheFilms(false);}
    public static void cacheFilms(boolean force) {
        if(!force && films.size() > 0)
            return;

        try{
            films.clear();
            new Film().select().toList().forEach((f) -> films.add((Film)f));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void cachePrograms(){ cachePrograms(false);}
    public static void cachePrograms(boolean force) {
        if(!force && programs.size() > 0)
            return;

        try{
            programs.clear();
            new Program().select().toList().forEach((f) -> programs.add((Program)f));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void cacheSeries(){ cacheSeries(false);}
    public static void cacheSeries(boolean force) {
        if(!force && series.size() > 0)
            return;

        try{
            series.clear();
            new Serie().select().toList().forEach((f) -> series.add((Serie)f));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
