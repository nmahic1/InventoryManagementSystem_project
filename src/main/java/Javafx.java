package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * Glavna klasa za pokretanje JavaFX aplikacije.
 */
public class Javafx extends Application {

    /**
     * Metoda koja se poziva pri pokretanju aplikacije.
     * Postavlja korijenski element i prikazuje glavni prozor.
     *
     * @param stage Stage objekt za prikaz prozora
     * @throws Exception Izuzetak koji se može javiti pri učitavanju korijenskog elementa iz FXML datoteke
     */
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/LogIn.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Glavna metoda za pokretanje JavaFX aplikacije.
     *
     * @param args Argumenti komandne linije
     */
    public static void main(String[] args) {
        launch(args);
    }

}
