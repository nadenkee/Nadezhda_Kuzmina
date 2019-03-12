package homeworks.enums;

public enum ColorsMetalsData {
    SUMMARY("11"),
    ELEMENTS("Elements: Water, Fire"),
    COLORS("Red"),
    METALS("Selen"),
    VEGS("Vegetables: Cucumber, Tomato");

    private String value;

    ColorsMetalsData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}


