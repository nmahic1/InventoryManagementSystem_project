package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class MenuBarController {

    @FXML
    private Menu brandAndProduct;

    @FXML
    private Menu product;

    @FXML
    private Menu cashRegister;

    @FXML
    private Menu logOut;

    @FXML
    public static void handleProduct(ActionEvent event) throws IOException {
        // Code to handle save menu item
        FXMLLoader loader = new FXMLLoader(MenuBarController.class.getResource("/Product.fxml"));
        Parent root = loader.load();

        // Opening a new scene with another window
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public static void handleCashRegister(ActionEvent event) throws IOException {
        // Code to handle exit menu item
        FXMLLoader loader = new FXMLLoader(MenuBarController.class.getResource("/CashRegister.fxml"));
        Parent root = loader.load();

        // Opening a new scene with another window
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public static void logout(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(MenuBarController.class.getResource("/LogIn.fxml"));
        Parent root = loader.load();

        // Opening a new scene with another window
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


}
