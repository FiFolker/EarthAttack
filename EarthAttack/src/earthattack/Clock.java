/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package earthattack;

/**
 *
 * @author calmuller
 */
public class Clock extends Thread {

    double startTime;
    boolean run;
    double time;

    /**
     * Constructeur par défaut.
     */
    Clock() {
        this.startTime = 0;
        this.run = true;
    }

    /**
     * Constructeur de clock.
     *
     * @param sT le temps de départ
     * @param cT le temps courant
     * @param t le temps à calculer
     */
    Clock(double sT, boolean run) {
        this.startTime = sT;
        this.run = run;
    }

    void getClocked() {
        double sT = this.startTime;
        this.time = 0;
        double currentTime;
        while (time <= 1200 & run) {
            currentTime = System.nanoTime() / 10e9;
            time = currentTime - sT;
        }

    }

}
