package zadanie4_6;

import javax.swing.*;

public class AppFrame extends JFrame {
    public AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);

        ShapeStatePanel panel = new ShapeStatePanel();
        this.add(panel);
    }
}