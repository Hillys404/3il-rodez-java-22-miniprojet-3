package pendu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
     * Récupère aléatoirement un mot dans une liste
     * @return le mot
     */
    public static String getMotAleatoire(String path) {
        String mot = "";

        List<String> lignes = lectureFichier(path);
        int nbLignes = lignes.size();

        if (nbLignes > 0) {
            // Récupération d'une ligne aléatoirement
            int random = (int) (1 + (Math.random() * nbLignes));
            String ligne = lignes.get(random - 1);

            // Récupération du mot
            String[] mots = ligne.split(" ");
            mot = mots[0];
        }
        return mot;
    }
}
