import javax.swing.*;
import java.io.*;

public class fileManager {

    public static void saveFile(Body body, String fileName) throws IOException {
        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            out.writeObject(body.getCreatorString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    public static Body loadFile(String fileName) throws IOException, ClassNotFoundException {

        ObjectInputStream in = null;
        Body body = null;

        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            body = (Body) in.readObject();
            return body;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File does not exist" + "/n " + e.getMessage());
        } finally {
            in.close();
        }

        return body;
    }
}
