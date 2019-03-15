package base.jdi.entities;

public class User {
    public static User PETER = new User("epam", "1234", "PETER CHAVLOVSKY");

    String login;
    String password;
    String fullName;

    public User(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }
}