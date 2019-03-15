package homeworks.enums;

public enum PageData {
    // TODO The name of enums should be selected with reference to it purpose.
    WEB_ADDR("https://epam.github.io/JDI/index.html"),
    PAGE_NAME("Home Page"),
    DATES_TITLE("Dates"),

    TEXT_CENTER("EPAM FRAMEWORK WISHES…"),
    TEXT_MAIN_TITLE(
            "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
                    "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
                    "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                    "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    TEXT_ONE ("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project"),
    TEXT_TWO("To be flexible and\n" +
            "customizable"),
    TEXT_THREE ("To be multiplatform"),
    TEXT_FOUR ("Already have good base\n" +
            "(about 20 internal and\n" +
            "some external projects),\n" +
            "wish to get more…");

    private String value;

    PageData(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
