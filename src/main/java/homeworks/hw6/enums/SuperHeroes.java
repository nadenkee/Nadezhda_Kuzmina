package homeworks.hw6.enums;

public enum SuperHeroes {
    ROMAN("Roman", "roman"),
    IVAN("Sergey Ivan", "ivan"),
    VLAD("Vladzimir", "vlad"),
    HELEN("Helen Bennett", "helen"),
    YOSHI("Yoshi Tannamuri", "yoshi"),
    GIO("Giovanni Rovelli", "gio");

    public String name;
    public String id;

    SuperHeroes(String name, String id) {
        this.id = id;
        this.name = name;
    }

    public static SuperHeroes getUsersTable(String value) {
        for (SuperHeroes line : SuperHeroes.values()) {
            if (line.name.equals(value))
                return line;
        }
        return null;
    }
}
