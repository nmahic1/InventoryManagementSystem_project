package repository;
/*
import controller.CashRegisterController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CashRegisterRepository {
    private ObservableList<CashRegisterController.Data> dataListCashRegister;

    public CashRegisterRepository() {
        dataListCashRegister = FXCollections.observableArrayList();
    }

    public void addData(CashRegisterController.Data data) {
        dataListCashRegister.add(data);
    }

    public void removeData(CashRegisterController.Data data) {
        dataListCashRegister.remove(data);
    }

    public ObservableList<CashRegisterController.Data> getDataList() {
        return dataListCashRegister;
    }

    private void insertDataIntoDatabase(CashRegisterController.Data data) {
        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", "root", "12345");

            // Prepare the SQL statement
            String query = "INSERT INTO cashregister (barcode, name, quantity, price) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, data.getBarcode());
            statement.setString(2, data.getBrand());
            statement.setInt(3, data.getQuantity());
            statement.setInt(4, data.getRetailPrice());

            // Execute the statement
            statement.executeUpdate();

            // Close the resources
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
*/


import controller.CashRegisterController;
import controller.ProductController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class CashRegisterRepository {
    private ObservableList<CashRegisterController.Data> dataListCashRegister;

    public CashRegisterRepository() {
        dataListCashRegister = FXCollections.observableArrayList();
    }

    public void addData(CashRegisterController.Data data) {
        dataListCashRegister.add(data);
        insertDataIntoDatabase(data);
    }

    public void removeData(CashRegisterController.Data data) {
        dataListCashRegister.remove(data);
    }

    public ObservableList<CashRegisterController.Data> getDataList() {
        return dataListCashRegister;
    }

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ims?useSSL=false";
        String username = "root";
        String password = "12345";
        return DriverManager.getConnection(url, username, password);
    }

    private void insertDataIntoDatabase(CashRegisterController.Data data) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO cashregister (quantity, barcode, name, price)" +" VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, data.getQuantity());
            statement.setInt(2, data.getBarcode());
            statement.setString(3, data.getBrand());
            statement.setInt(4, data.getRetailPrice());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}


