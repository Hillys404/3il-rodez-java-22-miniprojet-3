package pendu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import static pendu.PenduControleur.verificationProposition;

/**
 * Crée l'interface du jeu du pendu
 */
public class PenduVue extends JPanel {

    private PenduModel model;
    private PenduControleur penduControleur;
    private JTextArea textArea;
    private JButton btnSoumettreMot;
    private BorderLayout borderLayout;
    private JLabel imageLabel;

    /**
     * Construction d'un objet PenduVue
     * @param penduModel model
     */
    public PenduVue(PenduModel penduModel) {
        this.model = penduModel;
        this.borderLayout = new BorderLayout();
        setBackground(Color.WHITE);

        creerZoneSaisie();

        imageLabel = new JLabel();
        setLayout(borderLayout);
        add(imageLabel, borderLayout.NORTH);
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
    protected void creerBoutonSoumissionMot() {
        btnSoumettreMot = new JButton("Soumettre le mot");
        setLayout(borderLayout);
        add(btnSoumettreMot, BorderLayout.SOUTH);

        btnSoumettreMot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verifierMot();
            }
        });
    }

    /**
     * Récupère le mot saisie par le joueur et vérifie qu'il est égal au mot tiré
     */
    protected void verifierMot() {
        String motPropose = textArea.getText();
        boolean isMotEgal = verificationProposition(motPropose);
        if (!isMotEgal) {
            // Affichage pendu
            afficherImagePendu();
        } else {
            // Fin de la partie
        }
    }

    /**
     * Affichage d'une image pour illustrer le pendu
     */
    private void afficherImagePendu() {
        ImageIcon imagePendu = new ImageIcon("bonhomme1.jpg");
        Image image = imagePendu.getImage();
        Image imageResized = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imagePendu = new ImageIcon(imageResized);
        imageLabel.setIcon(imagePendu);
    }
}
