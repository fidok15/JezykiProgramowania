package zadanie4_2;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {

    public AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        // układ okna
        this.setLayout(new BorderLayout());

        // panel rysowania
        PaintPanel paintPanel = new PaintPanel();

        // pasek narzędzi
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        // tworzymy przyciski
        JButton btnOlowek = new JButton("ołówek");
        JButton btnKwadrat = new JButton("kwadrat");
        JButton btnKolo = new JButton("koło");
        JButton btnPrzesun = new JButton("przesuń");

        // obsługa kliknięć w przyciski
        btnOlowek.addActionListener(e -> paintPanel.setMode(PaintPanel.Mode.OLOWEK));
        btnKwadrat.addActionListener(e -> paintPanel.setMode(PaintPanel.Mode.KWADRAT));
        btnKolo.addActionListener(e -> paintPanel.setMode(PaintPanel.Mode.KOLO));
        btnPrzesun.addActionListener(e -> paintPanel.setMode(PaintPanel.Mode.PRZESUN));

        // dodajemy przyciski do paska
        toolBar.add(btnOlowek);
        toolBar.add(btnKwadrat);
        toolBar.add(btnKolo);
        toolBar.add(btnPrzesun);

        // składamy wszystko w oknie
        this.add(toolBar, BorderLayout.NORTH);
        this.add(paintPanel, BorderLayout.CENTER);
    }
}