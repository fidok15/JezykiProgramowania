package Zadanie_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {

    private JPasswordField passwordField;
    private JButton checkButton;
    private JLabel resultLabel;

    public MainPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(380, 200));
        setBackground(Color.LIGHT_GRAY);

        JLabel passwordLabel = new JLabel("podaj hasło:");
        passwordLabel.setBounds(20, 20, 100, 25);
        this.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(120, 20, 200, 25);
        this.add(passwordField);

        checkButton = new JButton("sprawdz");
        checkButton.setBounds(120, 60, 200, 30);
        checkButton.addActionListener(this);
        this.add(checkButton);

        resultLabel = new JLabel(" ");
        resultLabel.setBounds(120, 110, 250, 25);
        this.add(resultLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String password = new String(passwordField.getPassword());
        String strength = evaluatePasswordStrength(password);

        JOptionPane.showMessageDialog(this, "sila hasla: " + strength);
        resultLabel.setText("sila hasla: " + strength);
    }

    private String evaluatePasswordStrength(String password) {
        if (password.length() == 0) {
            return "podaj haslo";
        }

        int score = 0;

        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        if (password.matches(".*[!@#$%^&*()_+\\-=?].*")) score++;

        switch (score) {
            case 0, 1 -> { return "bardzo słabe"; }
            case 2 -> { return "słabe"; }
            case 3 -> { return "srednie"; }
            case 4 -> { return "mocne"; }
            case 5 -> { return "bardzo mocne"; }
            default -> { return "blad"; }
        }
    }
}
