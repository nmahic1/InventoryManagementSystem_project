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


public class ProductController {

   // private ProductService productService;

    @FXML
    public Button deleteButton;
   @FXML
   public Button updateButton;

   // @FXML
   // private Menu brandAndProduct;

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

    /*
    @FXML
    void handleBrandAndProduct(javafx.event.ActionEvent actionEvent) throws IOException{
        // Code to handle save menu item
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BrandAndProduct.fxml"));
        Parent root = loader.load();

        // Otvaranje nove scene s drugim prozorom
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


     */
    @FXML
    void handlecashRegister(javafx.event.ActionEvent actionEvent) throws IOException{
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
    @FXML
     void addData(ActionEvent actionEvent) {


            // postavljanje vrijednosti ćelija u tabeli
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            dataColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
            dataColumnCostPrice.setCellValueFactory(new PropertyValueFactory<>("costPrice"));
            dataColumnRetailPrice.setCellValueFactory(new PropertyValueFactory<>("retailPrice"));
            dataColumnBarCode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
             dataColumnBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
             dataColumnCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
            dataColumnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));


            // kreiranje novog unosa na osnovu unesenih podataka
            String dataB = brand.getText();
            int dataQ = Integer.parseInt(quantity.getText());
            int dataCP = Integer.parseInt(costprice.getText());
            int dataRP = Integer.parseInt(retailprice.getText());
            int dataBC = Integer.parseInt(barcode.getText());
            String dataC = category.getText();
            String dataD = description.getText();
            id++;
           dataListProduct.add(new Data(id, dataQ, dataCP, dataRP, dataBC, dataD, dataB, dataC));
            tableView.setItems(dataListProduct);

