package pendu;

import java.awt.*;

import javax.swing.*;

/**
 * Crée l'interface du jeu du pendu
 */
public class PenduVue extends JPanel {

    private PenduModel model;
    private JTextArea textArea;
    private JButton btnSoumettreMot;
    private BorderLayout borderLayout;

    /**
     * Construction d'un objet PenduVue
     * @param penduModel model
     */
    public PenduVue(PenduModel penduModel) {
        this.model = penduModel;
        this.borderLayout = new BorderLayout();
        setBackground(Color.WHITE);
        creerBoutonSoumissionMot();
        creerZoneSaisie();

    }

    /**
     * Affiche le texte dans la zone de saisie
     * @param texte texte à ajouter
     */
    public void afficherTexte(String texte) {
        textArea.setText(texte);
        textArea.setEditable(true);
    }

    /**
     * Affiche la définition du mot tiré
     * @param definition
     */
    private void afficherDefinition(String definition) {
        // todo label.setTexte(definition);
    }

    /**
     * Création d'une zone de saisie
     */
    private void creerZoneSaisie() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));
        setLayout(borderLayout);
        add(textArea, BorderLayout.CENTER);
    }

    /**
     * Création du bouton pour permettre au joueur de vérifier son mot
     */
    private void creerBoutonSoumissionMot() {
        btnSoumettreMot = new JButton("Soumettre le mot");
        setLayout(borderLayout);
        add(btnSoumettreMot, BorderLayout.SOUTH);
    }
}
