package homeworks.enums;

public enum Vegs {
    TOMATO("Tomato"),
    ONION("Onion"),
    VEGETABLES("Vegetables"),
    CUCUMBER("Cucumber");
    private String value;

    Vegs(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
