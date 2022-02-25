package functions;

import model.Role;
import model.User;

public interface AdminFunctions {
    public void showInsertMenu();
    public void insert(String name, String surname, String username, String password, Role role);
    public void showAllUsers();
    public void showUser(String username);
    public User editUser(String username);
    public User deleteUser(String username);
}
