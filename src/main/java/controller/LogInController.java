package controller;
/*
//package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class LogInController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private Button loginButton;

    @FXML
    void login(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Provjera korisničkog imena i lozinke
        if (username.equals("nmahic1") && password.equals("12345")) {
            try {
                // Učitavanje FXML datoteke drugog prozora
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/BrandAndProduct.fxml"));
                Parent root = loader.load();

                // Otvaranje nove scene s drugim prozorom
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Prikazivanje upozorenja ako korisničko ime ili lozinka nisu ispravni
            errorLabel.setText("Invalid username or password");
        }
    }
}
*/
/*
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
import java.util.ArrayList;
import java.util.List;

public class LogInController {
    private List<LoginObserver> observers = new ArrayList<>();

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private Button loginButton;

    @FXML
    void login(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Provjera korisničkog imena i lozinke
        if (username.equals("nmahic1") && password.equals("12345")) {
            notifyObservers();

            try {
                // Učitavanje FXML datoteke drugog prozora
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/BrandAndProduct.fxml"));
                Parent root = loader.load();

                // Otvaranje nove scene s drugim prozorom
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Prikazivanje upozorenja ako korisničko ime ili lozinka nisu ispravni
            errorLabel.setText("Invalid username or password");
        }
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

interface LoginObserver {
    void onLoginSuccess();
}
*/
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
import java.util.ArrayList;
import java.util.List;

public class LogInController {
    private List<LoginObserver> observers = new ArrayList<>();

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private Button loginButton;

    @FXML
    void login(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            // Provjera korisničkog imena i lozinke
            if (isValidCredentials(username, password)) {
                notifyObservers();

                // Učitavanje FXML datoteke drugog prozora
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/BrandAndProduct.fxml"));
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

