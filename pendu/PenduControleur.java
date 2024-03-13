package pendu;

import javax.swing.*;

public class PenduControleur {

    private PenduModel model;
    private PenduVue vue;
    private JButton btnLancementPartie;
    private JButton btnSoumettreMot;
    private static String motTire;
    private static String ligne;
    private static String definition;

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
        this.btnSoumettreMot = new JButton("Soumettre le mot");
        this.btnSoumettreMot.addActionListener(e -> vue.verifierMot());
    }

    /**
     * Lancement d'une partie de pendu avec tirage d'un mot aléatoire
     * Et affichage d'un champ de saisie avec la première lettre du mot
     */
    private void lancerPartie() {
        ligne = PenduModel.getLigneAleatoire("mots.txt");
        definition = PenduModel.getDefinition(ligne);
        motTire = PenduModel.getMot(ligne);

        // Affichage des vies du joueur
        vue.afficherVie();

        this.vue.creerBoutonSoumissionMot();

        // Gestion de la difficulte
        // Si facile : definition et pas de timer
        // Si difficile : l'inverse

        // Apparition sur l'interface d'un champ de saisie avec la première lettre du mot
        creationZoneSaisie(motTire);
        creationZoneDefinition(definition);
    }

    /**
     * Compare le mot donné par le joueur et le mot tiré
     * @param motPropose mot proposé par le joueur
     * @return true si les mots sont les mêmes, false sinon
     */
    public static boolean verificationProposition(String motPropose) {
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

    /**
     * Affichage de la définition sur l'interface
     * @param definition définition du mot
     */
    private void creationZoneDefinition(String definition) {
        vue.afficherDefinition(definition);
    }

    /**
     * Affichage du nombre de lettres du mot
     * @param mot mot tiré aléatoirement
     */
    private void creationZoneNbLettres(String mot) {

    }
}
