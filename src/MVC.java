import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MVC extends JFrame{
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu = new JMenu("File");
    private JMenuItem save = new JMenuItem("Save");
    private JMenuItem load = new JMenuItem("Load");
    private JPanel panel;
    private JTextArea body = new JTextArea("här kommer det stå text :)", 40, 80);
    private JTextField author = new JTextField("här kommer det stå författare", 80);
    private JButton saveButton;
    private JButton loadButton;
    private JTextField loadNumber = new JTextField(10);

    MVC(){
        this.panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.setJMenuBar(menuBar);
        this.menu.add(save);
        this.menu.add(load);
        this.menuBar.add(menu);
        this.setJMenuBar(menuBar);
        this.panel.add(menuBar);
        this.panel.add(this.loadButton);
        this.panel.add(this.loadNumber);
        this.panel.add(this.saveButton);
        this.panel.add(this.author);
        this.body.setLineWrap(true);
        this.panel.add(this.body);
        this.add(this.panel);
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

    public void setAuthor(String Author) {
        this.author.setText(Author);
    }

    public void setBody(String body) {
        this.body.setText(body);
    }

    public void setLoadNumber(String text){
        this.loadNumber.setText(text);
    }

    public String getLoadNumber(){
        return this.loadNumber.getText();
    }

    public String getAuthor() {
        return author.getText();
    }

    public String getBody() {
        return body.getText();
    }

    public Body getCurrentLogg(){
        return new Body(author.getText(), body.getText());
    }

    public void setLogg(Body body){
        this.body.setText(body.getText());
        this.author.setText(body.getCreator());
    }

}
