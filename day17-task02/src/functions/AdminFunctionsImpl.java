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
        int index = 0;
        boolean isPasswordCorrect = false;
        String[] currentInput = new String[5];
        User newUser = null;
        System.out.println("Enter info about user (all fields are required!)");
        System.out.print("\tEnter name: ");
        currentInput[index++] = input.nextLine();
        System.out.print("\tEnter surname: ");
        currentInput[index++] = input.nextLine();
        System.out.print("\tEnter username: ");
        currentInput[index++] = input.nextLine();
        do {
            System.out.print("\tEnter password: ");
            currentInput[index] = input.nextLine();
            System.out.print("\tEnter password again for confirmation: ");
            currentInput[4] = input.nextLine();
            if (currentInput[index].equals(currentInput[4])) {
                try {
                    newUser.setPassword(currentInput[index]);
                    isPasswordCorrect = true;
                    index++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } while (!isPasswordCorrect);
        do {
            System.out.print("\tEnter user role (1 - Admin, 2 - Editor: ");
            if (input.nextInt() == 1) currentInput[index] = "A";
            else if (input.nextInt() == 2) currentInput[index] = "E";
            else System.out.println("User role input not correct!");
        } while (currentInput[index] == null);

        this.insert(currentInput[0], currentInput[1], currentInput[2], currentInput[3], currentInput[4].equals("A") ? Role.ADMIN : Role.EDITOR);
    }

    @Override
    public void insert(String firstName, String lastName, String username, String password, Role role) {
        this.users.add(new User(firstName, lastName, username, password, role));
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