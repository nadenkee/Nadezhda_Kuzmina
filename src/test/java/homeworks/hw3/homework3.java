package homeworks.hw3;

import base.SeleniumBase;
import homeworks.enums.User;
import lessons.lesson3.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static homeworks.enums.PageData.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
/*
TASK
1.	All previous preconditions are still actual
2.	Place your homework files to the corresponding paths either in src\main, or src\test.
Exercise 1:
1.	Copy your HW1 test to the proper package
2.	Refactor this test in Page Object design pattern.
1.	Refactor all locators on short and relative. There is no place for full absolute XPath auto–generated locators.
2.	Use CSS in each case when it possible otherwise use XPATH (axes and search by text())
3.	Try to manage correctly the place where you will create a driver instance and where you create an object of your page.
4.	All actions have to be incapsulated into a Page Object.
5.	Parametrize exact methods which you decide should be parametrized.
 */
public class homework3 extends SeleniumBase {

    private WebDriver driver;
    private IndexPage indexPage;
    public final static String NAME = "epam";
    public final static String PASSWORD = "1234";

    @BeforeMethod
    public void BeforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @AfterMethod
    public void AfterMethod() {
        driver.close();
    }

    @Test
    public void SimpleTest () {

        //1 Open test site by URL
        indexPage.open();

        //2 Assert Browser title
        indexPage.checkTitle(PAGE_NAME);

        //3 Perform login
        indexPage.login(NAME, PASSWORD);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkLoginned(User.PITER);

        //5 Assert Browser title
        indexPage.checkTitle(PAGE_NAME);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        indexPage.assertFourTexts();

        //7 Assert that there are 4 images on the Index Page and they are displayed	4 images
        indexPage.assertFourImages();

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        indexPage.assertTextsWords(1, TEXT_ONE);
        indexPage.assertTextsWords(2, TEXT_TWO);
        indexPage.assertTextsWords(3, TEXT_THREE);
        indexPage.assertTextsWords(4, TEXT_FOUR);

        //9 Assert a text of the main headers
        indexPage.assertTextHeaders("[class='main-title text-center']", TEXT_CENTER);
        indexPage.assertTextHeaders("[class='main-txt text-center']", TEXT_MAIN_TITLE);

        //10 Assert that there is the iframe in the center of page
        indexPage.assertFrame("iframe");

        //11 Switch to the iframe and check Epam logo is in the left top conner of iframe
        indexPage.switchFrameEPAMLogo("iframe", "epam-logo");

        //12 Switch to original window back
        indexPage.switchDef();

        //13 Assert a text of the sub header
        indexPage.assertSubHeader("JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        indexPage.assertProperURL("JDI GITHUB", WEB_ADDR, "footer-bg");

        //15 Assert that there is Left Section
        indexPage.assertByXPath("//*[@id=\"mCSB_1\"]");

        //16 Assert that there is Footer
        indexPage.assertByCSS("[class='footer-bg']");

        //17  Close Browser
        indexPage.close();
    }
}