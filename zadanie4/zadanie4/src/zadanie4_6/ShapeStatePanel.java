package zadanie4_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShapeStatePanel extends JPanel implements KeyListener {

    private boolean czyWcisnietoKlawisz = false;
    private boolean czyShift = false;
    private boolean czyCtrl = false;

    public ShapeStatePanel() {
        this.setBackground(Color.WHITE);

        this.setFocusable(true);
        this.requestFocusInWindow();

        this.addKeyListener(this);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                requestFocusInWindow();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x = 150, y = 100, size = 100;

        //logika koloru
        if (czyWcisnietoKlawisz) {
            g2d.setColor(Color.RED);
        } else {
            g2d.setColor(Color.BLUE);
        }

        // logika ksztaltu
        if (czyShift) {
            g2d.fillRect(x, y, size, size);
        } else {
            g2d.fillOval(x, y, size, size);
        }

        // logika obramowania
        g2d.setColor(Color.BLACK);
        if (czyCtrl) {
            g2d.setStroke(new BasicStroke(10));
        } else {
            g2d.setStroke(new BasicStroke(2));
        }

        // Rysowanie ramki zależnie od kształtu
        if (czyShift) {
            g2d.drawRect(x, y, size, size);
        } else {
            g2d.drawOval(x, y, size, size);
        }

        // Instrukcje na ekranie
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.DARK_GRAY);
        g2d.drawString("Przytrzymaj dowolny klawisz -> Zmiana koloru", 10, 20);
        g2d.drawString("Przytrzymaj SHIFT -> Zmiana na KWADRAT", 10, 40);
        g2d.drawString("Przytrzymaj CTRL -> Pogrubienie ramki", 10, 60);

    }


    @Override
    public void keyPressed(KeyEvent e) {
        int kod = e.getKeyCode();

        if (kod == KeyEvent.VK_SHIFT) {
            czyShift = true;
        } else if (kod == KeyEvent.VK_CONTROL) {
            czyCtrl = true;
        } else {
            czyWcisnietoKlawisz = true;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int kod = e.getKeyCode();

        if (kod == KeyEvent.VK_SHIFT) {
            czyShift = false;
        } else if (kod == KeyEvent.VK_CONTROL) {
            czyCtrl = false;
        } else {
            czyWcisnietoKlawisz = false;
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}