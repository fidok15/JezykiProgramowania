package zadanie4_1;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {

    public AppFrame() {
        super("Zadanie 1: Wersja GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JTextField myTextField = new JTextField("kliknij", 20);

        JLabel statusLabel = new JLabel("");

        ClickLogger listener = new ClickLogger(statusLabel);

        myTextField.addMouseListener(listener);

        this.add(myTextField);
        this.add(statusLabel);
    }
}