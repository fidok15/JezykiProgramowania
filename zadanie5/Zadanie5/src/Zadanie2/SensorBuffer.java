package Zadanie2;

import java.util.LinkedList;
import java.util.List;

public class SensorBuffer {
    private final LinkedList<Measurement> buffer;
    private final int capacity;

    public SensorBuffer(int capacity) {
        this.buffer = new LinkedList<>();
        this.capacity = capacity;
    }

    // Metoda Producenta (Wątek czujnika)
    public synchronized void addMeasurement(double value) {
        Measurement m = new Measurement(value);
        buffer.addFirst(m); // Dodajemy na początek (najnowsze)

        // Utrzymujemy stały rozmiar bufora, usuwając stare dane
        if (buffer.size() > capacity) {
            buffer.removeLast();
        }
    }

    // Metoda Konsumenta
    public synchronized Measurement getLatest() {
        if (buffer.isEmpty()) {
            return null;
        }
        return buffer.getFirst();
    }

    // Pobranie kopii historii do wyświetlenia listy
    public synchronized List<Measurement> getHistorySnapshot() {
        return new LinkedList<>(buffer);
    }
}