package pendu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Contient les traitements liés aux ressources du pendu : les mots à faire deviner
 */
public class PenduModel {

    /**
     * Parcours un fichier et place dans une liste toutes les lignes
     */
    private static List<String> lectureFichier(String path) {
        List<String> lignes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                lignes.add(ligne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lignes;
    }

    /**
     * Récupère la définition du mot tiré dans la ligne du fichier
     * @param ligne ligne dans le fichier
     * @return la définition
     */
    public static String getDefinition(String ligne) {
        String[] mots = ligne.split(" ");
        return String.join(" ", Arrays.copyOfRange(mots, 1, mots.length));
    }

    /**
     * Récupère le mot tiré aléatoirement dans la ligne du fichier
     * @param ligne ligne du fichier
     * @return le mot tiré
     */
    public static String getMot(String ligne) {
        String[] mots = ligne.split(" ");
        return mots[0];
    }

    /**
     * Récupère aléatoirement un mot dans une liste
     * @return le mot
     */
    public static String getLigneAleatoire(String path) {
        String ligne = "";

        List<String> lignes = lectureFichier(path);
        int nbLignes = lignes.size();

        if (nbLignes > 0) {
            // Récupération d'une ligne aléatoirement
            int random = (int) (1 + (Math.random() * nbLignes));
            ligne = lignes.get(random - 1);
        }
        return ligne;
    }

    /**
     * Récupère le nombre de lettres dans le mot tiré aléatoirement
     * @param mot
     * @return
     */
    public static int getNbLettres(String mot) {
        return mot.length();
    }
}
