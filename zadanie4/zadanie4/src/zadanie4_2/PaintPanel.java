package zadanie4_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PaintPanel extends JPanel implements MouseListener, MouseMotionListener {

    // tryby pracy
    public enum Mode {
        OLOWEK, KOLO, KWADRAT, PRZESUN
    }

    private Mode currentMode = Mode.OLOWEK;
    private ArrayList<Drawable> elements = new ArrayList<>();

    // Zmienne pomocnicze
    private FreehandLine currentLine = null; // rysowana linia
    private MyShape selectedShape = null;    // przesuwana figura
    private int offX, offY;

    public PaintPanel() {
        this.setBackground(Color.WHITE);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    // przekazanie trybu do AppFrame
    public void setMode(Mode mode) {
        this.currentMode = mode;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Drawable d : elements) {
            d.draw(g2d);
        }

        if (currentLine != null) {
            currentLine.draw(g2d);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        // rysowanie
        if (currentMode == Mode.OLOWEK) {
            currentLine = new FreehandLine();
            currentLine.addPoint(x, y);
        }
        //kwadrat wstawianie
        else if (currentMode == Mode.KWADRAT) {
            elements.add(new MyShape(x - 25, y - 25, "KWADRAT", Color.BLUE));
            repaint();
        }
        //kolo wstawianie
        else if (currentMode == Mode.KOLO) {
            elements.add(new MyShape(x - 25, y - 25, "KOLO", Color.RED));
            repaint();
        }
        //przesuwanie
        else if (currentMode == Mode.PRZESUN) {
            for (int i = elements.size() - 1; i >= 0; i--) {
                Drawable d = elements.get(i);
                if (d instanceof MyShape) {
                    MyShape s = (MyShape) d;
                    if (s.contains(x, y)) {
                        selectedShape = s;
                        offX = x - s.getX();
                        offY = y - s.getY();
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (currentMode == Mode.OLOWEK && currentLine != null) {
            // zapisujemy linie w tabeli
            currentLine.addPoint(e.getX(), e.getY());
            repaint();
        }
        else if (currentMode == Mode.PRZESUN && selectedShape != null) {
            // przesuwamy figurę
            selectedShape.setPosition(e.getX() - offX, e.getY() - offY);
            repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (currentMode == Mode.OLOWEK && currentLine != null) {
            // kończymy rysowanie linii, dodajemy ją do głównej listy
            elements.add(currentLine);
            currentLine = null;
        }
        selectedShape = null; // Puszczamy figurę
    }

    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mouseMoved(MouseEvent e) {}
}