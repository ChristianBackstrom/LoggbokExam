import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class Model {
    private Body currentBody;
    private Save save;
    private MVC view;
    private database db;

    public Model(Save save){
        this.db = new database();
        this.view = new MVC();
        this.view.addDBLoadListener(new loadDBListener());
        this.view.addDBSaveListener(new saveDBListener());
        this.view.addLoadListener(new loadListener());
        this.view.addSaveListener(new saveListener());
        this.currentBody = view.getCurrentLogg();
        this.save = new Save();

    }

    public void setLogg(Body body){
        view.setLogg(body);
    }

    public void saveCurrent(Body body) throws SQLException {
        db.insertData(body);
        save.saveBody(body);
    }

    private class loadListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String FileName = JOptionPane.showInputDialog(null,"Write the name of the file");
            try {
                currentBody = fileManager.loadFile(FileName);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class saveListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String FileName = JOptionPane.showInputDialog(null, "Write the name of the file");
            try {
                fileManager.saveFile(currentBody, FileName);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class loadDBListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            try {
                view.setLogg(db.getData(Integer.parseInt(view.getLoadNumber())));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class saveDBListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            currentBody = view.getCurrentLogg();
            try {
                saveCurrent(currentBody);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
