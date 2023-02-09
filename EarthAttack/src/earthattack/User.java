package earthattack;

import java.io.File;
import java.io.FileNotFoundException;
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

    /**
     * The Default Class Constructor Instantiates a {@code User} with
     * {@code this.name = ""} and {@code this.score = 0.} It then adds them to
     * {@code User.users}.
     */
    User() {
        this.name = "";
        this.score = 0.;
        users.add(this);
    }

    /**
     * The Intended Class Constructor Instantiates a {@code User} with
     * {@code this.name = nName} and {@code this.score = nScore} It checks if
     * the name is valid if it isn't the name will default to "". It then adds
     * them to {@code User.users}.
     *
     * @param nName {@code String} that represents the name of the {@code User}.
     * @param nScore {@code Double} that represents the score of the
     * {@code User}.
     */
    User(String nName, double nScore) {
        this.name = nName;
        this.score = nScore;
        users.add(this);
    }

    /**
     * Main pour test
     *
     * @param args
     */
    public static void main(String[] args) {
        User.initialiseUsers();
        User.userList();
        User.flushUsers();
    }

    /**
     * Prints out a list of all the {@code User} in {@code User.users}.
     */
    public static void userList() {
        for (User u : User.users) {
            System.out.print("" + u.name + "," + u.score + ";\n");
        }
    }

    /**
     * Reads out the info of all the users contained in the leader board
     * instantiates them to a {@code User} and adds them to {@code User.users}.
     */
    static void initialiseUsers() {
        try (Scanner file = new Scanner(new File(EarthAttack.FILES[3]))) {
            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] userScoreTogether = line.split(";");
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

    /**
     * Checks if the name is valid or not
     *
     * @param name {@code String} to check
     * @return {@code boolean} that represents the state of validity
     */
    static boolean validUser(String name) {
        // Applied checks to make sure the name is printable
        // Checks if the names length is inferior or equal to 8.
        boolean usernameFound = false, carCorrect = false;
        if (name.toCharArray().length <= 8) {
            for (User u : users) {
                //Checks if the username isn't already used by another User.
                usernameFound = !u.name.toLowerCase().equals(name.toLowerCase());
                if (!usernameFound) {
                    break;
                }
            }
            char[] cars = name.toCharArray();
            for (char c : cars) {
                // Checks if c is in the AlphaNumerical format.
                carCorrect = (c >= 'a' & c <= 'z') || (c >= 'A' & c <= 'Z') || (c >= '0' & c <= '9');
            }

        } else {
            System.out.println("Vous devez rentrer une pseudo étant égal à 8 caractères maximum !");
            usernameFound = false;
            carCorrect = false;
        }
        return usernameFound && carCorrect;
    }

    /**
     * Flushes out all the current {@code User} contained in {@code User.users}
     * to a file with the following format : name,score;name2,score2;
     */
    static void flushUsers() {
        try (PrintWriter fileLeaderboard = new PrintWriter(new File(EarthAttack.FILES[3]));) {
            ArrayList<User> sortedUser = sortUsers();
            for (User u : sortedUser) {
                fileLeaderboard.print(u.name + "," + u.score + ";");
            }

        } catch (Exception ex) {
            System.out.println("Error in flushUsers() " + ex);
        }
    }

    /**
     * Sorts all the {@code User} in {@code User.users} in descending order
     *
     * @return {@code ArrayList<User>} with the sorted {@code User} by score
     */
    static ArrayList<User> sortUsers() {
        ArrayList<User> sortedUserList = new ArrayList<User>(users);
        sortedUserList.sort(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                if (u1.score > u2.score) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        return sortedUserList;
    }

    /**
     * Permits the instantiation of a {@code User} with a valid
     * {@code this.name}
     *
     * @return {@code User} with a valid name.
     */
    static User userSelect() {
        Scanner sc = new Scanner(System.in);
        String name = "";
        do {
            System.out.println("Saisisez un pseudonyme.");
            name = sc.nextLine();
        } while (!User.validUser(name));

        return new User(name, 0);
    }

}
