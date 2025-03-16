import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MicroProject extends JFrame {
    private JPanel lightP;
    private JButton redb, yellowb, greenb;
    private Color currentLight = Color.RED;

    public MicroProject (){
        setTitle("Traffic Light Simulator");

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        JPanel bPanel = new JPanel();
        redb = new JButton("Red");
        yellowb = new JButton("yellow");
        Greenb = new JButton("Green");

        // Traffic lights code goes here...

        // Adding the signal buttons to the frame.
        bPanel.add(redb);
        bPanel.add(yellowb);
        bPanel.add(greenb);

        setSize(300,400);
        setLayout(new BorderLayout());
    }

    public static void main(String[] args){
        new MicroProject();
    }
}