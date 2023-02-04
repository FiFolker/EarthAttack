/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package earthattack;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author utilisateur
 */
public class UserTest {
    @Test
    public void validUserTest(){
        String name = "A";
        System.out.println("User list Before");
        User.userList();
        User u = new User(name,0.);
        System.out.println("User List After");
        User.userList();
        System.out.println(User.validUser("zz"));
    }
}
