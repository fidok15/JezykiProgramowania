package zadanie4_1;

import javax.swing.SwingUtilities;

public class Main4_1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppFrame app = new AppFrame();
            app.setVisible(true);
        });
    }
}
