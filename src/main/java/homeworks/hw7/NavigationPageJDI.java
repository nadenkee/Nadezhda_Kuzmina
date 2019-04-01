package homeworks.hw7;

import base.jdi.pages.IndexPageJdi;
import base.jdi.pages.MetalsColorsPage;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://epam.github.io/JDI")
public class NavigationPageJDI {

    @Url("/index.html")
    @Title("Home Page")
    public static IndexPageJdi homePage;

    @Url("/metals-colors.html")
    @Title("Metals and Colors")
    public static MetalsColorsPage metalsColorsPage;

}
