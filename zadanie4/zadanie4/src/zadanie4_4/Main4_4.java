package zadanie4_4;

import javax.swing.SwingUtilities;

public class Main4_4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppFrame app = new AppFrame();
            app.setVisible(true);
        });
    }
}