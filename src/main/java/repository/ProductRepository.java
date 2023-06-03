
package repository;
import controller.ProductController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

public class ProductRepository {


   /* private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ims?useSSL=false";
        String username = "root";
        String password = "12345";
        return DriverManager.getConnection(url, username, password);
    }

    */

    //konfiguracija sa properties
    private static Connection getConnection() {
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

/*
    private static Properties properties;

    public ProductRepository() {
        if (properties == null) {
            properties = new Properties();
            try (InputStream inputStream = new FileInputStream("config.properties")) {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Connection getConnection() throws SQLException {
        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");
        return DriverManager.getConnection(url, username, password);
    }


 */


   public static void addProduct(ProductController.Data product) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO product ( brand, category, costPrice, retailPrice, quantity, barcode, description) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, product.getBrand());
            statement.setString(2, product.getCategory());
            statement.setInt(3, product.getCostPrice());
            statement.setInt(4, product.getRetailPrice());
            statement.setInt(5, product.getQuantity());
            statement.setInt(6, product.getBarcode());
            statement.setString(7, product.getDescription());


            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void updateProduct(ProductController.Data product) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE product SET brand=?, category=?, costPrice=?, retailPrice=?, quantity=?, barcode=?, description=? WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, product.getBrand());
            statement.setString(2, product.getCategory());
            statement.setInt(3, product.getCostPrice());
            statement.setInt(4, product.getRetailPrice());
            statement.setInt(5, product.getQuantity());
            statement.setInt(6, product.getBarcode());
            statement.setString(7, product.getDescription());
            statement.setInt(8, product.getId());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteProduct(ProductController.Data product) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM product WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, product.getId());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<ProductController.Data> getAllProducts() {
        ObservableList<ProductController.Data> productList = FXCollections.observableArrayList();

        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM product";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String category = resultSet.getString("category");
                int costPrice = resultSet.getInt("costPrice");
                int retailPrice = resultSet.getInt("retailPrice");
                int quantity = resultSet.getInt("quantity");
                int barcode = resultSet.getInt("barcode");
                String description = resultSet.getString("description");


                ProductController.Data product = new ProductController.Data(id,brand, category,costPrice, retailPrice, quantity,  barcode, description);
                productList.add(product);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public static ProductController.Data getProductByBarcode(int barcode) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM product WHERE barcode = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, barcode);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String category = resultSet.getString("category");
                int costPrice = resultSet.getInt("costPrice");
                int retailPrice = resultSet.getInt("retailPrice");
                int quantity = resultSet.getInt("quantity");
                String description = resultSet.getString("description");

                return new ProductController.Data(id, brand, category, costPrice, retailPrice, quantity, barcode, description);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Ako proizvod s traženim bar kodom nije pronađen
    }

}
