package functions;

import model.Role;
import model.User;

import java.util.Scanner;

public interface AdminFunctions {
    void showInsertMenu();
    void insert(String name, String surname, String username, String password, Role role);
    void showAllUsers();
    void showUser(String username);
    User editUser(String username);
    boolean deleteUser(String username);
}
