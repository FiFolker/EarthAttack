/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package earthattack;

/**
 *
 * @author msuzin
 */
public class User {
    
    double time;
    String name;
    
    User(){
        this.name = "";
        this.time = 0.;
    }
    
    User(String nName, double nTime){
        this.name = nName;
        this.time = nTime;
    }
    
}
