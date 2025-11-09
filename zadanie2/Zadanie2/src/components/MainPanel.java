package components;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

public class MainPanel extends JPanel {

    private JLabel uzytkownikLabel;
    private JTextField uzystkownikInput;
    private JLabel hasloLabel;
    private JPasswordField hasloInput;
    private JButton przyciks;
    private JTextArea output;
    private JScrollPane scrollPane;

    private JButton kolorPrzycisk;
    private JButton rozmiarPrzycisk;
    private JButton przesunPrzycisk;

    private JComboBox<String> componentSelector;

    private Map<String, JComponent> componentMap;

    public MainPanel() {

        setLayout(null);
        this.setPreferredSize(new Dimension(565, 440));
        setBackground(Color.LIGHT_GRAY);

        componentMap = new HashMap<>();

        uzytkownikLabel = new JLabel("uzytkownik:");
        uzytkownikLabel.setBounds(10, 10, 80, 25);
        this.add(uzytkownikLabel);
        componentMap.put("etykieta uzytkownik", uzytkownikLabel);

        uzystkownikInput = new JTextField(30);
        uzystkownikInput.setBounds(100, 10, 160, 25);
        this.add(uzystkownikInput);
        componentMap.put("pole uzytkownik", uzystkownikInput);

        hasloLabel = new JLabel("haslo:");
        hasloLabel.setBounds(10, 50, 80, 25);
        this.add(hasloLabel);
        componentMap.put("etykieta haslo", hasloLabel);

        hasloInput = new JPasswordField(20);
        hasloInput.setBounds(100, 50, 165, 25);
        this.add(hasloInput);
        componentMap.put("pole haslo", hasloInput);

        przyciks = new JButton("zaloguj");
        przyciks.setBounds(10, 85, 100, 25);
        this.add(przyciks);
        componentMap.put("przycisk zaloguj", przyciks);

        output = new JTextArea();
        output.setEditable(false);
        scrollPane = new JScrollPane(output);
        scrollPane.setBounds(10, 130, 545, 310);
        this.add(scrollPane);
        componentMap.put("output", scrollPane);

        String[] componentNames = componentMap.keySet().toArray(new String[0]);
        componentSelector = new JComboBox<>(componentNames);
        componentSelector.setBounds(280, 10, 250, 25);
        this.add(componentSelector);

        kolorPrzycisk = new JButton("zmien kolor");
        kolorPrzycisk.setBounds(280, 40, 250, 25);
        this.add(kolorPrzycisk);

        rozmiarPrzycisk = new JButton("zmien rozmiar");
        rozmiarPrzycisk.setBounds(280, 70, 250, 25);
        this.add(rozmiarPrzycisk);

        przesunPrzycisk = new JButton("przesun");
        przesunPrzycisk.setBounds(280, 100, 250, 25);
        this.add(przesunPrzycisk);

        przyciks.addActionListener(e -> {
            String uzytkownik = uzystkownikInput.getText();
            String haslo = new String(hasloInput.getPassword());
            output.append("login: " + uzytkownik + "\n");
            output.append("hasło: " + haslo + "\n");
        });

        kolorPrzycisk.addActionListener(e -> {
            JComponent selected = getSelectedComponent();
            if (selected == null) return;

            Color newColor = JColorChooser.showDialog(this, "wybierz kolor tla", selected.getBackground());
            if (newColor != null) {
                selected.setBackground(newColor);
                selected.setOpaque(true);
            }
        });

        rozmiarPrzycisk.addActionListener(e -> {
            JComponent selected = getSelectedComponent();
            if (selected == null) return;

            try {
                String widthStr = JOptionPane.showInputDialog(this, "podaj szerokość:", selected.getWidth());
                String heightStr = JOptionPane.showInputDialog(this, "podaj wysokość:", selected.getHeight());

                if (widthStr != null && heightStr != null) {
                    int newWidth = Integer.parseInt(widthStr);
                    int newHeight = Integer.parseInt(heightStr);
                    Rectangle bounds = selected.getBounds();
                    selected.setBounds(bounds.x, bounds.y, newWidth, newHeight);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "blad");
            }
        });

        przesunPrzycisk.addActionListener(e -> {
            JComponent selected = getSelectedComponent();
            if (selected == null) return;

            try {
                String xStr = JOptionPane.showInputDialog(this, "x: ", selected.getX());
                String yStr = JOptionPane.showInputDialog(this, "y: ", selected.getY());
                if (xStr != null && yStr != null) {
                    int newX = Integer.parseInt(xStr);
                    int newY = Integer.parseInt(yStr);
                    Rectangle bounds = selected.getBounds();
                    selected.setBounds(newX, newY, bounds.width, bounds.height);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "blad");
            }
        });
    }

    private JComponent getSelectedComponent() {
        String selectedName = (String) componentSelector.getSelectedItem();
        if (selectedName == null) {
            return null;
        }
        return componentMap.get(selectedName);
    }
}