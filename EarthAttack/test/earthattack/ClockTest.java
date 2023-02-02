/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package earthattack;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author calmuller
 */
public class ClockTest {

    public ClockTest() {
    }

    @Test
    public void testGetClocked() {
        double startTime = System.nanoTime() / 10e9;
        boolean run = true;
        Clock clock = new Clock(startTime, run);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(EarthAttackTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        clock.start();
        clock.run = false;
        assertEquals(clock.time, 2.0, 0.1);
    }

}
