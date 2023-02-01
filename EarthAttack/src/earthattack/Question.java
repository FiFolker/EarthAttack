/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package earthattack;

/**
 *
 * @author msuzin
 */
public class Question {

    /* 
        Format du fichier question.
        nom1,description1;nom2,description2;
    
        Format du fichier réponse.
        rep1;rep2;rep3;
        
        Format du fichier ordre.
        numR1,numQ1;numR2,numQ2
    
        Affichage de la question : 
    Restauration : Un Système Défaillant
        Suite à de récente perturbation magnétique...
    */
    
    /***
     * For testing purposes
     * @param args 
     */
    public static void main(String[] args){
        Question q1 = new Question("nom1","desc1","rep1");
        q1.afficherQuestion();
        System.out.println(q1.reponse);
    }
    
    String nom;
    String description;
    String reponse;
    
    Question(String nNom, String nDesc, String nRep){
        this.nom = nNom;
        this.description = nDesc;
        this.reponse = nRep;
    }
    
    void afficherQuestion(){
        StringBuilder str = new StringBuilder();
        str.append("Restauration : ")
           .append(this.nom)
           .append("\n\t")
           .append(this.description);
        System.out.println(str.toString());
    }
}
