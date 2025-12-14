package Zadanie2;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Measurement {
    private final double value;
    private final LocalTime timestamp;

    public Measurement(double value) {
        this.value = value;
        this.timestamp = LocalTime.now();
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        return "[" + timestamp.format(dtf) + "] " + String.format("%.2f", value);
    }
}
