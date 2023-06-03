package repository;
import controller.CashRegisterController;

import java.io.FileInputStream;
import java.util.Properties;


import java.sql.*;

public class CashRegisterRepository {
    /*
    private ObservableList<CashRegisterController.Data> dataListCashRegister;

    public CashRegisterRepository() {
        dataListCashRegister = FXCollections.observableArrayList();
    }

    public void addData(CashRegisterController.Data data) {
        dataListCashRegister.add(data);
       // insertDataIntoDatabase(data);
    }

    public void removeData(CashRegisterController.Data data) {
        dataListCashRegister.remove(data);
    }

    public ObservableList<CashRegisterController.Data> getDataList() {
        return dataListCashRegister;
    }
*/

    //do ovog dijela
   /* private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ims?useSSL=false";
        String username = "root";
        String password = "12345";
        return DriverManager.getConnection(url, username, password);
    }

    */

    /*
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
*/

    private Connection getConnection() {
      /*  Connection databaseLink = null;
        String databaseName = "ims";
        String databaseUser = "root";
        String databasePassword = "12345";
        String url = "jdbc:mysql://localhost:3306/ims?useSSL=false&" + databaseName;


       */

        Connection databaseLink = null;

        try {
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            properties.load(fis);

            String databaseName = properties.getProperty("db.name");
            String databaseUser = properties.getProperty("db.username");
            String databasePassword = properties.getProperty("db.password");
            String url = properties.getProperty("db.url");

            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;
    }


    public void addProduct(CashRegisterController.Data cashregister) {
        try (Connection connection = getConnection()) {
           // String query = "INSERT INTO cashregister (barcode, quantity, name, price) " +"VALUES (?, ?, ?, ?)";
            String query = "INSERT INTO cashregister (barcode, quantity, name, price) " +
                    "SELECT ?, ?, brand, ? FROM product WHERE barcode = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cashregister.getBarcode());
            statement.setInt(2, cashregister.getQuantity());
            statement.setString(3, cashregister.getBrand());
            statement.setInt(4, cashregister.getRetailPrice());


            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(CashRegisterController.Data cashregister) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM cashregister WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cashregister.getId());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
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


*/
}



