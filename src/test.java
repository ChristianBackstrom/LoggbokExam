import java.io.IOException;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Body body = new Body("hej", "ohsa");
        fileManager.saveFile(body, "save");
        System.out.println(fileManager.loadFile("save"));
    }
}
