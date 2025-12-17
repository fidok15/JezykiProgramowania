package Zadanie1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameState {
    private final Player player;
    private final List<Item> items;
    private final List<Obstacle> obstacles;
    private int score = 0;

    public GameState(int floorY) {
        player = new Player(100, floorY - 30, floorY);
        items = Collections.synchronizedList(new ArrayList<>());
        obstacles = new ArrayList<>();

        // dodaj startową przeszkodę
        obstacles.add(new Obstacle(600, floorY - 30));
    }

    public Player getPlayer() { return player; }
    public List<Item> getItems() { return items; }
    public List<Obstacle> getObstacles() { return obstacles; }
    public int getScore() { return score; }

    // game loop
    public void updatePhysics() {
        player.move();

        for (Obstacle obs : obstacles) {
            obs.update();
        }

        checkCollisions();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    // sprawdzanie kolizji i usuwanie zebranych przedmiotów
    private void checkCollisions() {
        synchronized (items) {
            items.removeIf(item -> {
                if (player.getBounds().intersects(item.getBounds())) {
                    score += 10;
                    return true;
                }
                return false;
            });
        }

        // kolizja z przeszkodami
        for (Obstacle obs : obstacles) {
            if (player.getBounds().intersects(obs.getBounds())) {
                score = 0; // reset gry (scora)
            }
        }
    }
}