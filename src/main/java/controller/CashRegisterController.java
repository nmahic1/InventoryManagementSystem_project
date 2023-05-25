package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

import java.io.IOException;

public class CashRegisterController {

   // @FXML
   // private Menu brandAndProduct;

    @FXML
    private Menu product;


    @FXML
    private Menu logOut;

    public Button payinvoice;

    @FXML
    void handleProduct(javafx.event.ActionEvent actionEvent) throws IOException{
        // Code to handle save menu item
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Product.fxml"));
        Parent root = loader.load();

        // Otvaranje nove scene s drugim prozorom
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    /*
    @FXML
    void handlebrandAndCategory(javafx.event.ActionEvent actionEvent) throws IOException{
        // Code to handle exit menu item
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BrandAndProduct.fxml"));
        Parent root = loader.load();

        // Otvaranje nove scene s drugim prozorom
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        //isto
    }

     */
    @FXML
    void logout(javafx.event.ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogIn.fxml"));
        Parent root = loader.load();

        // Otvaranje nove scene s drugim prozorom
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    public void PayInvoiceButton(ActionEvent actionEvent) throws IOException {
        // Code to handle save menu item
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Invoice.fxml"));
        Parent root = loader.load();

        // Otvaranje nove scene s drugim prozorom
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

       /* double total = calculateTotalPrice();
        double paidAmount = 50.0; // Ovdje dodati informacije iz polja pay
        double change = calculateChange(total, paidAmount);

        // Ispisivanje kusura
        System.out.println("Kusur: " + change); //postaviti da se ispisuje u TextField

        */
    }

   /* public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Data data : dataListProduct) {
        //ovdje moras povezati ovo sa ProductController
            totalPrice += Double.parseDouble(data.getRetailPrice());
        }
        return totalPrice;
    }

    */

   /* public void calculateChange() {
        double total = calculateTotalPrice();
        double paidAmount = Double.parseDouble(paidAmountTextField.getText());
        double change = calculateChange(total, paidAmount);
        changeTextField.setText(String.format("%.2f", change));
        //TextField za ukupnu vrijednost proizvoda nazivate totalPriceTextField, a TextField za iznos koji je kupac dao nazivate paidAmountTextField, a TextField za kusur nazivate changeTextField
    }
    */

}
