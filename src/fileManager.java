import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class fileManager {

    public static void saveFile(Body body, String fileName) throws IOException {

        PrintWriter outputStream = new PrintWriter(fileName);

        try {
            outputStream.println(body.getCreator());
            outputStream.println(body.getText());
        } finally {
            outputStream.close();
        }
    }

    public static Body loadFile(String fileName) throws FileNotFoundException {

        String text = "not a valid";
        String author = "not a valid";

        try {
            File file = new File(fileName);
            Scanner rdr = new Scanner(file);
            author = rdr.nextLine();
            text = rdr.nextLine();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File does not exist");
        }
        return new Body(author, text);
    }
}
