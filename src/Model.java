import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Model {
    private Body currentBody;
    private Save save;
    private MVC view;

    public Model(Save save){
        this.view = new MVC();
        this.view.addLoadListener(new loadListener());
        this.view.addSaveListener(new saveListener());
        this.currentBody = view.getCurrentLogg();
        this.save = new Save();

    }

    public void setLogg(Body body){
        view.setLogg(body);
    }

    public void saveCurrent(){
        save.saveBody(this.currentBody);
    }

    private class loadListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            view.setLogg(save.GetSave(Integer.parseInt(view.getLoadNumber())));
        }
    }

    private class saveListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            currentBody = view.getCurrentLogg();
            saveCurrent();
        }
    }
}
