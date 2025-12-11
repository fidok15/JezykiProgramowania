package zadanie4_6;

import javax.swing.SwingUtilities;

public class Main4_6 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppFrame app = new AppFrame();
            app.setVisible(true);
        });
    }
}