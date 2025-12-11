package zadanie4_4;

import java.awt.*;
import java.util.Random;

public class AnimowanaFigura {
    private int x, y;
    private int rozmiar = 60;
    private Color kolor;

    private int dx = 0;
    private int dy = 0;

    public AnimowanaFigura(int x, int y, Color kolor) {
        this.x = x;
        this.y = y;
        this.kolor = kolor;
    }

    public void rysuj(Graphics2D g2d) {
        g2d.setColor(kolor);
        g2d.fillOval(x, y, rozmiar, rozmiar);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(x, y, rozmiar, rozmiar);
    }

    public void aktualizujPozycje() {
        x += dx;
        y += dy;
    }

    // czy nacisnieto w figurze
    public boolean zawieraPunkt(int mx, int my) {
        return mx >= x && mx <= x + rozmiar &&
                my >= y && my <= y + rozmiar;
    }

    // decydujemy o kierunku ruchu na podstawie miejsca kliknięcia
    public void uruchomRuch(int clickX, int clickY) {
        int srodekX = x + (rozmiar / 2);
        int srodekY = y + (rozmiar / 2);

        // jeśli kliknięto w górną połowę ruch w dol
        if (clickY < srodekY) {
            dx = 0;
            dy = 2;
        }
        // inaczej ruch w prawo
        else {
            dx = 2; // 2 piksele na klatkę w prawo
            dy = 0;
        }
    }
}