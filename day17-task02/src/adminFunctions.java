public interface adminFunctions {
    public static void showInsertMenu();
    public static void insert(String name, String surname, String username, String password, Role role);
    public static void showAllUsers();
    public static void showUser(String username);
    public static User editUser(String username);
    public static User deleteUser(String username);
}
