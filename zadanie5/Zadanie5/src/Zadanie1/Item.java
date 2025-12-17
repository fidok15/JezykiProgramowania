package Zadanie1;

import java.awt.Color;
import java.awt.Graphics;

public class Item extends GameObject {
    public Item(int x, int y) {
        super(x, y, 15, 15, Color.YELLOW);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
}