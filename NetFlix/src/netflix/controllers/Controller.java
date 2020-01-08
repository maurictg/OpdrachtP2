/*
 * Controller.java
 * (C) 2020 maurictg, AartPieterse, LauranEkeren
 * Licenced under MIT licence
 */

package netflix.controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //Save the stage to make switching easy
    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    //This are helper methods (in C# we have optional parameters)
    public void show(String name) { show(name,600,400); }
    public void show(String name, String title) { show(name,title,600,400); }
    public void show(String name, String title, int width, int height){
        stage.setTitle(title);
        show(name, width, height);
    }

    //Load the FXML file into the current stage
    public void show(String name, int width, int height) {
        try{
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/"+name+".fxml"));
            Parent root = loader.load();
            Controller c = loader.getController();
            c.setStage(stage);
            stage.setScene(new Scene(root, width, height));
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //Overridable method
    void onLoad() { }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.onLoad();
    }
}
