import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class Model {
    private Body currentBody;
    private MVC view;
    private database db;

    public Model(){
        this.db = new database();
        this.view = new MVC();
        //adds action listeners to menuItems
        this.view.addDBLoadListener(new loadDBListener());
        this.view.addDBSaveListener(new saveDBListener());
        this.view.addLoadListener(new loadListener());
        this.view.addSaveListener(new saveListener());
        this.currentBody = view.getCurrentLogg();

    }

    //this loads a file with the specified name
    private class loadListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            //specifies what the name of the file is
            String FileName = JOptionPane.showInputDialog(null,"Write the name of the file");
            try {
                currentBody = fileManager.loadFile(FileName);
                view.setLogg(currentBody);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //saves the currentBody to a file with specified name
    private class saveListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            //filename will be specified
            String FileName = JOptionPane.showInputDialog(null, "Write the name of the file");
            try {
                currentBody = view.getCurrentLogg();
                fileManager.saveFile(currentBody, FileName);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //loads body from the specified id from the database to the current body and shows it.
    private class loadDBListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            try {
                view.setLogg(db.getData(Integer.parseInt(JOptionPane.showInputDialog(null, "write the id of the log"))));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    //will save the currentBody showing to the database
    private class saveDBListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            currentBody = view.getCurrentLogg();
            try {
                db.insertData(currentBody);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
