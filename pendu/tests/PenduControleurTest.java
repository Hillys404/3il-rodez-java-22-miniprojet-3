package pendu.tests;

import pendu.PenduControleur;

import static pendu.PenduControleur.getMotAleatoire;

public class PenduControleurTest {

    public static void main(String[] args) {

        // On vérifie si le fichier est bien lu et qu'un mot est bien tiré aléatoirement
        System.out.println(getMotAleatoire("mots.txt"));
        System.out.println(getMotAleatoire("mots.txt"));
        System.out.println(getMotAleatoire("mots.txt"));
        System.out.println(getMotAleatoire("mots.txt"));

    }
}
