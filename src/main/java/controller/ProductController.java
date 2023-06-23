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
import service.ProductService;

import java.io.IOException;
import java.util.Optional;

/**
 * Kontroler klasa za funkcionalnost dodavanja, brisanja i mijenjanja proizvoda
 */
public class ProductController {

    private ProductService productService;
    @FXML
    public Button deleteButton;
    @FXML
    public Button updateButton;

    @FXML
    private Menu cashRegister;

    @FXML
    private Menu logOut;

    @FXML
    private TextField quantity;

    @FXML
    private TextField brand;

    @FXML
    private MenuButton category;

    @FXML
    private TextField costprice;

    @FXML
    private TextField retailprice;

    @FXML
    private TextField barcode;

    @FXML
    private TextArea description;

    @FXML
    private TableView<ProductController.Data> tableView;

    @FXML
    private TableColumn<ProductController.Data, Integer> idColumn;

    @FXML
    private TableColumn<ProductController.Data, Integer> dataColumnQuantity;

    @FXML
    private TableColumn<ProductController.Data, Integer> dataColumnCostPrice;

    @FXML
    private TableColumn<ProductController.Data, Integer> dataColumnRetailPrice;

    @FXML
    private TableColumn<ProductController.Data, Integer> dataColumnBarCode;

    @FXML
    private TableColumn<ProductController.Data, String> dataColumnBrand;

    @FXML
    private TableColumn<ProductController.Data, String> dataColumnCategory;

    @FXML
    private TableColumn<ProductController.Data, String> dataColumnDescription;


    private int id = 0;

    private ObservableList<ProductController.Data> dataListProduct = FXCollections.observableArrayList();

    /**
     * Konstruktor, inicijalizaciju objekta prilikom njegovog kreiranja.
     */
    public ProductController() {
        this.productService = new ProductService();
    }


    /**
     * Metoda koja se poziva prilikom akcije otvaranja blagajne.
     * Učitava FXML datoteku za prikaz blagajne i otvara novu scenu s drugim prozorom.
     *
     * @param actionEvent objekat tipa ActionEvent koji predstavlja akciju otvaranja blagajne
     * @throws IOException ako se javi greška prilikom učitavanja FXML datoteke ili otvaranja nove scene
     */
    @FXML
    void handlecashRegister(javafx.event.ActionEvent actionEvent) throws IOException {
        // Code to handle exit menu item
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CashRegister.fxml"));
        Parent root = loader.load();

        // Otvaranje nove scene s drugim prozorom
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        //isto
    }

    /**
     * Metoda koja se poziva prilikom akcije odjave korisnika.
     * Učitava FXML datoteku za prikaz prijave korisnika i otvara novu scenu s drugim prozorom.
     *
     * @param actionEvent objekat tipa ActionEvent koji predstavlja akciju odjave korisnika
     * @throws IOException ako se javi greška prilikom učitavanja FXML datoteke ili otvaranja nove scene
     */

