package zadanie4_4;

import javax.swing.*;

public class AppFrame extends JFrame {
    public AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);

        this.add(new PanelAnimacji());
    }
}