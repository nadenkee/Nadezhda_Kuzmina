package homeworks.hw4.ex2;

import base.hw4.ServicePage;
import homeworks.enums.User;
import com.codeborne.selenide.Selenide;
import homeworks.enums.PageData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.hw4.SliderPage;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static homeworks.enums.PageData.PAGE_NAME;
import static homeworks.enums.PageData.WEB_ADDR;

public class ex2 {
    private ServicePage servicePage;
    private SliderPage sliderPage;

    @BeforeMethod
    public void beforeMethod() {
        //1 Open test site by URL
        Selenide.open(WEB_ADDR.toString());
        servicePage = page(ServicePage.class);
        sliderPage = page(SliderPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Test
    public void tests() {

        //2 Assert Browser title
        servicePage.checkTitle(PAGE_NAME);

        //3 Perform login
        servicePage.login(User.PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        servicePage.checkUserIsLogged(User.PITER);

        //5 Open through the header menu Service -> Dates Page
        servicePage.openHeaderDates(PageData.DATES_TITLE);

        //6 set left slider on 0 and right slider on 100
        sliderPage.moveSlidersBoundaryPosition(0, 100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        sliderPage.checkFromAndToInLogs(0, 100);

        //8 set left slider on 0 and right slider on 0
        sliderPage.moveSlidersBoundaryPosition(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        sliderPage.checkFromAndToInLogs(0, 0);

        //10 set left slider on 100 and right slider on 100
        sliderPage.moveSlidersBoundaryPosition(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        sliderPage.checkFromAndToInLogs(100, 100);

        //12 set left slider on 30 and right slider on 70
        sliderPage.moveSlidersBoundaryPosition(30, 70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        sliderPage.checkFromAndToInLogs(30, 70);

    }
}

