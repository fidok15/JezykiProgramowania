package zadanie4_3;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class ColorKeyAdapter extends KeyAdapter {

    private JTextField poleTekstowe;

    // dostęp do pola żeby zmieniać jego kolor i tekst
    public ColorKeyAdapter(JTextField pole) {
        this.poleTekstowe = pole;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int kod = e.getKeyCode();

        if (kod == KeyEvent.VK_A) {
            poleTekstowe.setForeground(Color.RED);
        }
        else if (kod == KeyEvent.VK_B) {
            poleTekstowe.setForeground(Color.BLUE);
        }
        else if (kod == KeyEvent.VK_C) {
            poleTekstowe.setText("");
        }
    }
}