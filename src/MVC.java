import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MVC extends JFrame{
    private JMenuBar menuBar = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenu db = new JMenu("database");
    private JMenuItem save = new JMenuItem("Save");
    private JMenuItem load = new JMenuItem("Load");
    private JPanel panel;
    private JTextArea body = new JTextArea("här kommer det stå text :)", 40, 70);
    private JTextField author = new JTextField("här kommer det stå författare", 70);
    private JMenuItem saveButton = new JMenuItem("save");
    private JMenuItem loadButton = new JMenuItem("load");

    MVC(){
        this.panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.file.add(save);
        this.file.add(load);
        this.menuBar.add(file);
        this.db.add(saveButton);
        this.db.add(loadButton);
        this.menuBar.add(db);
        this.panel.add(menuBar);
        this.panel.add(this.author);
        this.body.setLineWrap(true);
        this.panel.add(this.body);
        this.add(this.panel);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    void addLoadListener(ActionListener listenForLoadListener) {
        this.load.addActionListener(listenForLoadListener);
    }

    void addSaveListener(ActionListener listenForSaveListener){
        this.save.addActionListener(listenForSaveListener);
    }

    void addDBLoadListener(ActionListener listenForLoadListener) {
        this.loadButton.addActionListener(listenForLoadListener);
    }

    void addDBSaveListener(ActionListener listenForSaveListener){
        this.saveButton.addActionListener(listenForSaveListener);
    }

    public Body getCurrentLogg(){
        return new Body(author.getText(), body.getText());
    }

    public void setLogg(Body body){
        this.body.setText(body.getText());
        this.author.setText(body.getCreator());
    }

}
