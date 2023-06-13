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

// Model-View-Controller (MVC) se koristi

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

/*package controller;

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

public class LogInController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private Button loginButton;

    private LoginService loginService;

    public LogInController() {
        this.loginService = new LoginService();
    }
    public void login(ActionEvent e) throws IOException {
        if (usernameField.getText().isBlank() == false && passwordField.getText().isBlank() == false) {
            validateLogin();
        } else {
            errorLabel.setText("Please enter username and password");
        }
    }

    public void validateLogin() {
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

 */
/*
//new code
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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import repository.LoginDBConnectionRepository;


public class LogInController {
    //private List<LoginObserver> observers = new ArrayList<>();

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private Button loginButton;


    public void login(ActionEvent e) throws IOException {
        if(usernameField.getText().isBlank()==false && passwordField.getText().isBlank()==false){
          //  errorLabel.setText("try again");
            validateLogin();


        }else{
            errorLabel.setText("Please enter username and password");
        }

    }

    public void validateLogin(){
        LoginDBConnectionRepository connectNow = new LoginDBConnectionRepository();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin ="SELECT count(1) FROM useraccounts WHERE username = '" + usernameField.getText() + "' AND passwordl = '" + passwordField.getText() + "'";

        try{
            Statement  statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if(queryResult.getInt( 1 )==1){
                    errorLabel.setText("Welcome!");

                    // Učitavanje FXML datoteke drugog prozora
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Product.fxml"));
                    Parent root = loader.load();


                    // Otvaranje nove scene s drugim prozorom
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();

                }
                else{
                    errorLabel.setText("Invalid login!");
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }

     }
*/
    //pattern
    /*@FXML
    void login(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            // Provjera korisničkog imena i lozinke
            if (isValidCredentials(username, password)) {
                notifyObservers();

                // Učitavanje FXML datoteke drugog prozora
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Product.fxml"));
                Parent root = loader.load();


                // Otvaranje nove scene s drugim prozorom
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } else {
                throw new InvalidCredentialsException("Invalid username or password");
            }
        } catch (InvalidCredentialsException e) {
            errorLabel.setText(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidCredentials(String username, String password) {
        return username.equals("nmahic1") && password.equals("12345");

    }

    public void addObserver(LoginObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(LoginObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (LoginObserver observer : observers) {
            observer.onLoginSuccess();
        }
    }
}

class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String message) {
        super(message);
    }

}

interface LoginObserver {
    void onLoginSuccess();
}
*/
