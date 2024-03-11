package pendu;

import javax.swing.*;
import java.awt.*;

/*
 * Démarre l'application du pendu
 */
public class LancementPendu {

    public static void main(String[] args) {
        PenduModel model = new PenduModel();
        PenduVue vue = new PenduVue(model);

        JButton btnLancementPartie = new JButton("Lancer une partie");


        PenduControleur controleur = new PenduControleur(vue, model, btnLancementPartie);

        JPanel panelBtn = new JPanel();
        panelBtn.add(btnLancementPartie);

        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.add(vue);

        // Ajouts des différents composants
        frame.add(panelBtn, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
