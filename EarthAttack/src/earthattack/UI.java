/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package earthattack;

/**
 *
 * @author msuzin
 */
public class UI {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    static void remplacerMotif(String motif, String valeur, StringBuilder ecran,
            boolean alignerADroite) {
        if (motif.length() < valeur.length()) {
            // chaîne rognée à droite si trop longue
            valeur = valeur.substring(0, motif.length());
        }
        if (motif.length() > valeur.length()) {
            // chaîne complétée avec des espaces si trop vide
            String format = "%" + (alignerADroite ? "" : "-") + motif.length() + "s";
            valeur = String.format(format, valeur);
        }
        int index = ecran.indexOf(motif);
        if (index >= 0) {
            ecran.replace(index, index + motif.length(), valeur);
        }
    }
}
