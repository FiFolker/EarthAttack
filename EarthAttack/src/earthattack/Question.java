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
        numR1;numR2
        Position obtenue selon l'ordre.
    
        question[0][0] : nom de la question en première position.
            question représente la table après split du fichier question. 
        reponse[0] : reponse en première position.
            reponse représente la table après split du fichier réponse.
        ordre[0] : Où se situe la réponse à la Question 1.
            ordre représente la table après split du fichier ordre.
    
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
        String str = "A) Reponse a; B) Reponse b; C) Reponse c; D) Reponse d;";
        q1.afficherQuestion(str);
        System.out.println(q1.answer);
    }
    
    String name;
    String description;
    String answer;

    
    /***
     * Constructeur par défaut de la classe Question.
     */
    Question(){
        this.name = "";
        this.description = "";
        this.answer = "";
    }
    
    /***
     * Constructeur à utiliser pour la classe Question.
     * @param nName {@code String} représentant le nom attribuer à la {@code Question}.
     * @param nDesc {@code String} représentant la description attribuer à la {@code Question}.
     * @param nAwnser {@code String} représentant la réponse attribuer à la {@code Question}.
     */
    Question(String nName, String nDesc, String nAwnser){
        this.name = nName;
        this.description = nDesc;
        this.answer = nAwnser;
    }
    
    /***
     * 
     * @param allA {@code String} représentant l'ensemble des réponse de la {@code Question}.
     */
    void afficherQuestion(String allA){
        StringBuilder str = new StringBuilder();
        str.append("Restauration : ")
           .append(this.name)
           .append("\n\t")
           .append(this.description)
           .append("\n\t")
           .append(allA);
        System.out.println(str.toString());
    }
}
