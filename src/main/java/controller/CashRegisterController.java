
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
import service.CashRegisterService;

import java.io.IOException;


import service.ProductService;


public class CashRegisterController {
     @FXML
    public Button calculate;
    @FXML
    public Label pay;
    @FXML
    public Label balanceTextField;
    @FXML
    private TextField subtotal;
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

    @FXML
    private TableColumn<CashRegisterController.Data, Integer> dataColumnRetailPrice;

    @FXML
    private TableColumn<CashRegisterController.Data, String > dataColumnBrand;
    @FXML
    private TableColumn<CashRegisterController.Data, String > dataColumnPrice;


    private ObservableList<CashRegisterController.Data> dataListCashRegister = FXCollections.observableArrayList();

    private CashRegisterService cashRegisterService;

    private ProductService productService;
    private ObservableList<ProductController> productList = FXCollections.observableArrayList();


    public CashRegisterController() {
        cashRegisterService = new CashRegisterService();
        productService = new ProductService();
    }



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

    public static class Data {

        private int quantity;

        private int barcode;

        private String brand;

        private int retailPrice;

        private int price;

        public Data( int barcode, int quantity ) {

            this.quantity = quantity;
            this.barcode = barcode;
           // this.brand = brand;
           // this.retailprice = retailprice;
            this.price = 0; // Inicijalno postavljamo cenu na 0
            updatePrice();

        }


        public int getQuantity() {
            return quantity;
        }


        public int getBarcode() {
            return barcode;
        }


        public void setBarcode(int data) {
            this.barcode = data;
        }


        public String getBrand() {
            return brand;
        }

        public void setBrand(String data) {
            this.brand = data;
        }



        public int getRetailPrice() {
            return retailPrice;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }


        public void setQuantity(int quantity) {
            this.quantity = quantity;
            updatePrice();
        }

        public void setRetailPrice(int retailPrice) {
            this.retailPrice = retailPrice;
            updatePrice();
        }

        private void updatePrice() {
            this.price = this.retailPrice * this.quantity;
        }


    }


    @FXML
    void addData(ActionEvent actionEvent) {

        dataColumnBarCode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        dataColumnBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        dataColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        //dataColumnRetailPrice.setCellValueFactory(new PropertyValueFactory<>("retailPrice"));
        dataColumnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));


        int barcode = Integer.parseInt(this.barcode.getText());
        ProductController.Data product = productService.getProductByBarcode(barcode);

        if (product != null) {
            int quantity = Integer.parseInt(this.quantity.getText());
            int retailPrice = product.getRetailPrice();
            int price = quantity * retailPrice;

            CashRegisterController.Data newData = new CashRegisterController.Data(barcode, quantity);
            newData.setBrand(product.getBrand());
            newData.setRetailPrice(retailPrice);
            newData.setPrice(price);

            dataListCashRegister.add(newData);
            tableView.setItems(dataListCashRegister);

            this.quantity.clear();
            this.barcode.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Product Not Found");
            alert.setHeaderText("Product with the barcode " + barcode + " not found.");
            alert.setContentText("Please enter a valid barcode.");
            alert.showAndWait();
        }

    }

    @FXML
    void deleteData(javafx.event.ActionEvent event) {
        // Obrada brisanja iz tabele i repozitorija
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            CashRegisterController.Data selectedData = tableView.getItems().get(selectedIndex);
            tableView.getItems().remove(selectedIndex);
            cashRegisterService.removeData(selectedData);
        } else {
            // Ostatak koda za prikaz upozorenja ako nije odabrana stavka
            Alert alert = new Alert(Alert.AlertType.WARNING);
            //prozor za ispisivanje poruke
            alert.setTitle("No Selection");
            alert.setHeaderText("No Data Selected");
            alert.setContentText("Please select a data in the table.");
            alert.showAndWait();
        }
    }

    @FXML
    void calculateSubtotal() {
        int subtotalPrice = 0;
        for (Data data : dataListCashRegister) {
            subtotalPrice += data.getQuantity() * data.getRetailPrice();
        }
        subtotal.setText(Integer.toString(subtotalPrice));

        // Get the amount entered in the "Pay" TextField
        int payAmount = Integer.parseInt(pay.getText());

        // Calculate the balance
        int balance = subtotalPrice - payAmount;

        // Update the "Balance" TextField
        balanceTextField.setText(Integer.toString(balance));
    }




    /*
    public void PayInvoiceButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Invoice.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
   */

}
