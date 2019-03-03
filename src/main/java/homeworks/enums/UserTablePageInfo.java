package homeworks.enums;

public enum UserTablePageInfo {

    USER_TABLE("User Table");

    String title;

    @Override
    public String toString() {
        return title;
    }

    UserTablePageInfo(String title) {
        this.title = title;
    }
}
