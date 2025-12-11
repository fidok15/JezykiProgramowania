package zadanie4_3;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class ShortcutHandler extends KeyAdapter {

    private JTextField pole;

    public ShortcutHandler(JTextField pole) {
        this.pole = pole;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // sprawdzamy, czy wciśnięto CTRL
        if (e.isControlDown()) {

            // CTRL + A -> Czerwony
            if (e.getKeyCode() == KeyEvent.VK_A) {
                pole.setForeground(Color.RED);
                e.consume();
            }

            // CTRL + B -> Niebieski
            else if (e.getKeyCode() == KeyEvent.VK_B) {
                pole.setForeground(Color.BLUE);
                e.consume();
            }

            // CTRL + C -> Czyść
            else if (e.getKeyCode() == KeyEvent.VK_C) {
                pole.setText("");
                e.consume();
            }
        }
    }
}