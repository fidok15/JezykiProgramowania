package Zadanie_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {

    private JTextField display;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public MainPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(330, 400));
        setBackground(Color.LIGHT_GRAY);

        display = new JTextField();
        display.setBounds(10, 10, 300, 50);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        this.add(display);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        buttonPanel.setBounds(10, 80, 300, 250);
        this.add(buttonPanel);

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
            buttonPanel.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9]")) { // cyfry
            display.setText(display.getText() + command);
        } else if (command.equals("C")) { // czyszczenie
            display.setText("");
            num1 = num2 = result = 0;
        } else if (command.equals("=")) { // wynik
            try {
                num2 = Double.parseDouble(display.getText());
                switch (operator) {
                    case '+': result = num1 + num2; break;
                    case '-': result = num1 - num2; break;
                    case '*': result = num1 * num2; break;
                    case '/':
                        if (num2 == 0) {
                            JOptionPane.showMessageDialog(this, "Nie można dzielić przez zero!", "Błąd", JOptionPane.ERROR_MESSAGE);
                            display.setText("");
                            return;
                        }
                        result = num1 / num2; break;
                }
                display.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Błąd danych wejściowych!", "Błąd", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            try {
                num1 = Double.parseDouble(display.getText());
                operator = command.charAt(0);
                display.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Podaj liczbę przed operacją!", "Błąd", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
