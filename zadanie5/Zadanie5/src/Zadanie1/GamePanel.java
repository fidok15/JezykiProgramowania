package Zadanie1;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class GamePanel extends JPanel {
    private final GameState gameState;

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

        // Rysowanie gracza
        gameState.getPlayer().draw(g);

        // Rysowanie przeszkód
        for (Obstacle obs : gameState.getObstacles()) {
            obs.draw(g);
        }

        // Rysowanie przedmiotów
        synchronized (gameState.getItems()) {
            for (Item item : gameState.getItems()) {
                item.draw(g);
            }
        }

        // Rysowanie wyniku
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Punkty: " + gameState.getScore(), 20, 30);
    }
}