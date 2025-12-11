package zadanie4_1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class ClickLogger extends MouseAdapter {

    private final JLabel etykietaWyswietl;

    public ClickLogger(JLabel etykieta) {
        this.etykietaWyswietl = etykieta;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        String komunikat = "X=" + x + ", Y=" + y;
        etykietaWyswietl.setText(komunikat);
    }
}