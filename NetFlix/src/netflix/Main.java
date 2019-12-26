package netflix;
import javafx.stage.Stage;
import netflix.app.Login;
import javafx.application.Application;

public abstract class Main extends Application {

    public static void main(String[] args) {

        Application.launch(Login.class);
    }
}