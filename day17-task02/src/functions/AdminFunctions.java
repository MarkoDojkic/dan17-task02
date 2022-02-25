package functions;

import model.Role;
import model.User;

import java.util.Scanner;

public interface AdminFunctions {
    void showInsertMenu(Scanner input);
    void insert(String name, String surname, String username, String password, Role role);
    void showAllUsers();
    void showUser(String username);
    User editUser(String username);
    User deleteUser(String username);
}