    @FXML
    void logout(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogIn.fxml"));
        Parent root = loader.load();

        // Otvaranje nove scene s drugim prozorom
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Klasa koja predstavlja podatke o određenom proizvodu.
     */

    public static class Data {
        private int id;
        private int quantity;
        private int costprice;
        private int retailprice;
        private int barcode;

        private String description;

        private String brand;

        private String category;

        /**
         * Konstruktor za inicijalizaciju objekta klase Data.
         *
         * @param id           identifikator proizvoda
         * @param brand        marka proizvoda
         * @param category     kategorija proizvoda
         * @param costprice    nabavna cijena proizvoda
         * @param retailprice  prodajna cijena proizvoda
         * @param quantity     količina proizvoda
         * @param barcode      barkod proizvoda
         * @param description  opis proizvoda
         */

        public Data(int id, String brand, String category, int costprice, int retailprice, int quantity, int barcode, String description) {
            this.id = id;
            this.quantity = quantity;
            this.costprice = costprice;
            this.retailprice = retailprice;
            this.barcode = barcode;
            this.description = description;
            this.brand = brand;
            this.category = category;
        }


        /**
         * Vraća identifikator proizvoda.
         *
         * @return identifikator proizvoda
         */

        public int getId() {
            return id;
        }

        /**
         * Postavlja identifikator proizvoda.
         *
         * @param id identifikator proizvoda
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * Vraća količinu proizvoda.
         *
         * @return količina proizvoda
         */
        public int getQuantity() {
            return quantity;
        }

        /**
         * Vraća nabavnu cijenu proizvoda.
         *
         * @return nabavna cijena proizvoda
         */
        public int getCostPrice() {
            return costprice;
        }

        /**
         * Vraća prodajnu cijenu proizvoda.
         *
         * @return prodajna cijena proizvoda
         */
        public int getRetailPrice() {
            return retailprice;
        }

        /**
         * Vraća barkod proizvoda.
         *
         * @return barkod proizvoda
         */
        public int getBarcode() {
            return barcode;
        }

        /**
         * Vraća opis proizvoda.
         *
         * @return opis proizvoda
         */
        public String getDescription() {
            return description;
        }

        /**
         * Postavlja količinu proizvoda.
         *
         * @param data količina proizvoda
         */
        public void setQuantity(int data) {
            this.quantity = data;
        }

        /**
         * Postavlja nabavnu cijenu proizvoda.
         *
         * @param data nabavna cijena proizvoda
         */
        public void setCostPrice(int data) {
            this.costprice = data;
        }

        /**
         * Postavlja prodajnu cijenu proizvoda.
         *
         * @param data prodajna cijena proizvoda
         */
        public void setRetailPrice(int data) {
            this.retailprice = data;
        }

        /**
         * Postavlja barkod proizvoda.
         *
         * @param data barkod proizvoda
         */
        public void setBarcode(int data) {
            this.barcode = data;
        }

        /**
         * Postavlja opis proizvoda.
         *
         * @param data opis proizvoda
         */
        public void setDescription(String data) {
            this.description = data;
        }

        /**
         * Vraća marku proizvoda.
         *
         * @return marka proizvoda
         */
        public String getBrand() {
            return brand;
        }

        /**
         * Postavlja marku proizvoda.
         *
         * @param data marka proizvoda
         */
        public void setBrand(String data) {
            this.brand = data;
        }

        /**
         * Vraća kategoriju proizvoda.
         *
         * @return kategorija proizvoda
         */
        public String getCategory() {
            return category;
        }

        /**
         * Postavlja kategoriju proizvoda.
         *
         * @param data kategorija proizvoda
         */
        public void setCategory(String data) {
            this.category = data;
        }


    }

    //postavljanje odabranog polja iz liste u polje category
    /**
     * Metoda koja se poziva prilikom odabira kategorije iz padajućeg menija.
     * Postavlja odabranu kategoriju u tekstualno polje za kategoriju.
     *
     * @param actionEvent događaj koji je pokrenuo metodu
     */
    @FXML
    void selectCategory(ActionEvent actionEvent) {
        MenuItem selectedItem = (MenuItem) actionEvent.getSource();
        String selectedCategory = selectedItem.getText();
        category.setText(selectedCategory);
    }

    /**
     * Metoda koja se poziva prilikom dodavanja novih podataka o proizvodu.
     * Prikazuje unesene podatke u tabeli i ažurira prikaz.
     *
     * @param actionEvent događaj koji je pokrenuo metodu
     */
    @FXML
    void addData(ActionEvent actionEvent) {

        // Postavljanje vrijednosti za stupce u tabeli
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        dataColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dataColumnCostPrice.setCellValueFactory(new PropertyValueFactory<>("costPrice"));
        dataColumnRetailPrice.setCellValueFactory(new PropertyValueFactory<>("retailPrice"));
        dataColumnBarCode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        dataColumnBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        dataColumnCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        dataColumnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        // Dobijanje unesenih podataka
        String dataB = brand.getText();
        int dataQ = Integer.parseInt(quantity.getText());
        int dataCP = Integer.parseInt(costprice.getText());
        int dataRP = Integer.parseInt(retailprice.getText());
        int dataBC = Integer.parseInt(barcode.getText());
        String dataC = category.getText();
        String dataD = description.getText();
        id++;

        // Kreiranje novog proizvoda
        ProductController.Data newProduct = new ProductController.Data(id, dataB, dataC, dataCP, dataRP, dataQ, dataBC, dataD);
        productService.addProduct(newProduct);

        // Ažuriranje prikaza u tabeli
        ObservableList<ProductController.Data> allProducts = productService.getAllProducts();
        tableView.setItems(allProducts);

        // Čišćenje unesenih podataka
        quantity.clear();
        costprice.clear();
        retailprice.clear();
        barcode.clear();
        brand.clear();
        description.clear();
        //category.clear();
    }

    /**
     * Metoda koja se poziva prilikom ažuriranja podataka o odabranom proizvodu.
     * Otvara dijaloge za unos novih vrijednosti za marku, kategoriju, količinu,
     * nabavnu cijenu, prodajnu cijenu, barkod i opis proizvoda.
     * Ako su unesene nove vrijednosti, ažurira podatke odabranog proizvoda i osvježava prikaz u tabeli.
     *
     * @param event događaj koji je pokrenuo metodu
     */

    @FXML
    void updateData(ActionEvent event) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            ProductController.Data selectedData = tableView.getSelectionModel().getSelectedItem();

            // Dijalozi za unos novih vrijednosti
            TextInputDialog brandDialog = new TextInputDialog(selectedData.getBrand());
            brandDialog.setTitle("Update Brand");
            brandDialog.setHeaderText(null);
            brandDialog.setContentText("Enter brand:");

            TextInputDialog categoryDialog = new TextInputDialog(selectedData.getCategory());
            categoryDialog.setTitle("Update Category");
            categoryDialog.setHeaderText(null);
            categoryDialog.setContentText("Enter category:");

            TextInputDialog quantityDialog = new TextInputDialog(String.valueOf(selectedData.getQuantity()));
            quantityDialog.setTitle("Update Quantity");
            quantityDialog.setHeaderText(null);
            quantityDialog.setContentText("Enter quantity:");

            TextInputDialog costPriceDialog = new TextInputDialog(String.valueOf(selectedData.getCostPrice()));
            costPriceDialog.setTitle("Update Cost Price");
            costPriceDialog.setHeaderText(null);
            costPriceDialog.setContentText("Enter cost price:");

            TextInputDialog retailPriceDialog = new TextInputDialog(String.valueOf(selectedData.getRetailPrice()));
            retailPriceDialog.setTitle("Update Retail Price");
            retailPriceDialog.setHeaderText(null);
            retailPriceDialog.setContentText("Enter retail price:");

            TextInputDialog barcodeDialog = new TextInputDialog(String.valueOf(selectedData.getBarcode()));
            barcodeDialog.setTitle("Update Barcode");
            barcodeDialog.setHeaderText(null);
            barcodeDialog.setContentText("Enter barcode:");

            TextInputDialog descriptionDialog = new TextInputDialog(selectedData.getDescription());
            descriptionDialog.setTitle("Update Description");
            descriptionDialog.setHeaderText(null);
            descriptionDialog.setContentText("Enter description:");

            // Prikazivanje dijaloga i dobijanje rezultata unosa
            Optional<String> brandResult = brandDialog.showAndWait();
            Optional<String> categoryResult = categoryDialog.showAndWait();
            Optional<String> quantityResult = quantityDialog.showAndWait();
            Optional<String> costPriceResult = costPriceDialog.showAndWait();
            Optional<String> retailPriceResult = retailPriceDialog.showAndWait();
            Optional<String> barcodeResult = barcodeDialog.showAndWait();
            Optional<String> descriptionResult = descriptionDialog.showAndWait();

            if (brandResult.isPresent() && categoryResult.isPresent() && quantityResult.isPresent() && costPriceResult.isPresent() && retailPriceResult.isPresent() && barcodeResult.isPresent() && descriptionResult.isPresent()) {
                selectedData.setQuantity(Integer.parseInt(quantityResult.get()));
                selectedData.setCostPrice(Integer.parseInt(costPriceResult.get()));
                selectedData.setRetailPrice(Integer.parseInt(retailPriceResult.get()));
                selectedData.setBarcode(Integer.parseInt(barcodeResult.get()));
                selectedData.setDescription(descriptionResult.get());
                selectedData.setBrand(brandResult.get());
                selectedData.setCategory(categoryResult.get());

                productService.updateProduct(selectedData);

                tableView.refresh();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            //prozor za ispisivanje poruke
            alert.setTitle("No Selection");
            alert.setHeaderText("No Data Selected");
            alert.setContentText("Please select a data in the table.");
            alert.showAndWait();
        }
    }

    /**
     * Metoda koja se poziva prilikom brisanja odabranog proizvoda iz tabele.
     * Provjerava da li je odabran proizvod, a zatim ga briše iz liste proizvoda i osvježava prikaz u tabeli.
     *
     * @param event događaj koji je pokrenuo metodu
     */
    @FXML
    void deleteData(ActionEvent event) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            ProductController.Data selectedData = tableView.getSelectionModel().getSelectedItem();

            productService.deleteProduct(selectedData);
            // ProductService.deleteProduct(selectedData);

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

}
