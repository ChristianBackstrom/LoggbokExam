import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class fileManager {

    public static void saveFile(Body body, String fileName) throws IOException {

        //chooses the name of the file and creates it
        PrintWriter outputStream = new PrintWriter(fileName);

        try {
            //prints the text and author as 2 lines in a .txt file
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
            //writes the name of the file and checks if it exists
            File file = new File(fileName);
            Scanner rdr = new Scanner(file);
            //reads the file and gets the first row as the author and the second as the text
            author = rdr.nextLine();
            text = rdr.nextLine();
        } catch (FileNotFoundException e) {
            //if file does not exists it shows this message dialog
            JOptionPane.showMessageDialog(null, "File does not exist");
        }
        return new Body(author, text);
    }
}
