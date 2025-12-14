package Zadanie1;

import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlatformerGame extends JFrame {

    private GameState gameState;
    private GamePanel gamePanel;
    private final int FLOOR_Y = 400;

    public PlatformerGame() {
        // Inicjalizacja modelu
        gameState = new GameState(FLOOR_Y);

        // Inicjalizacja widoku
        gamePanel = new GamePanel(gameState);

        setupFrame();
        setupInput();
        startThreads();
    }

    private void setupFrame() {
        setTitle("Platformer Swing Multithreading");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(gamePanel);
        setLocationRelativeTo(null);
    }

    private void setupInput() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> gameState.getPlayer().setDx(-5);
                    case KeyEvent.VK_RIGHT -> gameState.getPlayer().setDx(5);
                    case KeyEvent.VK_SPACE -> gameState.getPlayer().jump();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
                    gameState.getPlayer().setDx(0);
                }
            }
        });
    }

    private void startThreads() {
        // 1. WĄTEK LOGIKI GRY I ANIMACJI (Swing Timer)
        // Działa na wątku EDT (Event Dispatch Thread), co jest bezpieczne dla UI
        Timer gameLoop = new Timer(16, new ActionListener() { // ~60 FPS
            @Override
            public void actionPerformed(ActionEvent e) {
                gameState.updatePhysics(); // Aktualizacja pozycji
                gamePanel.repaint();       // Żądanie przerysowania
            }
        });
        gameLoop.start();

        // 2. WĄTEK DOSTAWCY ZASOBÓW (Background Thread)
        // Działa całkowicie niezależnie od pętli gry
        ResourceSupplier supplier = new ResourceSupplier(gameState, FLOOR_Y);
        Thread supplierThread = new Thread(supplier);
        supplierThread.start();
    }

    public static void main(String[] args) {
        // Uruchomienie w wątku Swinga
        javax.swing.SwingUtilities.invokeLater(() -> {
            new PlatformerGame().setVisible(true);
        });
    }
}