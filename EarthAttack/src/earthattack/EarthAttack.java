/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package earthattack;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author msuzin
 */
public class EarthAttack {

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