            // čišćenje unesenih podataka
            quantity.clear();
            costprice.clear();
            retailprice.clear();
            barcode.clear();
            brand.clear();
            description.clear();
            //category.clear();

    }





    public static class Data {
        private int id;
        private int quantity;
        private int costprice;
        private int retailprice;
        private int barcode;

        private String description;

        private String brand;

        private String category;


        public Data(int id, int quantity, int costprice, int retailprice, int barcode, String description, String brand, String category) {
            this.id = id;
            this.quantity = quantity;
            this.costprice = costprice;
            this.retailprice = retailprice;
            this.barcode = barcode;
            this.description = description;
            this.brand = brand;
            this.category = category;
        }



        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public int getQuantity() {
            return quantity;
        }

        public int getCostPrice() {
            return costprice;
        }

        public int getRetailPrice() {
            return retailprice;
        }

        public int getBarcode() {
            return barcode;
        }

        public String getDescription() {
            return description;
        }


        public void setQuantity(int data) {
            this.quantity = data;
        }

        public void setCostPrice(int data) {
            this.costprice = data;
        }

        public void setRetailPrice(int data) {
            this.retailprice = data;
        }

        public void setBarcode(int data) {
            this.barcode = data;
        }

        public void setDescription(String data) {
            this.description = data;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String data) {
            this.brand = data;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String data) { this.category = data;}


    }

   /* public ProductController() {
        this.productService = new ProductService();
    }

    */


    @FXML
    void updateData(javafx.event.ActionEvent event) {

        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            ProductController.Data selectedData = tableView.getSelectionModel().getSelectedItem();
            int selectedQuantity = selectedData.getQuantity();

            TextInputDialog brandDialog = new TextInputDialog(selectedData.getBrand());

            //prozor za ispisivanje poruke
            brandDialog.setTitle("Update Data");
            brandDialog.setHeaderText("Update selected data");
            brandDialog.setContentText("Enter brand name:");

            TextInputDialog categoryDialog = new TextInputDialog(selectedData.getCategory());

            //prozor za ispisivanje poruke
            categoryDialog.setTitle("Update Data");
            categoryDialog.setHeaderText("Update selected data");
            categoryDialog.setContentText("Enter brand name:");

            TextInputDialog quantityDialog = new TextInputDialog(String.valueOf(selectedQuantity));

            //prozor za ispisivanje poruke
            quantityDialog.setTitle("Update Data");
            quantityDialog.setHeaderText("Update selected data");
            quantityDialog.setContentText("Enter quantity:");

            int selectedCostPrice = selectedData.getCostPrice();

            TextInputDialog costPriceDialog = new TextInputDialog(String.valueOf(selectedCostPrice));

            //prozor za ispisivanje poruke
            costPriceDialog.setTitle("Update Data");
            costPriceDialog.setHeaderText("Update selected data");
            costPriceDialog.setContentText("Enter cost price:");

            int selectedRetailPrice = selectedData.getRetailPrice();

            TextInputDialog retailPriceDialog = new TextInputDialog(String.valueOf(selectedRetailPrice));

            //prozor za ispisivanje poruke
            retailPriceDialog.setTitle("Update Data");
            retailPriceDialog.setHeaderText("Update selected data");
            retailPriceDialog.setContentText("Enter cost price:");

            int selectedBarcode = selectedData.getBarcode();

            TextInputDialog BarcodeDialog = new TextInputDialog(String.valueOf(selectedBarcode));

            //prozor za ispisivanje poruke
            BarcodeDialog.setTitle("Update Data");
            BarcodeDialog.setHeaderText("Update selected data");
            BarcodeDialog.setContentText("Enter cost price:");

            TextInputDialog descriptionDialog = new TextInputDialog(selectedData.getDescription());
            //prozor za ispisivanje poruke
            descriptionDialog.setTitle("Update Data");
            descriptionDialog.setHeaderText("Update selected data");
            descriptionDialog.setContentText("Enter category name:");

            Optional<String> quantityResult = quantityDialog.showAndWait();
            Optional<String> costPriceResult = costPriceDialog.showAndWait();
            Optional<String> retailPriceResult = retailPriceDialog.showAndWait();
            Optional<String> barcodeResult = BarcodeDialog.showAndWait();
            Optional<String> descriptionResult = descriptionDialog.showAndWait();
            Optional<String> brandResult = brandDialog.showAndWait();
            Optional<String> categoryResult = categoryDialog.showAndWait();


            if (brandResult.isPresent() && categoryResult.isPresent() && quantityResult.isPresent() && costPriceResult.isPresent()&& retailPriceResult.isPresent() && barcodeResult.isPresent() && descriptionResult.isPresent()) {
                selectedData.setQuantity(Integer.parseInt(quantityResult.get()));
                selectedData.setCostPrice(Integer.parseInt(costPriceResult.get()));
                selectedData.setRetailPrice(Integer.parseInt(retailPriceResult.get()));
                selectedData.setBarcode(Integer.parseInt(barcodeResult.get()));
                selectedData.setDescription(descriptionResult.get());
                selectedData.setBrand(brandResult.get());
                selectedData.setCategory(categoryResult.get());
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


    //postavljanje odabranog polja iz liste u polje category
    @FXML
    void selectCategory(ActionEvent actionEvent) {
        MenuItem selectedItem = (MenuItem) actionEvent.getSource();
        String selectedCategory = selectedItem.getText();
        category.setText(selectedCategory);
    }

    /*
    @FXML
    void addData(ActionEvent actionEvent) {
        String dataB = brand.getText();
        int dataQ = Integer.parseInt(quantity.getText());
        int dataCP = Integer.parseInt(costprice.getText());
        int dataRP = Integer.parseInt(retailprice.getText());
        int dataBC = Integer.parseInt(barcode.getText());
        String dataC = category.getText();
        String dataD = description.getText();
        id++;

        ProductController.Data newProduct = new ProductController.Data(id, dataQ, dataCP, dataRP, dataBC, dataD, dataB, dataC);
        productService.addProduct(newProduct);

        ObservableList<ProductController.Data> allProducts = productService.getAllProducts();
        tableView.setItems(allProducts);

        quantity.clear();
        costprice.clear();
        retailprice.clear();
        barcode.clear();
        brand.clear();
        description.clear();
    }

    @FXML
    void updateData(ActionEvent event) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            ProductController.Data selectedData = tableView.getSelectionModel().getSelectedItem();

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

    @FXML
    void deleteData(ActionEvent event) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            ProductController.Data selectedData = tableView.getSelectionModel().getSelectedItem();

            productService.deleteProduct(selectedData);

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
*/

}
