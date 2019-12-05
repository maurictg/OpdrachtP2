package netnix.app;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class GUI {

    private Stage stage;

    public GUI(Stage stage, String title) {
        this.stage = stage;
        this.stage.setTitle(title);
        this.build();
    }

    private void build() {
        BorderPane bp = new BorderPane();

        VBox vb = new VBox();
        vb.getChildren().add((new Label("Hello")));
        bp.setTop(vb);

        Scene s = new Scene(bp);
        stage.setScene(s);
        stage.setTitle("Netflix Statistics");
    }

    public void run(){
        stage.show();
    }
}
