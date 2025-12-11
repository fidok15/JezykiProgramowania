package zadanie4_5;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {

    public AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        InfoPanel infoPanel = new InfoPanel();

        InteractiveShapePanel drawingPanel = new InteractiveShapePanel(infoPanel);

        this.add(drawingPanel, BorderLayout.CENTER);
        this.add(infoPanel, BorderLayout.EAST);
    }
}