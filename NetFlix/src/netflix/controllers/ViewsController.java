package netflix.controllers;

import com.maurict.orm.Database;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import netflix.models.*;

import java.util.ArrayList;

public class ViewsController extends Controller {

    Database db = Database.global;

    @FXML
    private TextArea tbData;

    @FXML
    private void btnViewAvgWatchedPerEpisode_Click() {

    }

    @FXML
    private void btnViewAvgWatchedPerEpisodePerAccount_Click() {

    }

    @FXML
    private void btnViewWatchedMoviesPerAccount_Click() {



    }

    @FXML
    private void btnViewLongestMovieSixteenYears_Click() {

        Film film = new Film();

        tbData.setText("Longest film: \n" + film.longestFilmAgeSixteen());
    }

    @FXML
    private void btnViewAccountsWithOneProfile_Click() {

        try {

            ArrayList<Object> accounts = new Account().select().toList();
            ArrayList<Account> counter = new ArrayList<>();

            for (int i = 0; i < accounts.size(); i++) {
                if (((Account) accounts.get(i)).profileCount() == 1) {
                    counter.add((Account) accounts.get(i));
                }
            }

            if (!counter.isEmpty()) {
                for (Account i : counter) {
                    tbData.setText(i.accountName);
                }

            } else {
                tbData.setText("No accounts matched this requirement");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnViewTimesWatched_Click() {

        try {


        ArrayList<Object> films = new WatchedProgram().select().toList();
        ArrayList<Program> watchedPrograms = new ArrayList<>();

        for (int i = 0; i < films.size(); i++) {

            watchedPrograms.add((Program) films.get(i));
            tbData.setText(films.get(i));
        }
    } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnBack_Click() {
        this.show("Home");
    }
}
