import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MVC extends JFrame{
    private JPanel panel;
    private JTextArea bodyText;
    private JTextField author;
    private JButton saveButton;
    private JButton loadButton;
    private JTextField loadNumber;

    MVC(){
        this.panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.panel.add(this.loadButton);
        this.panel.add(this.loadNumber);
        this.panel.add(this.saveButton);
        this.panel.add(this.author);
        this.panel.add(this.bodyText);
    }
}
