package earthattack;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author msuzin, calmuller, ellemerle, onaib
 */
public class EarthAttack {

    static final String[] FILES = {"question", "answer", "order", "leaderboard"};
    static int numberOfQuestion = 2;
    static final String[] answerSheets = new String[10];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Question[] questions = loadQuestions();
        initialiseAnswers(answerSheets);
        User usr = User.userSelect();
        questions[0].afficherQuestion(answerSheets[0]);
        double startTime = System.nanoTime() / 10e9;
        Clock clock = new Clock((System.nanoTime() / 10e9), true);
        clock.start();
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
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Loading code...");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Code ok...");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Moving to next fixing step : ");
        }
    }

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
        tab[0] = "";
        tab[1] = "";
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
