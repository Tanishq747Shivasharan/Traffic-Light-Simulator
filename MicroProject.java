import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MicroProject extends JFrame {
    public MicroProject (){

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args){
        new MicroProject();
    }
}