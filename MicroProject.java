import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MicroProject extends JFrame {
    private JPanel lightP;
    private JButton redb, yellowb, grrenb;
    private Color currentLight = Color.RED;

    public MicroProject (){
        setTitle("Traffic Light Simulator");

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setSize(300,400);
        setLayout(new BorderLayout());
    }

    public static void main(String[] args){
        new MicroProject();
    }
}