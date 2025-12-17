package Zadanie2;

import java.util.Random;

public class SensorThread implements Runnable {
    private final SensorBuffer buffer;
    private final String sensorType;
    private final Random random;
    private volatile boolean running = true;

    private final double minVal;
    private final double maxVal;

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
                // czas pomiaru co
                Thread.sleep(500 + random.nextInt(1000));

                // losowa wartosc w zakresie
                double val = minVal + (maxVal - minVal) * random.nextDouble();

                // zapis do bufora
                buffer.addMeasurement(val);

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