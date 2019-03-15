package homeworks.enums;

public enum NatureElements {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private String value;

    NatureElements(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}