package netflix;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import netflix.controllers.LoginController;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        try{
            //Laad de login pagina in (FXML)
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Login.fxml"));
            Parent root = loader.load();
            LoginController controller = loader.getController();

            //Sla de stage op in de controller zodat we van pagina kunnen wisselen
            controller.setStage(stage);

            stage.setTitle("Netflix Statistix");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();

        }catch (Exception e){
            System.out.println("NOT FOUND");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
