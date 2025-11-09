package Zadanie_3;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private JLabel uzytkownikLabel;
    private JTextField uzystkownikInput;
    private JButton przycisk;

    public MainPanel() {

        setLayout(null);
        this.setPreferredSize(new Dimension(565, 440));
        setBackground(Color.LIGHT_GRAY);

        uzytkownikLabel = new JLabel("Podaj imię:");
        uzytkownikLabel.setBounds(10, 10, 80, 25);
        this.add(uzytkownikLabel);

        uzystkownikInput = new JTextField(30);
        uzystkownikInput.setBounds(100, 10, 160, 25);
        this.add(uzystkownikInput);

        przycisk = new JButton("OK");
        przycisk.setBounds(10, 85, 100, 25);
        this.add(przycisk);

        przycisk.addActionListener(e -> {
            String imie = uzystkownikInput.getText().trim();

            if (imie != null && !imie.trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Witaj, " + imie,
                        "czesc",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Nie podano imienia",
                        "error",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });
    }
}
