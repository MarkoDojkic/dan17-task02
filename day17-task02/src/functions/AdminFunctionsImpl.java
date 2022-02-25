package functions;

import model.Role;
import model.User;

import java.util.List;
import java.util.Scanner;

public class AdminFunctionsImpl implements AdminFunctions {

    private List<User> users;

    public AdminFunctionsImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public void showInsertMenu(Scanner input) {
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
            if(currentInput[index].equals(currentInput[4])) {
                try {
                    newUser.setPassword(currentInput[index]);
                    isPasswordCorrect = true;
                    index++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } while(!isPasswordCorrect);
        do {
            System.out.print("\tEnter user role (1 - Admin, 2 - Editor: ");
            if (input.nextInt() == 1) currentInput[index] = "A";
            else if (input.nextInt() == 2) currentInput[index] = "E";
            else System.out.println("User role input not correct!");
        } while(currentInput[index] == null);

        this.insert(currentInput[0],currentInput[1],currentInput[2],currentInput[3],currentInput[4].equals("A") ? Role.ADMIN : Role.EDITOR);
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
        return null;
    }

    @Override
    public User deleteUser(String username) {
        return null;
    }
}
