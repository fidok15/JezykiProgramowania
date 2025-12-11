package zadanie4_5;

import javax.swing.SwingUtilities;

public class Main4_5 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppFrame app = new AppFrame();
            app.setVisible(true);
        });
    }
}