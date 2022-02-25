import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int tries;
        String currentUsername;
        boolean isWrongPassword;

        System.out.println("Dobrodosli u nas program.");

        while(true) {
            tries = 0;
            isWrongPassword = false;
            System.out.print("Molimo Vas unesite Vaš username: ");
            currentUsername = input.nextLine();
            if (currentUsername.equals("<admin_user_name>")) {
                do {
                    System.out.print("Unesite admin lozinku: ");
                    String inputPassword = input.nextLine();
                    if(inputPassword.equals("<admin_password>")) isWrongPassword = false;
                    else tries++;
                } while (tries < 4 && isWrongPassword);
                if(tries == 4) throw new Exception("Wrong password entered 4 times, program terminated");
                System.out.println("Izaberite željenu opciju:");
                System.out.println("1. Unos");
                System.out.println("2. Prikaz svih korisnika");
                System.out.println("3. Prikaz korisnika");
                System.out.println("4. Izmena korisnika");
                System.out.println("5. Brisanje korisnika");
                System.out.println("0. Izloguj me");
                System.out.print("Izabrana opcija: ");
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
}
