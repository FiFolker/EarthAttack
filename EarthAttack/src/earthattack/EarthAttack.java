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

}
