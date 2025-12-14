package Zadanie1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameState {
    private Player player;
    // Używamy listy synchronizowanej lub bloków synchronized,
    // ponieważ Items są modyfikowane przez dwa różne wątki.
    private List<Item> items;
    private List<Obstacle> obstacles;
    private int score = 0;

    public GameState(int floorY) {
        player = new Player(100, floorY - 30, floorY);
        items = Collections.synchronizedList(new ArrayList<>());
        obstacles = new ArrayList<>();

        // Dodaj jedną startową przeszkodę
        obstacles.add(new Obstacle(600, floorY - 30));
    }

    public Player getPlayer() { return player; }
    public List<Item> getItems() { return items; }
    public List<Obstacle> getObstacles() { return obstacles; }
    public int getScore() { return score; }

    // Metoda wywoływana przez GameLoop (Swing Timer)
    public void updatePhysics() {
        player.move();

        for (Obstacle obs : obstacles) {
            obs.update();
        }

        checkCollisions();
    }

    // Dodawanie zasobów (Thread-safe) - dla ResourceSupplier
    public void addItem(Item item) {
        // Synchronizacja nie jest tu krytyczna dzięki Collections.synchronizedList,
        // ale dobra praktyka przy bardziej złożonej logice.
        items.add(item);
    }

    // Sprawdzanie kolizji i usuwanie zebranych przedmiotów
    private void checkCollisions() {
        // Kolizja z przedmiotami (iteracja po kopii lub synchronized block aby uniknąć błędów)
        synchronized (items) {
            items.removeIf(item -> {
                if (player.getBounds().intersects(item.getBounds())) {
                    score += 10; // Aktualizacja wyniku
                    return true; // Usuń przedmiot
                }
                return false;
            });
        }

        // Kolizja z przeszkodami
        for (Obstacle obs : obstacles) {
            if (player.getBounds().intersects(obs.getBounds())) {
                System.out.println("GAME OVER! Wynik: " + score);
                score = 0; // Reset gry (prosta logika)
            }
        }
    }
}