package pendu;

import javax.swing.*;
import java.awt.*;

/*
 * Démarre l'application du pendu
 */
public class LancementPendu {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PenduModel model = new PenduModel();
            PenduVue vue = new PenduVue(model);

            JButton btnLancementPartie = new JButton("Lancer une partie");
            PenduControleur controleur = new PenduControleur(vue, model, btnLancementPartie);

            JPanel panelBtn = new JPanel();
            panelBtn.add(btnLancementPartie);

            // Création de l'interface
            JFrame frame = new JFrame();
            frame.setSize(800, 600);
            frame.setLayout(new BorderLayout());
            frame.add(vue);
            frame.add(panelBtn, BorderLayout.SOUTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
