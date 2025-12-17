package Zadanie1;

import java.awt.Color;
import java.awt.Graphics;

public class Obstacle extends GameObject {
    public Obstacle(int x, int y) {
        super(x, y, 30, 30, Color.RED);
    }

    public void update() {
        x -= 5; // przesuwanie przeszkody
        if (x < -50) {
            x = 800; // reset pozycji
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}