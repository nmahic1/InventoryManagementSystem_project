
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
import repository.ProductRepository;
import service.CashRegisterService;
import service.ProductService;

import java.io.IOException;

public class CashRegisterController {
    @FXML
    public Button calculate;
    @FXML
    public TextField pay;
    @FXML
    public TextField balanceTextField;
    @FXML
    private TextField subtotal;
    @FXML
    public Button deleteButton;
    @FXML
    public Button addButton;
    @FXML
    private Menu product;
    @FXML
    private Menu logOut;
    @FXML
    private TextField quantity;
    @FXML
    private TextField barcode;

    public Button payinvoice;
    @FXML
    private TableView<Data> tableView;

    @FXML
    private TableColumn<Data, Integer> dataColumnBarCode;
    @FXML
    private TableColumn<Data, Integer> dataColumnQuantity;
    @FXML
    private TableColumn<Data, Integer> dataColumnRetailPrice;
    @FXML
    private TableColumn<Data, String> dataColumnBrand;
    @FXML
    private TableColumn<Data, Integer> dataColumnPrice;

    private ObservableList<Data> dataListCashRegister = FXCollections.observableArrayList();
    private CashRegisterService cashRegisterService;
    private ProductService productService;
    private ObservableList<ProductController> productList = FXCollections.observableArrayList();

    public CashRegisterController() {
       cashRegisterService = new CashRegisterService();
        productService = new ProductService();


    }

    @FXML
    void handleProduct(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Product.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void logout(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogIn.fxml"));
        Parent root = loader.load();
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

        private int id;

        public Data(int barcode, int quantity) {
            this.barcode = barcode;
            this.quantity = quantity;
            this.price = 0; // Initialize the price to 0
            updatePrice();
        }

        public int getQuantity() {
            return quantity;
        }

        public int getBarcode() {
            return barcode;
        }

        public void setBarcode(int barcode) {
            this.barcode = barcode;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public int getRetailPrice() {
            return retailPrice;
        }

        public void setRetailPrice(int retailPrice) {
            this.retailPrice = retailPrice;
            updatePrice();
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        private void updatePrice() {
            this.price = this.retailPrice * this.quantity;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    @FXML
    void addData(ActionEvent actionEvent) {

       /* dataColumnBarCode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        dataColumnBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        dataColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dataColumnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        int barcode = Integer.parseInt(this.barcode.getText());
        ProductController.Data product = productService.getProductByBarcode(barcode);

        if (product != null) {
            int quantity = Integer.parseInt(this.quantity.getText());
            int retailPrice = product.getRetailPrice();
            int price = quantity * retailPrice;

            Data newData = new Data(barcode, quantity);
            newData.setBrand(product.getBrand());
            newData.setRetailPrice(retailPrice);
            newData.setPrice(price);

            // Dodaj marku u objekt novog podatka
            newData.setBrand(product.getBrand());

            dataListCashRegister.add(newData);
            tableView.setItems(dataListCashRegister);

            // Upisivanje podataka u bazu podataka
            cashRegisterService.addData(quantity, product.getBrand(), barcode, retailPrice);

            this.quantity.clear();
            this.barcode.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Product Not Found");
            alert.setHeaderText("Product with the barcode " + barcode + " not found.");
            alert.setContentText("Please enter a valid barcode.");
            alert.showAndWait();
        }

        */

        dataColumnBarCode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        dataColumnBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        dataColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dataColumnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        int barcode = Integer.parseInt(this.barcode.getText());
        ProductController.Data product = productService.getProductByBarcode(barcode);

        if (product != null) {
            int quantity = Integer.parseInt(this.quantity.getText());
            int retailPrice = product.getRetailPrice();
            int price = quantity * retailPrice;

            Data newData = new Data(barcode, quantity);
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
    void deleteData(ActionEvent event) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Data selectedData = tableView.getItems().get(selectedIndex);
            tableView.getItems().remove(selectedIndex);
            cashRegisterService.removeData(selectedData);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
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

        int payAmount;
        try {
            payAmount = Integer.parseInt(pay.getText());
        } catch (NumberFormatException e) {
            payAmount = 0; // Set the pay amount to 0 if it's not a valid number
        }

        int balance = subtotalPrice - payAmount;
        int absoluteBalance = Math.abs(balance); // Calculate absolute value
        balanceTextField.setText(Integer.toString(absoluteBalance));
    }


}
