package pendu;

import javax.swing.*;

public class PenduControleur {

    private PenduModel model;
    private PenduVue vue;
    private JButton btnLancementPartie;

    /**
     * Construction du controleur du jeu du pendu
     * @param vue interface
     * @param model model
     * @param btnLancementPartie bouton de lancement de partie
     */
    public PenduControleur(PenduVue vue, PenduModel model, JButton btnLancementPartie) {
        this.model = model;
        this.vue = vue;
        this.btnLancementPartie = btnLancementPartie;
        this.btnLancementPartie.addActionListener(e -> lancerPartie());
    }

    /**
     * Lancement d'une partie de pendu avec tirage d'un mot aléatoire
     * Et affichage d'un champ de saisie avec la première lettre du mot
     */
    private void lancerPartie() {
        String motTire = PenduModel.getMotAleatoire("mots.txt");

        // Gestion de la difficulte
        // Si facile : definition et pas de timer
        // Si difficile : l'inverse

        // Apparition sur l'interface d'un champ de saisie avec la première lettre du mot
        creationZoneSaisie(motTire);
    }

    /**
     * Compare le mot donné par le joueur et le mot tiré
     * @param motTire mot choisi aléatoirement
     * @param motPropose mot proposé par le joueur
     * @return true si les mots sont les mêmes, false sinon
     */
    private boolean verificationProposition(String motTire, String motPropose) {
        return motTire.equals(motPropose);
    }

    /**
     * Création d'une zone de saisie avec la première lettre du mot
     * @param mot mot tiré aléatoirement
     */
    private void creationZoneSaisie(String mot) {
        char lettre = mot.charAt(0);
        vue.afficherTexte(String.valueOf(lettre));
    }
}
