package pendu.tests;

import static pendu.PenduModel.*;

public class PenduModelTest {

    public static void main(String[] args) {

        // On vérifie si le fichier est bien lu et qu'une ligne est bien tirée aléatoirement
        System.out.println(getLigneAleatoire("mots.txt"));
        System.out.println(getLigneAleatoire("mots.txt"));
        System.out.println(getLigneAleatoire("mots.txt"));
        System.out.println(getLigneAleatoire("mots.txt"));

        System.out.println("--------------------------------");

        // On vérifie que la découpe de la ligne fonctionne bien
        String ligne1 = getLigneAleatoire("mots.txt");
        System.out.println(ligne1);
        System.out.println(getMot(ligne1));
        System.out.println(getDefinition(ligne1));

        System.out.println("--------------------------------");

        String ligne2 = getLigneAleatoire("mots.txt");
        System.out.println(getMot(ligne2));
        System.out.println(getDefinition(ligne2));
    }
}
