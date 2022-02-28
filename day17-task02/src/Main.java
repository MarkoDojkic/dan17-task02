import functions.AdminFunctionsImpl;
import model.Role;
import model.User;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int tries = 0, choice = -1;
        String currentUsername = "";
        boolean isWrongPassword = false, isUserLoggedIn = false;
        List<User> users = new ArrayList<>();
        users.add(new User("Admin", "Admin", "admin", "admin1", Role.ADMIN));

        AdminFunctionsImpl adminFunctionsImpl = new AdminFunctionsImpl(users);

        System.out.println("Welcome to our program. © Marko Dojkić and Marko Todić 2022");

        while(true) {
            if(!isUserLoggedIn) {
	        	tries = 0;
	            isWrongPassword = false;
	            System.out.print("Please enter your username (type 0 to quit program): ");
	            currentUsername = input.nextLine();
            }
            if (currentUsername.equals("admin")) {
            	if(!isUserLoggedIn) {
	            	do {
	                    System.out.print("Please enter admin password: ");
	                    String inputPassword = input.nextLine();
	                    if(inputPassword.equals(adminFunctionsImpl.findUser("admin").getPassword())) isWrongPassword = false;
	                    else tries++;
	                } while (tries < 4 && isWrongPassword);
	                isUserLoggedIn = true;
	                if(tries == 4) throw new Exception("Wrong password entered 4 times, program terminated");
            	}
                showAdminOptions();
                try {
                	choice = input.nextInt();
                } catch(InputMismatchException e) {
                	e.printStackTrace();
                	choice = -1;
                }
                
                switch (choice) {
                    case 1 -> adminFunctionsImpl.showInsertMenu();
                    case 2 -> adminFunctionsImpl.showAllUsers();
                    case 3 -> adminFunctionsImpl.showFindUserMenu();
                    case 4 -> adminFunctionsImpl.showEditUserMenu();
                    case 5 -> adminFunctionsImpl.showDeletedUserMenu();
                    case 0 -> isUserLoggedIn = false;
                    default -> System.out.println("Option number incorrect!");
                }
            } else if(adminFunctionsImpl.findUser(currentUsername) != null) {
                do {
                    System.out.print("Please enter password for user " + currentUsername + ": ");
                    String inputPassword = input.nextLine();
                    if(inputPassword.equals(adminFunctionsImpl.findUser(currentUsername).getPassword())) isWrongPassword = false;
                    else tries++;
                } while (tries < 4 && isWrongPassword);
                isUserLoggedIn = true;
                if(tries == 4) throw new Exception("Wrong password entered 4 times, program terminated");
                
                System.out.println("User " + currentUsername + " has successfuly logged in. Input 0 to logout.");
                while(input.nextInt() != 0);
                System.out.println("User " + currentUsername + " has successfuly logged out.");
                isUserLoggedIn = false;
            } else if(currentUsername.charAt(0) == '0') {
            	System.out.println("Goodbye. We hope to see you soon.");
            	System.exit(0);
            }
            else System.out.println("User with username " + currentUsername + " does not exist!");
        }
    }

    private static void showAdminOptions() {
        System.out.println("Input wanted option:");
        System.out.println("1. Insert");
        System.out.println("2. Show all users info");
        System.out.println("3. Show certain user info");
        System.out.println("4. Edit certain user");
        System.out.println("5. Delete certain user");
        System.out.println("0. Logout");
        System.out.print("Chosen option: ");
    }
}
