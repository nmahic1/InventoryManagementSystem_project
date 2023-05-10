package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

    public class BrandAndProductController {

        @FXML
        private Menu brandAndProduct;

        @FXML
        private Menu product;

        @FXML
        private Menu cashRegister;

        @FXML
        private Menu logOut;

        @FXML
        private TextField brand;

        @FXML
        private TextField category;

        @FXML
        private TableView<Data> tableView;

        @FXML
        private TableColumn<Data, Integer> idColumn;

        @FXML
        private TableColumn<Data, String> dataColumnBrand;

        @FXML
        private TableColumn<Data, String> dataColumnCategory;

        private int id = 0;

        private ObservableList<Data> dataListBrandCategory = FXCollections.observableArrayList();

        public void addData(javafx.event.ActionEvent actionEvent) {

            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            dataColumnBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
            dataColumnCategory.setCellValueFactory(new PropertyValueFactory<>("category"));

            String dataB = brand.getText();
            String dataC = category.getText();
            id++;
            dataListBrandCategory.add(new Data(id, dataB, dataC));
            tableView.setItems(dataListBrandCategory);
            brand.clear();
            category.clear();
        }

        public class Data {
            private int id;
            private String brand;
            private String category;

            public Data(int id, String brand, String category) {
                this.id = id;
                this.brand = brand;
                this.category = category;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getBrand() {
                return brand;
            }

            public String getCategory() {
                return category;
            }

            public void setBrand(String data) {
                this.brand = data;
            }

            public void setCategory(String data) {
                this.category = data;
            }
        }

        @FXML
        void handlebrandAndProduct(ActionEvent event) {
            // Code to handle open menu item
        }

        @FXML
        void handleproduct(ActionEvent event) {
            // Code to handle save menu item
        }

        @FXML
        void handlecashRegister(ActionEvent event) {
            // Code to handle exit menu item
        }

        public void logout(javafx.event.ActionEvent actionEvent) throws IOException {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogIn.fxml"));
                Parent root = loader.load();

                // Otvaranje nove scene s drugim prozorom
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();

        }
    }

