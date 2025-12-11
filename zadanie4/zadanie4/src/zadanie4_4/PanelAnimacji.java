package zadanie4_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PanelAnimacji extends JPanel {

    private ArrayList<AnimowanaFigura> figury = new ArrayList<>();
    private Timer timer;

    public PanelAnimacji() {
        this.setBackground(Color.WHITE);

        // figur na start
        figury.add(new AnimowanaFigura(50, 50, Color.RED));
        figury.add(new AnimowanaFigura(50, 200, Color.BLUE));
        figury.add(new AnimowanaFigura(200, 50, Color.GREEN));



        //opóźnienie co ma sie dziać
        timer = new Timer(20, e -> {
            // w każdej klatce czasu:
            for (AnimowanaFigura f : figury) {
                f.aktualizujPozycje(); // Przesuń figury, które mają ustawione dx/dy
            }
            repaint(); // Odśwież ekran
        });

        timer.start();

        // obsługa myszy
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                sprawdzKlikniecie(e.getX(), e.getY());
            }
        });
    }

    private void sprawdzKlikniecie(int x, int y) {
        for (AnimowanaFigura f : figury) {
            if (f.zawieraPunkt(x, y)) {
                // Przekazujemy współrzędne kliknięcia, żeby figura wiedziała gdzie lecieć
                f.uruchomRuch(x, y);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (AnimowanaFigura f : figury) {
            f.rysuj(g2d);
        }

        g2d.setColor(Color.GRAY);
        g2d.drawString("Kliknij górną część koła -> leci w dół", 10, 20);
        g2d.drawString("Kliknij dolną część koła -> leci w prawo", 10, 35);
    }
}