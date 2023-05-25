package repository;
import controller.ProductController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepository {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ims?useSSL=false";
        String username = "root";
        String password = "12345";
        return DriverManager.getConnection(url, username, password);
    }


    public void addProduct(ProductController.Data product) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO tabela (quantity, cost_price, retail_price, barcode, description, brand, category) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, product.getQuantity());
            statement.setInt(2, product.getCostPrice());
            statement.setInt(3, product.getRetailPrice());
            statement.setInt(4, product.getBarcode());
            statement.setString(5, product.getDescription());
            statement.setString(6, product.getBrand());
            statement.setString(7, product.getCategory());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(ProductController.Data product) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE tabela SET quantity=?, cost_price=?, retail_price=?, barcode=?, description=?, brand=?, category=? WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, product.getId());
            statement.setInt(2, product.getQuantity());
            statement.setInt(3, product.getCostPrice());
            statement.setInt(4, product.getRetailPrice());
            statement.setInt(5, product.getBarcode());
            statement.setString(6, product.getDescription());
            statement.setString(7, product.getBrand());
            statement.setString(8, product.getCategory());


            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(ProductController.Data product) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM tabela WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, product.getId());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<ProductController.Data> getAllProducts() {
        ObservableList<ProductController.Data> productList = FXCollections.observableArrayList();

        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM tabela";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int quantity = resultSet.getInt("quantity");
                int costPrice = resultSet.getInt("cost_price");
                int retailPrice = resultSet.getInt("retail_price");
                int barcode = resultSet.getInt("barcode");
                String description = resultSet.getString("description");
                String brand = resultSet.getString("brand");
                String category = resultSet.getString("category");

                ProductController.Data product = new ProductController.Data(id, quantity, costPrice, retailPrice, barcode, description, brand, category);
                productList.add(product);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }
}
