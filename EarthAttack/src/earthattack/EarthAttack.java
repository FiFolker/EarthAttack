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
    private static final int PENALTY = 30;
    private static String[] options = {"true", "easy"}; // options[0] = rolePlay; options[1] = difficulty; Boolean.getBoolean(options[0]);
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
     * Affiche le menu et gère les choix renvoyés
     */
    public static void menu() {
        Question[] questionLoaded = loadQuestions();
        int choice = 0;
        do {
            UI.showMenu();
			try {
				choice = input.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("Il faut rentrer un entier compris entre 1 et 3 !");
			}
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
					System.out.println("Au revoir ...");
                    break;
                default:
                    System.out.println("Vous devez choisir un nombre entre 1 et 3 !");
                    break;
            }
        } while (choice != 4);

    }

    static void optionsMenu() {
        UI.showOptions();
        int mainChoice = input.nextInt();
        switch (mainChoice) {
            case 1:
                difficultyChoice();
                break;
            case 2:
                roleplayChoice();
                break;
            default:
                break;
        }
    }

    static void difficultyChoice() {
        System.out.println("Quel est votre choix de difficultée ?\n"
                + "(1) Facile, (2) Moyen, (3) Difficile");
        Boolean correctAnswer = false;
        while (!correctAnswer) {
            int answer = input.nextInt();
            switch (answer) {
                case 1:
                    options[1] = "easy";
                    correctAnswer = true;
                    break;
                case 2:
                    options[1] = "normal";
                    correctAnswer = true;
                    break;
                case 3:
                    options[1] = "hard";
                    correctAnswer = true;
                    break;
                default:
                    System.out.println("1, 2 ou 3 seulement");
                    break;
            }
        }
    }
    
    static void roleplayChoice() {
        System.out.println("Voulez-vous activer les messages de RolePlay ? (O/N)");
        Boolean correctAnswer = false;
        while (!correctAnswer) {
            char answer = input.nextLine().toLowerCase().charAt(0);
            switch (answer) {
                case 'o':
                    options[0] = "true";
                    correctAnswer = true;
                    break;
                case 'n':
                    options[0] = "false";
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
					loadingNextAnswer(correctAnswer);
				} catch (Exception ex) {
					System.out.println("le loading next answer a fait n'imp " + ex);
					ex.printStackTrace();
				}
				i++;
			} else if (reply.toLowerCase().charAt(0) >= 'a' && reply.toLowerCase().charAt(0) <= 'd') {
				System.out.println("Perdu ... vous avez perdu " + PENALTY + " sec !");
				MAX_DURATION = MAX_DURATION.minus(Duration.ofSeconds(PENALTY));
			} else {
				System.out.println("ASSUREZ VOUS DE REPONDRE AVEC 'a' 'b' 'c' ou 'd'");
			}
		} while (i < questions.length && elapsedTime.compareTo(MAX_DURATION) < 0 && !timeExpired);
		if(timeExpired){
			usr.score = MAX_DURATION.getSeconds() - elapsedTime.getSeconds();
		}else{
			usr.score = 0;
		}
		
        if (elapsedTime.compareTo(MAX_DURATION) < 0) {
            System.out.println("GAGNÉ !");
            UI.showGoodEnd();
        } else {
            System.out.println("PERDU ...");
            UI.showBadEnd();
        }
		User.flushUsers();
		showEnd(usr);
    }
	
	static void showEnd(User usr){
		int rank = usr.getRank();
		System.out.println("Vous êtes classé : " + rank + " avec " + usr.score + " points");
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

    /**
     * Calcule le temps qui s'écoule.
     *
     * @param run booléen qui est à faux si toute les réponses ont été répondus,
     * vrai sinon.
     * @return le temps écoulé en secondes.
     */
    static double clock(boolean run, double startTime) {
        double time = 0;
        double currentTime;
        while (time <= 1200 & run) {
            currentTime = System.nanoTime() / 10e9;
            time = currentTime - startTime;
        }
        return time;
    }

}
