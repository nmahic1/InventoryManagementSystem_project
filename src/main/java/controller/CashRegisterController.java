
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

        public Data( int barcode, int quantity ) {

            this.quantity = quantity;
            this.barcode = barcode;
           // this.brand = brand;
           // this.retailprice = retailprice;

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


        public String getBrand() {
            return brand;
        }

        public void setBrand(String data) {
            this.brand = data;
        }

        public void setRetailPrice(int retailPrice) {
            this.retailPrice = retailPrice;
        }

        public int getRetailPrice() {
            return retailPrice;
        }
    }



   /* @FXML
    void addData(ActionEvent actionEvent) {


        // postavljanje vrijednosti ćelija u tabeli
        dataColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dataColumnBarCode.setCellValueFactory(new PropertyValueFactory<>("barcode"));

        // kreiranje novog unosa na osnovu unesenih podataka
        int dataQ = Integer.parseInt(quantity.getText());
        int dataBC = Integer.parseInt(barcode.getText());

        cashRegisterService.addData(dataQ,dataBC);

        dataListCashRegister.add(new CashRegisterController.Data(dataQ,dataBC));
        tableView.setItems(dataListCashRegister);

        // čišćenje unesenih podataka
        quantity.clear();
        barcode.clear();
    }

   */
/*
    @FXML
    void addData(ActionEvent actionEvent) {

        dataColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dataColumnBarCode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        dataColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("brand"));
        dataColumnBarCode.setCellValueFactory(new PropertyValueFactory<>("retailprice"));

        int barcode = Integer.parseInt(this.barcode.getText());

        ProductController.Data product = productService.getProductByBarcode(barcode);
        if (product != null) {
            int quantity = Integer.parseInt(this.quantity.getText());

            CashRegisterController.Data newData = new CashRegisterController.Data(quantity, barcode);
            dataListCashRegister.add(newData);
            tableView.setItems(dataListCashRegister);

            // Set the brand and retail price in the TableView
            newData.setBrand(product.getBrand());
            newData.setRetailPrice(product.getRetailPrice());

            // Clear the input fields
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

*/

/*
    @FXML
    void addData(ActionEvent actionEvent) {

        // postavljanje vrijednosti ćelija u tabeli
        dataColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dataColumnBarCode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        dataColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("brand"));
        dataColumnBarCode.setCellValueFactory(new PropertyValueFactory<>("retailprice"));

        int barcode = Integer.parseInt(this.barcode.getText());

        ProductController.Data product = productService.getProductByBarcode(barcode);
        if (product != null) {
            int quantity = Integer.parseInt(this.quantity.getText());


            CashRegisterController.Data newData = new CashRegisterController.Data(quantity,barcode);

            // Set the brand and retail price in the new data object
            newData.setBrand(product.getBrand());
            newData.setRetailPrice(product.getRetailPrice());

            // Add the new data object to the dataListCashRegister
            dataListCashRegister.add(newData);

            // Update the TableView
            tableView.setItems(dataListCashRegister);

            // Clear the input fields
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
*/

    /*
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


    @FXML
    void addData(ActionEvent actionEvent) {
        // Obrada unosa u tabelu i repozitorij
        int dataQ = Integer.parseInt(quantity.getText());
        int dataBC = Integer.parseInt(barcode.getText());

        cashRegisterService.addData(dataQ, dataBC);

        // postavljanje vrijednosti ćelija u tabeli
        dataColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dataColumnBarCode.setCellValueFactory(new PropertyValueFactory<>("barcode"));

        // Ostatak koda za ažuriranje tabele i čišćenje unosa

        // čišćenje unesenih podataka
        quantity.clear();
        barcode.clear();
    }
*/

    @FXML
    void addData(ActionEvent actionEvent) {

        dataColumnBarCode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        dataColumnBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        dataColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dataColumnRetailPrice.setCellValueFactory(new PropertyValueFactory<>("retailPrice"));


        int barcode = Integer.parseInt(this.barcode.getText());
        ProductController.Data product = productService.getProductByBarcode(barcode);

        if (product != null) {
            int quantity = Integer.parseInt(this.quantity.getText());
            int retailPrice = product.getRetailPrice();

            CashRegisterController.Data newData = new CashRegisterController.Data(quantity, barcode);
            newData.setBrand(product.getBrand());
            newData.setRetailPrice(retailPrice);

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
