import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class database {
    public static void main(String[] args) {
        try {
            // Set up connection to database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://" + databaseConfig.DBURL + ":" + databaseConfig.port + "/" + databaseConfig.DBname +
                            "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    databaseConfig.user, databaseConfig.password);

            // Setup statement
            Statement stmt = conn.createStatement();
            Scanner tgb = new Scanner(System.in);
            int currentRoom = 1;

            // Create query and execute
                String strSelect = "select body from logg";
                //System.out.println("The SQL statement is: " + strSelect + "\n");

                ResultSet rset = stmt.executeQuery(strSelect);

                // Loop through the result set and print
                //System.out.println("The records selected are:");
                while (rset.next()) {
                    String body = rset.getString("body");
                    System.out.println(body);
                }
            // Close conn and stmt
            conn.close();
            stmt.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Body getData(int i) throws SQLException {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://" + databaseConfig.DBURL + ":" + databaseConfig.port + "/" + databaseConfig.DBname +
                        "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                databaseConfig.user, databaseConfig.password);

        Statement stmt = conn.createStatement();

        String body = "not a valid id";
        String author = "not a valid id";

        String authorSelect = "select author from logg where id = " + i;
        String bodySelect = "select body from logg where id = " + i;

        ResultSet rset = stmt.executeQuery(authorSelect);

        while(rset.next())
            author = rset.getString("author");

        rset = stmt.executeQuery(bodySelect);

            while(rset.next())
                body = rset.getString("body");

        return new Body(new User(author), body);
    }

    public void insertData(Body body1) throws SQLException{

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://" + databaseConfig.DBURL + ":" + databaseConfig.port + "/" + databaseConfig.DBname +
                        "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                databaseConfig.user, databaseConfig.password);

        Statement stmt = conn.createStatement();

        String body = body1.getText();
        String author = body1.getCreatorString();

        String loggSave = "INSERT INTO logg (author, body) VALUES ( '" + author + "','" + body + "')";

        stmt.executeUpdate(loggSave);
    }
}
