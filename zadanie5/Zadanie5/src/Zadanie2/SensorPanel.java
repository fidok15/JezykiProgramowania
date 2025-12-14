package Zadanie2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;

public class SensorPanel extends JPanel {
    private final SensorBuffer buffer;
    private final JLabel valueLabel;
    private final JTextArea historyArea;
    private final String unit;

    public SensorPanel(String title, String unit, SensorBuffer buffer) {
        this.buffer = buffer; // Teraz przypisanie zadziała poprawnie przed użyciem
        this.unit = unit;

        // Konfiguracja wyglądu
        setLayout(new BorderLayout());
        setBorder(new TitledBorder(title));
        // Ustawiamy preferowany rozmiar, żeby panele nie były ściśnięte
        setPreferredSize(new Dimension(250, 300));

        // Etykieta z bieżącą wartością
        valueLabel = new JLabel("Oczekiwanie...", SwingConstants.CENTER);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 24));
        valueLabel.setOpaque(true);
        valueLabel.setBackground(Color.DARK_GRAY);
        valueLabel.setForeground(Color.GREEN);
        add(valueLabel, BorderLayout.NORTH);

        // Obszar historii
        historyArea = new JTextArea();
        historyArea.setEditable(false);
        historyArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(historyArea), BorderLayout.CENTER);

        // Timer odświeżający interfejs (KONSUMENT)
        // Zmieniono nazwę metody w wywołaniu:
        Timer uiTimer = new Timer(200, e -> refreshData());
        uiTimer.start();
    }

    // ZMIANA NAZWY METODY: updateUI -> refreshData
    // updateUI jest metodą wbudowaną w JPanel i nie wolno jej nadpisywać do własnej logiki
    private void refreshData() {
        if (buffer == null) return; // Zabezpieczenie na wypadek wywołania przed inicjalizacją

        // Odczyt z bufora
        Measurement latest = buffer.getLatest();
        List<Measurement> history = buffer.getHistorySnapshot();

        if (latest != null) {
            valueLabel.setText(String.format("%.2f %s", latest.getValue(), unit));

            // Kolorowanie w zależności od wartości
            if (latest.getValue() > 80.0 && unit.equals("°C")) {
                valueLabel.setForeground(Color.RED);
            } else {
                valueLabel.setForeground(Color.GREEN);
            }
        }

        // Aktualizacja listy historii
        StringBuilder sb = new StringBuilder();
        for (Measurement m : history) {
            sb.append(m.toString()).append("\n");
        }
        historyArea.setText(sb.toString());
        historyArea.setCaretPosition(0);
    }
}