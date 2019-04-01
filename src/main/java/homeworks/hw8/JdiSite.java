package homeworks.hw8;

import base.jdi.pages.IndexPageJdi;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import homeworks.hw8.pages.MetalsColorsJSONPage;

@JSite("https://epam.github.io/JDI")
public class JdiSite {

    @Url("/index.html")
    @Title("Home Page")
    public static IndexPageJdi homePage;

    @Url("/metals-colors.html")
    @Title("Metals and Colors")
    public static MetalsColorsJSONPage metalsColorsPage;

}

