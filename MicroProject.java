import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MicroProject extends JFrame {
    private JPanel lightP;
    private Color currentLight = Color.RED;
    private JLabel tl;
    private int count = 60;
    private Timer t;
    private JButton startStopB;
    private boolean isRunning = false;

    public MicroProject() {
        ImageIcon img = new ImageIcon("\"D:\\SignalIcon.png\""); // work on image icon PLS
        img.setDescription("TANS");
        setTitle("Traffic Light Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Counter label section
        tl = new JLabel("Count: " + count, SwingConstants.CENTER);
        tl.setFont(new Font("Arial", Font.BOLD, 20));
        add(tl, BorderLayout.NORTH);

        // Light Panel (Traffic Light Display)
        lightP = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillRect(100, 50, 100, 300);

                g.setColor(currentLight == Color.RED ? Color.RED : Color.DARK_GRAY);
                g.fillOval(120, 70, 60, 60);

                g.setColor(currentLight == Color.YELLOW ? Color.YELLOW : Color.DARK_GRAY);
                g.fillOval(120, 160, 60, 60);

                g.setColor(currentLight == Color.GREEN ? Color.GREEN : Color.DARK_GRAY);
                g.fillOval(120, 250, 60, 60);
            }
        };
        add(lightP, BorderLayout.CENTER);

        startStopB = new JButton("Start Simulator");
        startStopB.setFont(new Font("Consolas", Font.BOLD, 16));
        // I have added an underscore insted of using e as it will supress the e parameter given for the action event.
        startStopB.addActionListener(_ -> toggleSimulator());
        add(startStopB, BorderLayout.SOUTH);
        // The counter will automatically start when the frame is created or the program is run.
        startCounter();

        setSize(500, 500);
        setVisible(true);
    }

    // To control(by user)
    private void toggleSimulator() {
        if (t != null && t.isRunning()) {
            t.stop(); // Stop the timer if it's running
        }
        else {
            startCounter();
        }
        isRunning = !isRunning; // Toggle to the running state
        startStopB.setText(isRunning ? "Start Simulator" : "Stop Simulator");
    }

    // Counter and signal switching logic
    private void startCounter() {
    if (t != null && t.isRunning()) {
        t.stop(); // Stop previous timer if running
    }

    count = 120;
    tl.setText("Count: " + count);

    t = new Timer(1000, new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) {
            if (count > 0) {
                count--;
                tl.setText("Count: " + count);

                if (count > 63) { // 57 seconds for red
                    currentLight = Color.RED;
                } else if (count > 60) { // 3 seconds for yellow
                    currentLight = Color.YELLOW;
                } else { // 60 seconds for green
                    currentLight = Color.GREEN;
                }
                lightP.repaint(); // Refresh the light panel
            } else {
                // Reset for the next cycle
                count = 120;
                currentLight = Color.RED;
                tl.setText("Count: " + count);
                lightP.repaint();
            }
        }
    });
    t.start();
}

    public static void main(String[] args) {
        new MicroProject();
    }
}




