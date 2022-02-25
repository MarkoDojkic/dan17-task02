package functions;

import model.Role;
import model.User;

import java.util.List;
import java.util.Scanner;

public class AdminFunctionsImpl implements AdminFunctions {
    Scanner input = new Scanner(System.in);
    private List<User> users;

    public AdminFunctionsImpl(List<User> users) {
        this.users = users;
    }

    public void showInsertMenu() {
        int index = 0;
        boolean isUsernameUnique = false, isPasswordCorrect = false;
        String[] currentInput = new String[5];

        if(currentInput[3] == null) {
            System.out.println("Enter info about user (all fields are required!)");
            System.out.print("\tEnter name: ");
            currentInput[index++] = input.nextLine();
            System.out.print("\tEnter surname: ");
            currentInput[index++] = input.nextLine();
            do {
                System.out.print("\tEnter username: ");
                currentInput[index] = input.nextLine();
                if(this.findUser(currentInput[index]) == null) { index++; isUsernameUnique = true; }
                else System.out.println("User " + currentInput[index] + "  already exists");
            } while(!isUsernameUnique);
        }

        do {
            System.out.print("\tEnter password: ");
            currentInput[index] = input.nextLine();
            System.out.print("\tEnter password again for confirmation: ");
            currentInput[4] = input.nextLine();
            if (currentInput[index].equals(currentInput[4])) {
                isPasswordCorrect = true;
                index++;
            }
        } while (!isPasswordCorrect);

        do {
            System.out.print("\tEnter user role (1 - Admin, 2 - Editor): ");
            int userRoleId = input.nextInt();
            if (userRoleId == 1) currentInput[index] = "A";
            else if (userRoleId == 2) currentInput[index] = "E";
            else System.out.println("User role input not correct!");
        } while (currentInput[index] == null);

        this.insert(currentInput[0], currentInput[1], currentInput[2], currentInput[3], currentInput[4].equals("A") ? Role.ADMIN : Role.EDITOR);
    }

    @Override
    public void insert(String firstName, String lastName, String username, String password, Role role) {
        this.users.add(new User(firstName, lastName, username, password, role));
        /*this.showUser(username);*/
    }

    @Override
    public void showAllUsers() {
        System.out.println("Currently registered users are:");
        this.users.forEach(user -> System.out.println(user.toString()));
    }

    public void showFindUserMenu(){
        System.out.print("Enter username to find: ");
        this.showUser(input.nextLine());
    }

    public void showEditUserMenu(){
        System.out.print("Enter username to edit: ");
        this.editUser(input.nextLine());
    }

    public void showDeletedUserMenu(){
        System.out.print("Enter username to delete: ");
        String inputUsername = input.nextLine();
        System.out.println("Deletion of user " + inputUsername + " is " + (this.deleteUser(inputUsername) ? "successful" : "not successful"));
    }

    @Override
    public void showUser(String username) {
        User foundUser = this.findUser(username);
        System.out.println(foundUser == null ? "User with username " + username + " is not yet registered!" : "Found user: " + foundUser);
    }

    public User findUser(String username){
        return this.users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
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

            switch (userInput) {
                case 1 -> {
                    System.out.println("Enter new username");
                    finded.setUsername(input.nextLine());
                }
                case 2 -> {
                    System.out.println("Enter new first name");
                    finded.setFirstName(input.nextLine());
                }
                case 3 -> {
                    System.out.println("Enter new last name");
                    finded.setLastName(input.nextLine());
                }
                default -> System.out.println("The entered option is not available");
            }
        } while (userInput != 4);

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