package Zadanie1;

import java.util.Random;

public class ResourceSupplier implements Runnable {
    private final GameState gameState;
    private boolean running = true;
    private final Random random = new Random();
    private final int floorY;

    public ResourceSupplier(GameState gameState, int floorY) {
        this.gameState = gameState;
        this.floorY = floorY;
    }

    @Override
    public void run() {
        while (running) {
            try {
                // symulacja czasu potrzebnego na wygenerowanie nagrody
                Thread.sleep(random.nextInt(2000) + 2000);

                // tworzenie przedmiotu (nagrody) w losowym miejscu
                int x = random.nextInt(700) + 50;
                int y = floorY - 40 - random.nextInt(100);

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
