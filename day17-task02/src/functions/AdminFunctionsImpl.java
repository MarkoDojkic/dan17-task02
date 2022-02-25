package functions;

import model.Role;
import model.User;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AdminFunctionsImpl implements AdminFunctions {
    Scanner input = new Scanner(System.in);
    private List<User> users;
    
    public AdminFunctionsImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public void showInsertMenu() {
        input = new Scanner(System.in);
        String currentInput = "";
        System.out.println("Unesite podatke o korisniku (sva polja su obavezna!)");
        System.out.print("\tUnesite korisničko ime: ");
        currentInput = input.nextLine();
    }

    @Override
    public void insert(String name, String surname, String username, String password, Role role) {

    }

    @Override
    public void showAllUsers() {

    }

    @Override
    public void showUser(String username) {

    }

    @Override
    public User editUser(String username) {
        User finded = users.stream().filter((User user) -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User with " + username + " is not found"));

        System.out.println("Editing user: " + username);

        int userInput;

        do {
            showUpdateUserMenu();

             userInput = this.input.nextInt();

            switch (userInput){
                case 1:
                    System.out.println("Enter new username");
                    finded.setUsername(input.nextLine());
                    break;
                case 2:
                    System.out.println("Enter new first name");
                    finded.setFirstName(input.nextLine());
                    break;
                case 3:
                    System.out.println("Enter new last name");
                    finded.setLastName(input.nextLine());
                    break;
                default:
                    System.out.println("The entered option is not available");
            }
        }while (userInput != 4);

        return finded;
    }

    @Override
    public boolean deleteUser(String username) {
         return users.removeIf((User user) -> user.getUsername().equals(username));
    }

    private void showUpdateUserMenu(){
        System.out.println("1. Username");
        System.out.println("2. First Name");
        System.out.println("3. Last Name");
        System.out.println("4. Cancel");
    }
}
