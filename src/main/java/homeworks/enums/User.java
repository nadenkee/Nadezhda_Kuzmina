package homeworks.enums;

public enum User {

    PITER("epam", "1234");

    public final String login;
    public final String password;
    public final String username = "PITER CHAILOVSKII";

    User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}