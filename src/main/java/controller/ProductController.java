package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ProductController {

    @FXML
    private Menu brandAndProduct;

    @FXML
    private Menu product;

    @FXML
    private Menu cashRegister;

    @FXML
    private Menu logOut;

    @FXML
    private TextField product1;

    @FXML
    private TextField quantity;

    @FXML
    private TextField costprice;

    @FXML
    private TextField retailprice;

    @FXML
    private TextField barcode;

    @FXML
    private TableView<ProductController.Data> tableView;

    @FXML
    private TableColumn<ProductController.Data, Integer> idColumn;

    @FXML
    private TableColumn<ProductController.Data, String> dataColumnProduct;

    @FXML
    private TableColumn<ProductController.Data, String> dataColumnQuantity;

    @FXML
    private TableColumn<ProductController.Data, String> dataColumnCostPrice;

    @FXML
    private TableColumn<ProductController.Data, String> dataColumnRetailPrice;

    @FXML
    private TableColumn<ProductController.Data, String> dataColumnBarCode;

    private int id = 0;

    private ObservableList<ProductController.Data> dataListProduct = FXCollections.observableArrayList();


    public void logout(javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogIn.fxml"));
        Parent root = loader.load();

        // Otvaranje nove scene s drugim prozorom
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void addData(javafx.event.ActionEvent actionEvent) {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        dataColumnProduct.setCellValueFactory(new PropertyValueFactory<>("product"));
        dataColumnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dataColumnCostPrice.setCellValueFactory(new PropertyValueFactory<>("cost price"));
        dataColumnRetailPrice.setCellValueFactory(new PropertyValueFactory<>("retail price"));
        dataColumnBarCode.setCellValueFactory(new PropertyValueFactory<>("bar code"));

        String dataP = product1.getText();
        String dataQ = quantity.getText();
        String dataCP = costprice.getText();
        String dataRP = retailprice.getText();
        int dataBC = Integer.parseInt(barcode.getText());
        id++;
        dataListProduct.add(new ProductController.Data(id, dataP, dataQ, dataCP,dataRP, dataBC));
        tableView.setItems(dataListProduct);
        product1.clear();
        quantity.clear();
        costprice.clear();
        retailprice.clear();
        barcode.clear();
    }

    public class Data {
        private int id;
        private String product1;
        private String quantity;
        private String costprice;
        private String retailprice;
        private int barcode;

        public Data(int id, String product1, String quantity,String costprice, String retailprice, int barcode ) {
            this.id = id;
            this.product1 = product1;
            this.quantity = quantity;
            this.costprice = costprice;
            this.retailprice = retailprice;
            this.barcode = barcode;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getProduct1() {
            return product1;
        }

        public String getQuantity() {
            return quantity;
        }

        public String getCostPrice() {
            return costprice;
        }

        public String getRetailPrice() {
            return retailprice;
        }

        public int getBarcode() {
            return barcode;
        }


        public void setProduct1(String data) {
            this.product1 = data;
        }

        public void setQuantity(String data) {
            this.quantity = data;
        }

        public void setCostPrice(String data) {
            this.costprice = data;
        }

        public void setRetailPrice(String data) {
            this.retailprice = data;
        }

        public void setBarcode(int data) {
            this.barcode = data;
        }
    }
}
