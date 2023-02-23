package earthattack;

public class Question {

    /* 
        Format du fichier question.
        nom1,description1;nom2,description2;
    
        Utiliser le caractère '^' à la place de \n
    
        Format du fichier answer.
        rep1;rep2;rep3;
        
        Format du fichier order.
        numR1;numR2
        Position obtenue selon l'ordre.
    
        Format du fichier leaderboard.
        userName1,score1;userName2,score2
    
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
        q1.showQuestion(str);
        System.out.println(q1.answer);
    }
    
    String name;
    String description;
    String answer;
    static final String SYS_LINE_SEP = System.lineSeparator();
    static final String Q_LINE_SEP = "^";
    
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
    void showQuestion(String allA){
        
        System.out.println("Instruction : ");
        
        String[] name = Question.formatLine(this.name,Q_LINE_SEP);
        for(int i =0;i<name.length;i++){
            System.out.print("\t");
            System.out.print(name[i] + SYS_LINE_SEP);
        }
        System.out.println("");
        String[] desc = Question.formatLine(this.description,Q_LINE_SEP);
        for(int i =0;i<desc.length;i++){
            System.out.print("\t");
            System.out.print(desc[i] + SYS_LINE_SEP);
        }
        
        System.out.println("\t"+allA);
    }
    
    /***
     * 
     * @param line {@code String} represents the formatted line
     * @param sep {@code String} represents the separator used to format the line
     * @return {@code String[]} that contains the terms in {@code line} separated by {@code sep}
     */
    public static String[] formatLine(String line, String sep){
        return line.split("\\"+sep);
    }
}
