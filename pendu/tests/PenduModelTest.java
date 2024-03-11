package pendu.tests;

import static pendu.PenduModel.getMotAleatoire;

public class PenduModelTest {

    public static void main(String[] args) {

        // On vérifie si le fichier est bien lu et qu'un mot est bien tiré aléatoirement
        System.out.println(getMotAleatoire("mots.txt"));
        System.out.println(getMotAleatoire("mots.txt"));
        System.out.println(getMotAleatoire("mots.txt"));
        System.out.println(getMotAleatoire("mots.txt"));

    }
}
