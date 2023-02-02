/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package earthattack;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author msuzin
 */
public class EarthAttackTest {

    @Test
    public void clockTest() {
        DecimalFormat df = new DecimalFormat("#.###");
        double startTime = System.nanoTime() / 10e9;
        double t = EarthAttack.clock(true, startTime);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(EarthAttackTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        t = EarthAttack.clock(false, startTime);
        System.out.println(t);
        System.out.println(df.format(t));
        assertTrue(EarthAttack.clock(true, startTime) >= 2);
    }

    @Test
    public void clkTest() {
        DecimalFormat df = new DecimalFormat("#.###");
        
    }

}
