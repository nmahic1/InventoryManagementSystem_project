package repository;

import java.sql.*;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Klasa LoginDBConnectionRepository pruža funkcionalnosti za validaciju korisničkih prijava putem baze podataka.
 * Omogućava provjeru ispravnosti korisničkog imena i lozinke.
 */
public class LoginDBConnectionRepository {
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

    public boolean validateLogin(String username, String password) {
        Connection connectDB = getConnection();
        boolean isValidLogin = false;

        String verifyLogin = "SELECT count(1) FROM useraccounts WHERE username = ? AND passwordl = ?";

        try {
            PreparedStatement statement = connectDB.prepareStatement(verifyLogin);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet queryResult = statement.executeQuery();

            if (queryResult.next()) {
                int count = queryResult.getInt(1);
                isValidLogin = count == 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Zatvorite PreparedStatement i Connection
            // Možete koristiti try-with-resources blok za automatsko zatvaranje resursa u novijim verzijama Jave
            try {
                if (connectDB != null) {
                    connectDB.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isValidLogin;
    }
}
