package zadanie4_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InteractiveShapePanel extends JPanel implements MouseListener, MouseWheelListener {

    private InfoPanel panelBoczny;

    private int x = 150, y = 100;
    private int rozmiar = 80;
    private Color kolor = Color.ORANGE;

    public InteractiveShapePanel(InfoPanel infoPanel) {
        this.panelBoczny = infoPanel;
        this.setBackground(Color.WHITE);

        this.addMouseListener(this);
        this.addMouseWheelListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(kolor);
        g2d.fillOval(x, y, rozmiar, rozmiar);

        g2d.setColor(Color.BLACK);
        g2d.drawOval(x, y, rozmiar, rozmiar);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (czyMyszNadFigura(e.getX(), e.getY())) {
            int obrot = e.getWheelRotation();

            if (obrot < 0) {
                rozmiar += 10; // powiększ
                panelBoczny.ustawKomunikat("powiekszenie)");
            } else {
                rozmiar -= 10; // pomniejsz
                panelBoczny.ustawKomunikat("pomniejszanie");
            }

            if (rozmiar < 10) rozmiar = 10;

            repaint();
        }
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(new Color(240, 248, 255));
        panelBoczny.ustawKomunikat("strefa rysowania");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(Color.WHITE);
        panelBoczny.ustawKomunikat("opuszczono strefę rysowania");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (czyMyszNadFigura(e.getX(), e.getY())) {
            panelBoczny.ustawKomunikat("kliknięto w figure");
            kolor = Color.RED;
        } else {
            panelBoczny.ustawKomunikat("kliknieto w tło");
            kolor = Color.ORANGE;
        }
        repaint();
    }

    private boolean czyMyszNadFigura(int mx, int my) {
        // sprawdzenie dla koła/kwadratu
        return mx >= x && mx <= x + rozmiar &&
                my >= y && my <= y + rozmiar;
    }

    // Nieużywane metody interfejsu MouseListener
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
}