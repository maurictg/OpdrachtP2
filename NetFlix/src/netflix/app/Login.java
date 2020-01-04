package netflix.app;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Login extends Application {

    private Stage stage;
    private Home home;

    public void start(Stage stage) {
        this.stage = stage;
        this.home = new Home();

        this.login();
    }

    private void login() {
        GridPane pane = new GridPane();

        Label lblHdr = new Label("Login");
        lblHdr.getStyleClass().add("title");

        //pane.add(Node, colIndex, rowIndex, colSpan, rowSpan):
        pane.add(lblHdr, 1, 1, 2, 1);
        pane.setAlignment(Pos.TOP_CENTER);

        Label lblUn = new Label("Username: ");
        Label lblPw = new Label("Password: ");
        Label lblReturn = new Label(" ");

        TextField tbUn = new TextField();
        PasswordField tbPw = new PasswordField();

        Button btnLogin = new Button("Login");

        GridPane gp = new GridPane();

        // Alle onderdelen toevoegen aan de GridPane
        gp.add(lblUn, 1, 2);
        gp.add(lblPw, 1, 3);
        gp.add(tbUn, 2, 2);
        gp.add(tbPw, 2, 3);
        gp.add(btnLogin, 2, 4);

        // geometry
        gp.setVgap(15);
        gp.setHgap(15);


        // De werking van de buttons
        btnLogin.setOnAction(event -> {
            if (this.checkPassword()) {
                this.home.start(stage);
            }

            lblReturn.setText("Wrong username or password, try again");
        });

        /*Dit is een andere manier voor een event.
        loginButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

        });*/

        //pane.add(Node, colIndex, rowIndex, colSpan, rowSpan):
        pane.add(gp, 1,2);

        //CSS class toekennen
        pane.getStyleClass().add("body");

        // Deze pagina laten zien d.m.v. de methode 'run()'
        this.run(new Scene(pane, 600, 400));
    }

    private void run(Scene scene) {
        stage.setScene(scene);
        //CSS inladen
        String path = this.getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(path);

        stage.setTitle("Netflix Statistics");
        stage.show();
    }

    private boolean checkPassword() {
        return true;
    }
}
