package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CashRegisterController {
    @FXML
    public Button deleteButton;

    @FXML
    public Button addButton;

    // @FXML
   // private Menu brandAndProduct;

    @FXML
    private Menu product;


    @FXML
    private Menu logOut;

    @FXML
    private TextField quantity;

    @FXML
    private TextField barcode;

    public Button payinvoice;

    //delete i add buttons

    @FXML
    private TableView<CashRegisterController.Data> tableView;

    @FXML
    private TableColumn<CashRegisterController.Data, Integer> dataColumnBarCode;

    @FXML
    private TableColumn<CashRegisterController.Data, Integer> dataColumnQuantity;

    private ObservableList<CashRegisterController.Data> dataListCashRegister = FXCollections.observableArrayList();


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

    public class Data {

        private int quantity;

        private int barcode;


        public Data(int quantity,  int barcode) {

            this.quantity = quantity;
            this.barcode = barcode;

        }


        public int getQuantity() {
            return quantity;
        }


        public int getBarcode() {
            return barcode;
        }


        public void setQuantity(int data) {
            this.quantity = data;
        }

        public void setBarcode(int data) {
            this.barcode = data;
        }


    }
    @FXML
    void addData(ActionEvent actionEvent) {


        // postavljanje vrijednosti ćelija u tabeli
        dataColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dataColumnBarCode.setCellValueFactory(new PropertyValueFactory<>("barcode"));

        // kreiranje novog unosa na osnovu unesenih podataka
        int dataQ = Integer.parseInt(quantity.getText());
        int dataBC = Integer.parseInt(barcode.getText());

        dataListCashRegister.add(new CashRegisterController.Data(dataQ,dataBC));
        tableView.setItems(dataListCashRegister);

        // čišćenje unesenih podataka
        quantity.clear();
        barcode.clear();
    }

    @FXML
    void deleteData(javafx.event.ActionEvent event) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tableView.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            //prozor za ispisivanje poruke
            alert.setTitle("No Selection");
            alert.setHeaderText("No Data Selected");
            alert.setContentText("Please select a data in the table.");
            alert.showAndWait();
        }
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
