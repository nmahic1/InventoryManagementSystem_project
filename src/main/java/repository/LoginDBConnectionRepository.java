/*package repository;
import java.sql.Connection;
import java.sql.DriverManager;

public class LoginDBConnectionRepository {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName ="ims";
        String databaseUser ="root";
        String databasePassword ="12345";
        String url="jdbc:mysql://localhost:3306/ims?useSSL=false&" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }

        return databaseLink;
    }

}
*/
/*LoginDBConnectionRepository je zadužen za komunikaciju s bazom podataka i
provjeru prijave. LoginService služi kao posrednik između kontrolera i
repozitorija te može dodati poslovnu logiku i validaciju ako je potrebno.
 LogInController upravlja korisničkim interakcijama i koristi LoginService za provjeru prijave.*/
package repository;

import java.sql.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class LoginDBConnectionRepository {


  /*  private Properties properties;

    public LoginDBConnectionRepository() {
        properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("src/main/resources/config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
