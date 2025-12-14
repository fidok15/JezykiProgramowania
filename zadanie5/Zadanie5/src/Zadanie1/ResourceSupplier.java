package Zadanie1;

import java.util.Random;

public class ResourceSupplier implements Runnable {
    private GameState gameState;
    private boolean running = true;
    private Random random = new Random();
    private int floorY;

    public ResourceSupplier(GameState gameState, int floorY) {
        this.gameState = gameState;
        this.floorY = floorY;
    }

    @Override
    public void run() {
        while (running) {
            try {
                // Symulacja czasu potrzebnego na wygenerowanie zasobu (np. co 2-4 sekundy)
                Thread.sleep(random.nextInt(2000) + 2000);

                // Tworzenie przedmiotu w losowym miejscu (ale nie za nisko/wysoko)
                int x = random.nextInt(700) + 50;
                int y = floorY - 40 - random.nextInt(100); // Nieco nad ziemią

                System.out.println("Dostawca: Dodano nowy przedmiot na pozycji: " + x);
                gameState.addItem(new Item(x, y));

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                running = false;
            }
        }
    }

    public void stop() {
        running = false;
    }
}
