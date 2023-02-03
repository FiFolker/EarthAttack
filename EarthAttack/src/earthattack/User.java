package earthattack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
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
	static HashSet<User> users = new HashSet<>();

	User() {
		this.name = "";
		this.score = 0.;
		users.add(this);
	}

	User(String nName, double nScore) {
		this.name = nName;
		this.score = nScore;
	}

	public static void main(String[] args) {
		User.initialiseUsers();
		System.out.println(User.users.toString());
		flushUsers();
	}

	static void initialiseUsers() {
		try (Scanner file = new Scanner(new File(EarthAttack.FILES[3]))) {
			while (file.hasNextLine()) {
				String line = file.next();
				String[] userScoreTogether = line.split(";");
				System.out.println(userScoreTogether.length);
				for (int i = 0; i < userScoreTogether.length; i++) {
					String[][] userInfo = new String[userScoreTogether.length][2];
					for (int j = 0; j < 2; j++) {
						userInfo[i][j] = userScoreTogether[i].split(",")[j];
					}
					User user = new User(userInfo[i][0], Double.parseDouble(userInfo[i][1]));
					users.add(user);
				}
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	static boolean validUser(String name) {
		// Could apply different rules to format names but it isn't needed YET
		return users.contains(name) & !name.isEmpty();
	}

	static void flushUsers() {
		try (PrintWriter fileLeaderboard = new PrintWriter(new File(EarthAttack.FILES[3]));) {
			ArrayList<User> sortedUser = sortUsers();
			for (User u : sortedUser) {
				fileLeaderboard.print(u.name + "," + u.score + ";");
			}

		} catch (Exception ex) {
			System.out.println("Error in flushUsers() "+ ex);
		}
	}
	
	static ArrayList<User> sortUsers(){
		ArrayList<User> sortedUserList = new ArrayList<User>(users);
		sortedUserList.sort(new Comparator<User>(){
			@Override
			public int compare(User u1, User u2){
				if(u1.score > u2.score){
					return -1;
				}else{
					return 1;
				}
			}
		});
		return sortedUserList;
	}

	static User userSelect() {
		Scanner sc = new Scanner(System.in);
		String name = "";
		do {
			System.out.println("Saisisez un pseudonyme.");
			name = sc.next();
		} while (User.validUser(name));

		return new User(name, 0);
	}

}


	
	

