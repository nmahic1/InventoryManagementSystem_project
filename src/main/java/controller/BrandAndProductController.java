package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;



public class BrandAndProductController {

       @FXML
        private Menu brandAndProduct;

        @FXML
        private Menu product;

        @FXML
        private Menu cashRegister;

        @FXML
        private Menu logOut;



        //tabela,i dodavanje elemenata
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

        //dugme za delete u update
        @FXML
        private Button deleteButton;

        @FXML
        private Button updateButton;



    //meni
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

    //tabela i dodavanje elemenata
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

        //delete i update dugme u product and brand
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
        void updateData(javafx.event.ActionEvent event) {

            int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                Data selectedData = tableView.getSelectionModel().getSelectedItem();
                TextInputDialog brandDialog = new TextInputDialog(selectedData.getBrand());

                //prozor za ispisivanje poruke
                brandDialog.setTitle("Update Data");
                brandDialog.setHeaderText("Update selected data");
                brandDialog.setContentText("Enter brand name:");

                TextInputDialog categoryDialog = new TextInputDialog(selectedData.getCategory());
                //prozor za ispisivanje poruke
                categoryDialog.setTitle("Update Data");
                categoryDialog.setHeaderText("Update selected data");
                categoryDialog.setContentText("Enter category name:");

                Optional<String> brandResult = brandDialog.showAndWait();
                Optional<String> categoryResult = categoryDialog.showAndWait();
                if (brandResult.isPresent() && categoryResult.isPresent()) {
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

}

