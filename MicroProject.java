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
        
        // Light Panel (Traffic Light Display).
        lightP = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillRect(100, 50, 100, 300);

                g.setColor(currentLight == Color.RED ? Color.RED : Color.DARK_GRAY);
                g.fillOval(120, 70, 60, 60);
            }
        };

        JPanel bPanel = new JPanel();
        redb = new JButton("Red");
        yellowb = new JButton("yellow");
        greenb = new JButton("Green");


        // Adding the signal buttons to the frame.
        bPanel.add(redb);
        bPanel.add(yellowb);
        bPanel.add(greenb);

        add(lightP, BorderLayout.CENTER);
        setSize(500,400);
        setLayout(new BorderLayout());
        setVisible(true);
    }

    public static void main(String[] args){
        new MicroProject();
    }
}
