package homeworks.enums;

public enum ColorsMetalsData {
    SUMMARY("Summary: 11"),
    ELEMENTS("Elements: Water, Fire"),
    COLORS("Color: Red"),
    METALS("Metal: Selen"),
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


