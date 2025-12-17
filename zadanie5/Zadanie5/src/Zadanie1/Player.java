package Zadanie1;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
    private int dy = 0; // Prędkość wertykalna
    private int dx = 0; // Prędkość horyzontalna
    private final int GRAVITY = 1;
    private final int JUMP_STRENGTH = -15;
    private final int FLOOR_Y;

    public Player(int x, int y, int floorY) {
        super(x, y, 30, 30, Color.BLUE);
        this.FLOOR_Y = floorY;
    }

    public void move() {
        x += dx;
        y += dy;

        // opadanie
        if (y < FLOOR_Y - height) {
            dy += GRAVITY;
        } else {
            y = FLOOR_Y - height; // podloga
            dy = 0;
        }

        if (x < 0) x = 0;
        if (x > 750) x = 750;
    }

    public void jump() {
        if (y == FLOOR_Y - height) { // skok tylko z podłogi
            dy = JUMP_STRENGTH;
        }
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height); // gracz jako kwadrat
    }
}