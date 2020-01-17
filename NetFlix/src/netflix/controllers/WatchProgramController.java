package netflix.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import netflix.models.Film;
import netflix.models.Program;

import java.util.ArrayList;

public class WatchProgramController extends Controller {

    private ArrayList<Object> programs;
    private ArrayList<Object> films;
    private ArrayList<Integer> programIdsFromFilms;

    @FXML
    private ComboBox cbFilms;

    @FXML
    public void cbFilms_Change(){

    }

    @Override
    void onLoad() {
        System.out.println("-1");
        try{
            System.out.println("0");
            programs = new Program().select().toList();
            System.out.println("0.5");
            films = new Film().select().toList();
            System.out.println("1");
            programIdsFromFilms = new ArrayList<>();
            System.out.println("2");
            for (Object o: films){
                programIdsFromFilms.add(((Film)o).programId);
            }

            for (Object o: programs) {
                if (programIdsFromFilms.contains(((Program)o).programId)){
                    cbFilms.getItems().add(((Program)o).title);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
