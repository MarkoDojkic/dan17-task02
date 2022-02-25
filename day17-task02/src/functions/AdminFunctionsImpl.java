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
    public void showInsertMenu() {
        Scanner input = new Scanner(System.in);
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
        return null;
    }

    @Override
    public User deleteUser(String username) {
        return null;
    }
}
