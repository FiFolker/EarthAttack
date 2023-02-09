package earthattack;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author msuzin, calmuller, ellemerle, onaib
 */
public class EarthAttack {

    static final String[] FILES = {"ressources/data/question", "ressources/data/answer", "ressources/data/order", "ressources/data/leaderboard"};
    static int numberOfQuestion = 2;
    static final String[] answerSheets = new String[10];
    static Scanner input = new Scanner(System.in);
    private static Duration MAX_DURATION = Duration.ofSeconds(1200);
    private static int penalty = 0;
    private static String[] options = {"true", "normal"}; // options[0] = rolePlay; options[1] = difficulty; Boolean.getBoolean(options[0]);
    static final int lengthLeaderboard = 10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        // Loads all the answers in the answer sheet.
        initialiseAnswers(answerSheets);
        // Loads all the users from the leaderboard.
        User.initialiseUsers();
        menu();

    }

    /**
     * Check for a int scanner if the answer is also a int for catch the
     * exception if it's not an int
     *
     * @param input Scanner
     * @param choice int answer
     * @return the answer
     */
    public static int checkIfScannerIsInt(Scanner input, int choice) {
        try {
            choice = input.nextInt();
        } catch (InputMismatchException ex) {
            input.next();
            System.out.println("Il faut rentrer un nombre entier compris dans les choix possibles !");
        }
        return choice;
    }

    /**
     * Affiche le menu et gère les choix renvoyés
     */
    public static void menu() {
        Question[] questionLoaded = loadQuestions();
        int choice = 0;
        do {
            switch(options[1]){
                case "easy":
                    penalty = 20;
                    break;
                case "normal":
                    penalty = 40;
                    break;
                case "hard":
                    penalty = 60;
                    break;
                default:
                    break;
            }
            UI.showMenu();
            choice = checkIfScannerIsInt(input, choice);
            switch (choice) {
                case 1:
                    play(questionLoaded);
                    break;
                case 2:
                    UI.showLeaderboard(lengthLeaderboard);
                    break;
                case 3:
                    optionsMenu();
                    break;
                case 4:
                    System.out.println("Au revoir...");
                    break;
                default:
                    System.out.println("Vous devez choisir un nombre entre 1 et 3 !");
                    break;
            }
        } while (choice != 4);

    }

    
    /**
     * Function that handles the options menu.
     */
    static void optionsMenu() {
        UI.showOptions();
        int mainChoice = -1;
        Boolean correctAnswer = false;
        while (!correctAnswer) {
            mainChoice = checkIfScannerIsInt(input, mainChoice);
            switch (mainChoice) {
                case 1:
                    difficultyChoice();
                    correctAnswer = true;
                    break;
                case 2:
                    roleplayChoice();
                    correctAnswer = true;
                    break;
                case 3:
                    correctAnswer = true;
                    break;
                default:
                    System.out.println("Veuillez saisir un nombre valide entre 1 et 3.");
                    break;
            }
        }
    }

    
    /**
     * Function that handles the difficulty menu.
     */
    static void difficultyChoice() {
        UI.showDifficultyMenu();
        Boolean correctAnswer = false;
        while (!correctAnswer) {
            int answer = -1;
            answer = checkIfScannerIsInt(input, answer);
            switch (answer) {
                case 1:
                    options[1] = "easy";
                    optionsMenu();
                    correctAnswer = true;
                    break;
                case 2:
                    options[1] = "normal";
                    optionsMenu();
                    correctAnswer = true;
                    break;
                case 3:
                    options[1] = "hard";
                    optionsMenu();
                    correctAnswer = true;
                    break;
                case 4:
                    optionsMenu();
                    correctAnswer = true;
                    break;
                default:
                    System.out.println("1, 2 ou 3 seulement");
                    break;
            }
        }
    }

    
    /**
     * Function that handles the roleplay menu.
     */
    static void roleplayChoice() {
        UI.showRoleplayMenu();
        Boolean correctAnswer = false;
        while (!correctAnswer) {
            int answer = input.nextInt();
            switch (answer) {
                case 1:
                    options[0] = "true";
                    correctAnswer = true;
                    break;
                case 2:
                    options[0] = "false";
                    correctAnswer = true;
                    break;
                case 3:
                    optionsMenu();
                    correctAnswer = true;
                    break;
                default:
                    System.out.println("Oui ou Non seulement");
                    break;
            }
        }
    }

    /**
     * Lance le QUIZZ en affichant les questions, prenant une réponse et donnant
     * le résultat.
     *
     * @param questions Questions loaded
     */
    static void play(Question[] questions) {
        Duration elapsedTime;
        int i = 0;
        String reply = "";
        boolean correctAnswer = false, timeExpired = MAX_DURATION.isNegative();
        // Asks the user to choose their username.
        User usr = User.userSelect();
        var startTime = Instant.now(); // time when user start quizz
        do {
            elapsedTime = Duration.between(startTime, Instant.now());
            UI.showEarth();
            questions[i].showQuestion(answerSheets[i]);
            reply = input.next();
            correctAnswer = reply.toLowerCase().equals(questions[i].answer);
            if (correctAnswer) {
                System.out.println("Bonne réponse !");
                try {
                    if (i != questions.length && options[0].equals("true")) {
                        loadingNextAnswer(correctAnswer);
                    }
                } catch (Exception ex) {
                    System.out.println("le loading next answer a fait n'imp " + ex);
                    ex.printStackTrace();
                }
                i++;
            } else if (reply.toLowerCase().charAt(0) >= 'a' && reply.toLowerCase().charAt(0) <= 'd') {
                System.out.println("Perdu ... vous avez perdu " + penalty + " sec !");
                MAX_DURATION = MAX_DURATION.minus(Duration.ofSeconds(penalty));
            } else {
                System.out.println("ASSUREZ VOUS DE REPONDRE AVEC 'a' 'b' 'c' ou 'd'");
            }
        } while (i < questions.length && MAX_DURATION.getSeconds() - elapsedTime.getSeconds() > 0 && !timeExpired);

        if (MAX_DURATION.getSeconds() > 0) {
            usr.score = MAX_DURATION.getSeconds() - elapsedTime.getSeconds();
            System.out.println("GAGNÉ !");
            UI.showGoodEnd();
        } else {
            System.out.println("PERDU ...");
            UI.showBadEnd();
            usr.score = 0;
        }

        User.flushUsers();
        showEnd(usr);
    }

    static void showEnd(User usr) {
        int rank = usr.getRank();
        System.out.println("Vous êtes classé : " + rank + "/" + User.users.size() + " avec " + usr.score + " points");
        UI.showLeaderboard(lengthLeaderboard);

    }

    /**
     * Simule un chargement avant la prochaine question si la précèdent était
     * juste.
     *
     * @param result si la question a été réussi ou pas.
     * @throws InterruptedException
     */
    static void loadingNextAnswer(boolean result) throws InterruptedException {
        if (result) {
            System.out.println("Sending new code...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Loading code...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Code ok...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Moving to next fixing step : ");
        }
    }

    /**
     * Charge les questions dans un tableau d'instance de Question
     *
     * @return l'array de Question
     */
    public static Question[] loadQuestions() {
        Question[] questions = new Question[numberOfQuestion];

        String temp = "";
        String[][] nameAndDesc = new String[numberOfQuestion][2];
        String[] answer = new String[numberOfQuestion];
        String[] order = new String[numberOfQuestion];

        for (int i = 0; i < FILES.length; i++) {
            try (Scanner fileRead = new Scanner(new File(FILES[i]))) {
                temp = fileRead.nextLine();

                String[] split = temp.split(";");

                switch (i) {
                    case 0:
                        for (int j = 0; j < split.length; j++) {
                            String[] tempSplit = split[j].split(",");
                            nameAndDesc[j][0] = tempSplit[0];
                            nameAndDesc[j][1] = tempSplit[1];
                        }
                        break;
                    case 1:
                        answer = split;
                        break;
                    case 2:
                        order = split;
                        break;
                }

            } catch (Exception ex) {
                System.out.println("Exception ex : " + ex);
                ex.printStackTrace();
            }
        }

        for (int i = 0; i < numberOfQuestion; i++) {
            questions[i] = new Question(nameAndDesc[i][0], nameAndDesc[i][1], answer[Integer.parseInt(order[i])]);
        }
        return questions;
    }

    /**
     * *
     *
     * @param tab tableau contenants l'entiérté des réponses
     */
    static void initialiseAnswers(String[] tab) {
        tab[0] = "A) c'est pas elle ; B) try 2; C) c'est elle ; D) try 4";
        tab[1] = "A) c'est elle ; B) try 22; C) try 23; D) c'est pas elle";
        tab[2] = "";
        tab[3] = "";
        tab[4] = "";
        tab[5] = "";
        tab[6] = "";
        tab[7] = "";
        tab[8] = "";
        tab[9] = "";
    }

}
