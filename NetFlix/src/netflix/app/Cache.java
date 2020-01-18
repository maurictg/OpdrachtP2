package netflix.app;

import netflix.models.Account;
import netflix.models.Film;

import java.util.ArrayList;

public class Cache {
    //Class to save array's in to avoid redundant database queries
    public static ArrayList<Account> accounts = new ArrayList<>();
    public static ArrayList<Film> films = new ArrayList<>();

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

    public static void cacheFilms(){ cacheAccounts(false);}
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
}
