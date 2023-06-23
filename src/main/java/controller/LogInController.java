package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

import service.LoginService;

/**
 * Kontroler klasa za funkcionalnost prijave
 */
public class LogInController {
    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    Label errorLabel;

    @FXML
    private Button loginButton;

    private LoginService loginService;

    /**
     * Konstruktor, inicijalizaciju objekta prilikom njegovog kreiranja.
     */
    public LogInController() {
        this.loginService = new LoginService();
    }


    public void login(ActionEvent e) throws IOException {
        if (!usernameField.getText().isBlank() && !passwordField.getText().isBlank()) {
            validateLogin();
        } else {
            errorLabel.setText("Please enter username and password");
        }
    }
    /**
     * Validira prijavu korisnika na osnovu unesenog korisničkog imena i lozinke.
     * Ako je prijava uspješna, otvara se novi prozor sa sadržajem iz FXML datoteke "Product.fxml".
     * U suprotnom, ispisuje se poruka o neuspjeloj prijavi.
     *
     * @throws IOException ako se javi greška prilikom učitavanja FXML datoteke
     */


    public void validateLogin() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (loginService.validateLogin(username, password)) {
            errorLabel.setText("Welcome!");

            // Učitavanje FXML datoteke drugog prozora
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Product.fxml"));
            Parent root = loader.load();


            // Otvaranje nove scene s drugim prozorom
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } else {
            errorLabel.setText("Invalid login!");
        }
    }
}



