package Zadanie1;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.List; // Import java.util.List, not java.awt.List

public class GamePanel extends JPanel {
    private GameState gameState;

    public GamePanel(GameState gameState) {
        this.gameState = gameState;
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Rysowanie podłogi
        g.setColor(Color.GRAY);
        g.fillRect(0, 400, getWidth(), 200);

        // Rysowanie Gracza
        gameState.getPlayer().draw(g);

        // Rysowanie Przeszkód
        for (Obstacle obs : gameState.getObstacles()) {
            obs.draw(g);
        }

        // Rysowanie Przedmiotów (Zasobów współdzielonych)
        // Musimy zsynchronizować blok rysowania, aby uniknąć ConcurrentModificationException,
        // gdy wątek dostawcy doda coś w trakcie rysowania.
        synchronized (gameState.getItems()) {
            for (Item item : gameState.getItems()) {
                item.draw(g);
            }
        }

        // Rysowanie HUD (Wynik)
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Punkty: " + gameState.getScore(), 20, 30);
    }
}