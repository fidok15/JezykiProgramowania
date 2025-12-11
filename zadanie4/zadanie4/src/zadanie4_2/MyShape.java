package zadanie4_2;

import java.awt.*;

public class MyShape implements Drawable {
    private int x, y;
    private int size = 50;
    private Color color;
    private String type; // "KWADRAT" lub "KOLO"

    public MyShape(int x, int y, String type, Color color) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        if (type.equals("KOLO")) {
            g2d.fillOval(x, y, size, size);
            g2d.setColor(Color.BLACK);
            g2d.drawOval(x, y, size, size);
        } else {
            g2d.fillRect(x, y, size, size);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(x, y, size, size);
        }
    }

    // czy myszka kliknęto w ten obiekt (do przesuwania)
    public boolean contains(int mx, int my) {
        return mx >= x && mx <= x + size &&
                my >= y && my <= y + size;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}