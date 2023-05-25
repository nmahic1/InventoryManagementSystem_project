package repository;
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
