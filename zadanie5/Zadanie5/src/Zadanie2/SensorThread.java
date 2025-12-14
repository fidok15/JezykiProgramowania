package Zadanie2;

import java.util.Random;

public class SensorThread implements Runnable {
    private final SensorBuffer buffer;
    private final String sensorType;
    private final Random random;
    private volatile boolean running = true;

    // Parametry do symulacji różnych zakresów danych
    private double minVal, maxVal;

    public SensorThread(SensorBuffer buffer, String sensorType, double minVal, double maxVal) {
        this.buffer = buffer;
        this.sensorType = sensorType;
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (running) {
            try {
                // Symulacja czasu pomiaru (np. co 0.5 - 1.5 sekundy)
                Thread.sleep(500 + random.nextInt(1000));

                // Generowanie losowej wartości w zakresie
                double val = minVal + (maxVal - minVal) * random.nextDouble();

                // Zapis do współdzielonego zasobu
                buffer.addMeasurement(val);

                // Opcjonalnie logowanie w konsoli dla weryfikacji
                // System.out.println(sensorType + " wysłał: " + val);

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