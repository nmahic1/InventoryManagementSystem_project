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
import service.ProductService;

import java.io.IOException;

/**
 * Kontroler klasa za funkcionalnost dodavanja, brisanja i mijenjanja proizvoda u kasu
 */
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

    /**
     * Konstruktor klase CashRegisterController.
     * Inicijalizira CashRegisterService i ProductService objekte koji se koriste za obradu podataka vezanih za kasu i proizvode.
     */
    public CashRegisterController() {
        cashRegisterService = new CashRegisterService();
        productService = new ProductService();
    }

    /**
     * Metoda koja se poziva prilikom obrade događaja pritiska na dugme "Product".
     * Otvara novi prozor koji prikazuje proizvode.
     *
     * @param actionEvent događaj koji je pokrenuo metodu
     * @throws IOException ako se desi greška prilikom učitavanja FXML datoteke ili otvaranja prozora
     */
    @FXML
    void handleProduct(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Product.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metoda koja se poziva prilikom akcije odjave korisnika.
     * Učitava FXML datoteku za prikaz prijave korisnika i otvara novu scenu s drugim prozorom.
     *
     * @param actionEvent objekat tipa ActionEvent koji predstavlja akciju odjave korisnika
     * @throws IOException ako se javi greška prilikom učitavanja FXML datoteke ili otvaranja nove scene
     */

    @FXML
    void logout(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogIn.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Klasa koja predstavlja podatke o određenom proizvodu.
     */
    public static class Data {
        private int quantity;
        private int barcode;
        private String brand;
        private int retailPrice;
        private int price;
        private int id;

        /**
         * Konstruktor koji inicijalizuje podatke o proizvodu sa zadatim barkodom i količinom.
         *
         * @param barcode  barkod proizvoda
         * @param quantity količina proizvoda
         */
        public Data(int barcode, int quantity) {
            this.barcode = barcode;
            this.quantity = quantity;
            //this.price = 0; // Initialize the price to 0
            updatePrice();
        }

        /**
         * Metoda za dobijanje količine proizvoda.
         *
         * @return količina proizvoda
         */
        public int getQuantity() {
            return quantity;
        }

        /**
         * Metoda za dobijanje barkoda proizvoda.
         *
         * @return barkod proizvoda
         */
        public int getBarcode() {
            return barcode;
        }

        /**
         * Metoda za postavljanje barkoda proizvoda.
         *
         * @param barcode barkod proizvoda
         */
        public void setBarcode(int barcode) {
            this.barcode = barcode;
        }

        /**
         * Metoda za dobijanje brenda proizvoda.
         *
         * @return brend proizvoda
         */
        public String getBrand() {
            return brand;
        }

        /**
         * Metoda za postavljanje brenda proizvoda.
         *
         * @param brand brend proizvoda
         */
        public void setBrand(String brand) {
            this.brand = brand;
        }

        /**
         * Metoda za dobijanje maloprodajne cijene proizvoda.
         *
         * @return maloprodajna cijena proizvoda
         */
        public int getRetailPrice() {
            return retailPrice;
        }

        /**
         * Metoda za postavljanje maloprodajne cijene proizvoda.
         * Nakon postavljanja cijene, ažurira se ukupna cijena proizvoda.
         *
         * @param retailPrice maloprodajna cijena proizvoda
         */
        public void setRetailPrice(int retailPrice) {
            this.retailPrice = retailPrice;
            updatePrice();
        }

        /**
         * Metoda za dobijanje ukupne cijene proizvoda.
         *
         * @return ukupna cijena proizvoda
         */
        public int getPrice() {
            return price;
        }

        /**
         * Metoda za postavljanje ukupne cijene proizvoda.
         *
         * @param price ukupna cijena proizvoda
         */
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
        dataColumnBarCode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        dataColumnBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        dataColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dataColumnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        int barcode = Integer.parseInt(this.barcode.getText());
        ProductController.Data product = productService.getProductByBarcode(barcode);

        if (product != null) {
            int quantity = Integer.parseInt(this.quantity.getText());
            int retailPrice = product.getRetailPrice();
            int price = retailPrice * quantity;

            Data newData = new Data(barcode, quantity);
            newData.setBrand(product.getBrand());
            newData.setRetailPrice(retailPrice);
            newData.setPrice(price);

            cashRegisterService.addProduct(newData);

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
            Data selectedData = tableView.getSelectionModel().getSelectedItem();

            cashRegisterService.deleteProduct(selectedData);

            tableView.getItems().remove(selectedIndex);
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

        int balance = payAmount - subtotalPrice;
        int absoluteBalance = Math.abs(balance); // Calculate absolute value
        balanceTextField.setText(Integer.toString(absoluteBalance));
    }
}
