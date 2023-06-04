package repository;
import controller.CashRegisterController;
import java.io.FileInputStream;
import java.util.Properties;
import java.sql.*;

public class CashRegisterRepository {

    private Connection getConnection() {

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
}



