package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BrandAndCategoryRepository {
    private Connection connection;

    public BrandAndCategoryRepository(Connection connection) {
        this.connection = connection;
    }

    public void saveBrandAndCategory(String brand, String category) throws SQLException {
        String query = "INSERT INTO brandandcategory (brand, category) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, brand);
        statement.setString(2, category);
        statement.executeUpdate();
        statement.close();
    }
}

