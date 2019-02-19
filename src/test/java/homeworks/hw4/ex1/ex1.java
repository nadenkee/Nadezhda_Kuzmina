package homeworks.hw4.ex1;

import base.SelenideBase;
import base.hw4.ServicePage;
import base.hw4.SupportPage;
import homeworks.enums.User;
import com.codeborne.selenide.Selenide;
import homeworks.enums.SubData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static homeworks.enums.NatureElements.*;
import static homeworks.enums.Colors.*;
import static homeworks.enums.Metals.*;
import static homeworks.enums.PageData.*;

public class ex1 extends SelenideBase {

        private ServicePage servicePage;
        private SupportPage supportPage;

        @BeforeMethod
        public void beforeMethod() {
            //1 Open test site by URL
            Selenide.open(WEB_ADDR.toString());
            servicePage = page(ServicePage.class);
            supportPage = page(SupportPage.class);
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

            //5 Click on "Service" subcategory in the header and check that drop down contains options
            servicePage.checkHeaderService(SubData.values());

            //6 Click on Service subcategory in the left section and check that drop down contains options
            servicePage.checkLeftService(SubData.values());

            //7 Open through the header menu Service -> Different Elements Page
            servicePage.openPageHeaderMenu(SubData.DIFFERENT);

            // 8 Check interface on Different elements page, it contains all needed elements
            supportPage.checkCheckboxesAndRadios(4, 4);

            // 9 Assert that there is Right Section
            supportPage.checkRightSection();

            // 10 Assert that there is Left Section
            supportPage.checkLeftSection();

            // 11 Select checkboxes
            supportPage.clickNatureElements(WATER);
            supportPage.clickNatureElements(WIND);

            // 12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
            supportPage.checkCheckboxInLog(WATER, true);
            supportPage.checkCheckboxInLog(WIND, true);

            // 13 Select radio
            supportPage.selectRadio(GOLD);

            // 14 Assert that for radiobutton there is a log row and value is corresponded to the status of
            supportPage.checkRadioInLog(GOLD);

            // 15 Select in dropdown
            supportPage.selectDropdown(YELLOW);

            // 16 Assert that for dropdown there is a log row and value is corresponded to the selected value.
            supportPage.checkSelectedColor(YELLOW);

            //17 Unselecte checkboxes
            supportPage.clickNatureElements(WATER);
            supportPage.clickNatureElements(WIND);

            //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
            supportPage.checkCheckboxInLog(WATER, false);
            supportPage.checkCheckboxInLog(WIND, false);
        }
}
