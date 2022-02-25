import functions.AdminFunctions;
import model.Role;
import model.User;

import java.util.Scanner;

public class Main implements AdminFunctions {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int tries;
        String currentUsername;
        boolean isWrongPassword;

        System.out.println("Dobrodosli u nas program.");

        while(true) {
            tries = 0;
            isWrongPassword = false;
            System.out.print("Molimo Vas unesite Vaše korisničko ime: ");
            currentUsername = input.nextLine();
            if (currentUsername.equals("<admin_user_name>")) {
                do {
                    System.out.print("Unesite admin lozinku: ");
                    String inputPassword = input.nextLine();
                    if(inputPassword.equals("<admin_password>")) isWrongPassword = false;
                    else tries++;
                } while (tries < 4 && isWrongPassword);
                if(tries == 4) throw new Exception("Wrong password entered 4 times, program terminated");
                showAdminOptions();
                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        showInsertMenu();
                        break;
                    case 2:
                        showAllUsers();
                        break;
                    case 3:
                        showUser();
                        break;
                    case 4:
                        editUser();
                        break;
                    case 5:
                        deleteUser();
                        break;
                    case 0: System.exit(0); break;
                    default:
                        System.out.println("Uneta opcija ne postoji!");
                }
            } else {
                do {
                    System.out.print("Unesite lozinku za korisnika " + currentUsername + ": ");
                    String inputPassword = input.nextLine();
                    if(inputPassword.equals("<korisnik_password>")) isWrongPassword = false;
                    else tries++;
                } while (tries < 4 && isWrongPassword);
                if(tries == 4) throw new Exception("Wrong password entered 4 times, program terminated");
            }
        }
    }

    private static void showAdminOptions() {
        System.out.println("Izaberite željenu opciju:");
        System.out.println("1. Unos");
        System.out.println("2. Prikaz svih korisnika");
        System.out.println("3. Prikaz korisnika");
        System.out.println("4. Izmena korisnika");
        System.out.println("5. Brisanje korisnika");
        System.out.println("0. Izloguj me");
        System.out.print("Izabrana opcija: ");
    }

    @Override
    public void showInsertMenu() {

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
