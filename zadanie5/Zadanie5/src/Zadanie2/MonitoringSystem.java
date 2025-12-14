package Zadanie2;

import javax.swing.*;
import java.awt.*;

public class MonitoringSystem extends JFrame {

    public MonitoringSystem() {
        setTitle("System Monitorowania Czujników");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 400);
        setLayout(new GridLayout(1, 3, 10, 10)); // Siatka dla 3 czujników

        // Inicjalizacja buforów
        SensorBuffer tempBuffer = new SensorBuffer(20);
        SensorBuffer humBuffer = new SensorBuffer(20);
        SensorBuffer pressBuffer = new SensorBuffer(20);

        // Tworzenie GUI i przekazanie buforów
        add(new SensorPanel("Temperatura", "°C", tempBuffer));
        add(new SensorPanel("Wilgotność", "%", humBuffer));
        add(new SensorPanel("Ciśnienie", "hPa", pressBuffer));

        // Uruchamianie wątków czujników
        // Temperatura: 15.0 - 30.0
        startSensorThread(tempBuffer, "TEMP", 15.0, 35.0);

        // Wilgotność: 40.0 - 90.0
        startSensorThread(humBuffer, "HUMIDITY", 40.0, 90.0);

        // Ciśnienie: 980.0 - 1020.0
        startSensorThread(pressBuffer, "PRESSURE", 980.0, 1020.0);

        setLocationRelativeTo(null);
    }

    private void startSensorThread(SensorBuffer buffer, String name, double min, double max) {
        SensorThread task = new SensorThread(buffer, name, min, max);
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MonitoringSystem().setVisible(true);
        });
    }
}