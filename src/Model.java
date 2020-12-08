import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Model {
    private Body currentBody;
    private Save save;
    private MVC view;
    private database db;

    public Model(Save save){
        this.db = new database();
        this.view = new MVC();
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
    }

    private class loadListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            try {
                view.setLogg(db.getData(Integer.parseInt(view.getLoadNumber())));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class saveListener implements ActionListener {
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
