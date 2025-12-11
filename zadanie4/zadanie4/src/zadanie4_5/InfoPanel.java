package zadanie4_5;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    private JLabel statusLabel;

    public InfoPanel() {
        this.setPreferredSize(new Dimension(200, 0));
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BorderLayout());

        this.setBorder(BorderFactory.createTitledBorder("Log zdarzeń"));

        statusLabel = new JLabel("<html>Czekam na ruch myszy...</html>");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setVerticalAlignment(SwingConstants.TOP);

        this.add(statusLabel, BorderLayout.CENTER);
    }

    public void ustawKomunikat(String tekst) {
        statusLabel.setText("<html><center>" + tekst + "</center></html>");
    }
}