package netflix.controllers;

import com.maurict.orm.Database;
import javafx.fxml.FXML;
import netflix.models.Film;
import javafx.scene.control.*;

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

        tbData.setText(film.longestFilmAgeSixteen());
    }

    @FXML
    private void btnViewAccountsWithOneProfile_Click() {
        
    }

    @FXML
    private void btnViewTimesWatched_Click() {

    }

    @FXML
    private void btnBack_Click() {
        this.show("Home");
    }
}
