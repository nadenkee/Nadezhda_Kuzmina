package homeworks.hw7;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import homeworks.hw7.entities.MetalsAndColors;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static base.jdi.entities.User.PETER;
import static homeworks.hw7.NavigationPageJDI.homePage;
import static homeworks.hw7.NavigationPageJDI.metalsColorsPage;

public class MetalsColorsJDI {
    public MetalsAndColors result;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initElements(NavigationPageJDI.class);
    }

    @Test
    public void simpleJdiTest() {
        homePage.open();
        //Login on JDI site as User
        homePage.login(PETER);
        //Open Metals & Colors page by Header menu
        homePage.clickMetalsAndColors();
        //Fill form Metals & Colors by data below
        metalsColorsPage.fillForm(MetalsAndColors.TEST_ENTITY);
        //Submit form Metals & Colors
        metalsColorsPage.subForm();
        //Result Section contains correct data
        metalsColorsPage.checkCorrectData(result);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }
}
