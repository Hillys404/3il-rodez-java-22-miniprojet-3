package pendu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import static pendu.PenduControleur.verificationProposition;
import static pendu.PenduModel.getNbLettres;

/**
 * Crée l'interface du jeu du pendu
 */
public class PenduVue extends JPanel {
    private PenduModel model;
    private JTextArea textArea;
    private JButton btnSoumettreMot;
    private BorderLayout borderLayout;
    private JLabel imageLabel;
    private int nbVies;

    /**
     * Construction d'un objet PenduVue
     * @param penduModel model
     */
    public PenduVue(PenduModel penduModel) {
        this.model = penduModel;
        this.borderLayout = new BorderLayout();
        this.nbVies = 3;
        setBackground(Color.WHITE);
        setLayout(borderLayout);

        creerZoneSaisie();

        imageLabel = new JLabel();
        add(imageLabel, BorderLayout.NORTH);
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
     * @param definition definition du mot
     */
    public void afficherDefinition(String definition) {
        JLabel labelDef = new JLabel();
        labelDef.setText(definition);
        labelDef.setFont(new Font("Arial", Font.PLAIN, 20));
        setLayout(borderLayout);
        add(labelDef, BorderLayout.NORTH);
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
        btnSoumettreMot.addActionListener(e -> verifierMot());
    }

    /**
     * Récupère le mot saisie par le joueur et vérifie qu'il est égal au mot tiré
     */
    protected void verifierMot() {
        String motPropose = textArea.getText();
        boolean isMotEgal = verificationProposition(motPropose);
        if (!isMotEgal) {
            afficherImagePendu();
            afficherPerteVie();
        } else {
            // Fin de la partie
            // todo affichage message de victoire
            System.out.println("YOUHOUUUUUUUUUUUU");
        }
    }

    /**
     * Affiche la vie restante au joueur, si il n'a plus de vie,
     * affiche le mot entier
     */
    private void afficherPerteVie() {
        nbVies--;
        System.out.println(nbVies);
        if (nbVies == 0) {
            afficherDefaite();
            // todo affichage mot entier
        } else {
            for (int i = 0; i <= nbVies; i++) {
                ImageIcon imageVie = new ImageIcon("heart.png");
                Image image = imageVie.getImage();
                Image imageResized = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                imageVie = new ImageIcon(imageResized);
                JLabel labelVie = new JLabel();
                labelVie.setIcon(imageVie);
                setLayout(borderLayout);
                add(labelVie, borderLayout.NORTH);
            }
        }
    }

    protected void afficherVie() {
        setLayout(new FlowLayout());
        for (int i = 0; i <= nbVies; i++) {
            ImageIcon imageVie = new ImageIcon("heart.png");
            Image image = imageVie.getImage();
            Image imageResized = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            imageVie = new ImageIcon(imageResized);
            JLabel labelVie = new JLabel();
            labelVie.setIcon(imageVie);
            add(labelVie);
        }
    }

    /**
     * Affiche le message de défaite lorqu'un joueur n'a plus de vie
     */
    private void afficherDefaite() {
        JLabel labelDef = new JLabel();
        labelDef.setText("VOUS AVEZ PERDU");
        labelDef.setFont(new Font("Arial", Font.PLAIN, 40));
        add(labelDef, BorderLayout.SOUTH);

        // TODO retirer btn soumettre mot
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

    private void afficherNbLettres(String mot) {
        JLabel labelDef = new JLabel();
        labelDef.setText("Nombre de lettres : " + getNbLettres(mot));
        labelDef.setFont(new Font("Arial", Font.PLAIN, 40));
        add(labelDef, BorderLayout.SOUTH);
    }
}