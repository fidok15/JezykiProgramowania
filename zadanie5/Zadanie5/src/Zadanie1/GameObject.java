package Zadanie1;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Color;

// Klasa bazowa dla wszystkich obiektów
public abstract class GameObject {
    protected int x, y, width, height;
    protected Color color;

    public GameObject(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public abstract void draw(Graphics g);

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getX() { return x; }
    public int getY() { return y; }
}