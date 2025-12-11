package zadanie4_3;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {

    public AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        JTextField textField = new JTextField(20);
        textField.setFont(new Font("Arial", Font.BOLD, 18));
        textField.setText("Pole tekstowe");

        // handler
        ShortcutHandler listener = new ShortcutHandler(textField);
        textField.addKeyListener(listener);

        // instrukcja
        JLabel info = new JLabel("<html><b>Ctrl + A</b> = Czerwony<br><b>Ctrl + B</b> = Niebieski<br><b>Ctrl + C</b> = Czyść</html>");

        this.add(textField);
        this.add(info);
    }
}