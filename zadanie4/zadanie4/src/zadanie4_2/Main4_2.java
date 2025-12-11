package zadanie4_2;

import javax.swing.SwingUtilities;

public class Main4_2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppFrame app = new AppFrame();
            app.setVisible(true);
        });
    }
}