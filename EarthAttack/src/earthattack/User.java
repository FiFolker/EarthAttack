package earthattack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author msuzin
 */
public class User {

    double score;
    String name;
    static ArrayList<User> users = new ArrayList<>();

    User() {
        this.name = "";
        this.score = 0.;
        users.add(this);
    }

    User(String nName, double nScore) {
        this.name = nName;
        this.score = nScore;
    }

    static void initialiseUsers(){
        try(Scanner file = new Scanner(new File(EarthAttack.FILES[3]))){
           while(file.hasNextLine()){
               String line = file.next();
               line.split(";");
               
               User user = null;
               users.add(user);
           } 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static boolean validUser(String name) {
        boolean userNotFound = true;
        int i = 0;
        while (userNotFound & i < users.size()) {
            User cUser = users.get(i);
            userNotFound = (cUser.name != name) & (!cUser.name.isEmpty());
        }

        return userNotFound;
    }

    static void flushUsers() {
        try (PrintWriter fileLeaderboard = new PrintWriter(new File(EarthAttack.FILES[3]));){
			
			for(User u : users){
				fileLeaderboard.print(u.name +","+ u.score + ";");
			}
			
		} catch (FileNotFoundException ex) {
			System.out.println("Ouverture du fichier impossible : " + ex);
		} catch (IOException ex) {
			System.out.println("Erreur d'écriture : " + ex);
		}

    }
    
    static User userSelect() {
        Scanner sc = new Scanner(System.in);
        String name = "";
        do{
            System.out.println("Saisisez un pseudonyme.");
            name = sc.next();
        } while (!User.validUser(name));

        return new User(name, 0);
    }

}
