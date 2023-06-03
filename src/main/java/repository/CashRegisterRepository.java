package repository;
import controller.CashRegisterController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;


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

   /* private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ims?useSSL=false";
        String username = "root";
        String password = "12345";
        return DriverManager.getConnection(url, username, password);
    }

    */

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();

        try (InputStream inputStream = CashRegisterRepository.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        return DriverManager.getConnection(url, username, password);
    }


    private void insertDataIntoDatabase(CashRegisterController.Data data) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO cashregister (barcode, quantity, name, price) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, data.getBarcode());
            statement.setInt(2, data.getQuantity());
            statement.setString(3, data.getBrand());
            statement.setInt(4, data.getPrice());

            statement.executeUpdate();

            // Retrieve the generated ID
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                data.setId(generatedId);
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}



