package model;

public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Role role;

    public User(String firstName, String lastName, String username, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        try {
            this.setPassword(password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        if(passwordCheck(password))
            this.password = password;
        else{
            throw new Exception("Wrong format for password. Must start with a letter and contains at least one digit");
        }
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    private boolean passwordCheck(String password){
        int counter = 0;

        if(!Character.isLetter(password.charAt(0))) return false;

        for (int i = 1; i < password.length(); i++){
            if(Character.isDigit(password.charAt(i))) counter++;
        }

        return counter >= 1;
    }
}
