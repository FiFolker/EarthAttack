/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package earthattack;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author msuzin, calmuller, ellemerle, onaib
 */
public class EarthAttack {

	static final String[] FILES = {"question", "answer", "coords"};
	static int numberOfQuestion = 10;
	
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
    }
    
    
    /**
     * Simule un chargement avant la prochaine question si la précèdent était juste.
     * @param result si la question a été réussi ou pas.
     * @throws InterruptedException 
     */
    static void loadingNextAnswer(boolean result) throws InterruptedException{
        if (result){
            System.out.println("Sending new code...");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Loading code...");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Code ok...");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Moving to next fixing step : ");
        }
    }
	
	public static void loadQuestions() {
		Question[] questions = new Question[numberOfQuestion];
		int actualQuestion = 0;

		String temp = "";
		String[][] nameAndDesc = new String[numberOfQuestion][2];
		String[] answer = new String[numberOfQuestion];
		String[] coords = new String[numberOfQuestion];

		for (int i = 0; i < FILES.length; i++) {
			try (Scanner fileRead = new Scanner(new File(FILES[i]))) {
				temp = fileRead.nextLine();

				String[] split = temp.split(";");

				
				switch (i) {
					case 0:
						for (int j = 0; j < split.length; j++) {
							String[] tempSplit = split[j].split(",");
							nameAndDesc[actualQuestion][0] = tempSplit[0];
							nameAndDesc[actualQuestion][1] = tempSplit[1];
						}
						break;
					case 1:
						answer = split;
						break;
					case 2:
						coords = split;
						break;
				}
				
				
			} catch (Exception ex) {
				System.out.println("Exception ex : " + ex);
				ex.printStackTrace();
			}
		}
		
		for(int i=0; i<numberOfQuestion; i++){
			questions[i] = new Question(nameAndDesc[i][0], nameAndDesc[i][1], answer[Integer.parseInt(coords[i])]);
		}

	}

    /**
     * Calcule le temps qui s'écoule. 
     * @param run booléen qui est à faux si toute les réponses ont été répondus, vrai
     * sinon.
     * @return le temps écoulé en secondes. 
     */
    static double clock(boolean run){
        double time = 0;
        double startTime = System.nanoTime() / 10e9;
        double currentTime;
        while (time <= 1200 & run){
            currentTime = System.nanoTime();
            time =  currentTime - startTime;
        }
        return time;
    }
    
}
