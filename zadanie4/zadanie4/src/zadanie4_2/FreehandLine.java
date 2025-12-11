package zadanie4_2;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FreehandLine implements Drawable {
    private List<Point> punkty = new ArrayList<>();
    private Color color = Color.BLACK;

    public void addPoint(int x, int y) {
        punkty.add(new Point(x, y));
    }

    @Override
    public void draw(Graphics2D g2d) {
        if (punkty.size() < 2) return;

        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(2)); // Grubość linii

        // Rysujemy linię od punktu do punktu
        for (int i = 0; i < punkty.size() - 1; i++) {
            Point p1 = punkty.get(i);
            Point p2 = punkty.get(i + 1);
            g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
}