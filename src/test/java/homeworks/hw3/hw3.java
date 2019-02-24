package homeworks.hw3;

import base.lesson6.po.SeleniumBase;
import homeworks.enums.User;
import base.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static homeworks.enums.PageData.*;
import static java.lang.System.setProperty;

public class hw3 extends SeleniumBase {

    private WebDriver driver;
    private IndexPage indexPage;
    public final static String NAME = "epam";
    public final static String PASSWORD = "1234";

    @BeforeMethod
    public void BeforeMethod() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @AfterMethod
    public void AfterMethod() {
        driver.quit();
    }

    @Test
    public void SimpleTest () {

        //1 Open test site by URL
        indexPage.open();

        //2 Assert Browser title
        indexPage.checkTitle(PAGE_NAME);

        //3 Perform login
        indexPage.login(User.PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkLoginned(User.PITER);

        //5 Assert Browser title
        indexPage.checkTitle(PAGE_NAME);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        indexPage.assertFourTexts();

        //7 Assert that there are 4 images on the Index Page and they are displayed	4 images
        indexPage.assertFourImages();

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        indexPage.assertTextsWords();

        //9 Assert a text of the main headers
        indexPage.assertTextHeaders();

        //10 Assert that there is the iframe in the center of page
        indexPage.assertFrame();

        //11 Switch to the iframe and check Epam logo is in the left top conner of iframe
        indexPage.switchFrameEPAMLogo();

        //12 Switch to original window back
        indexPage.switchDef();

        //13 Assert a text of the sub header
        indexPage.assertSubHeader();

        //14 Assert that JDI GITHUB is a link and has a proper URL
        indexPage.assertProperURL(WEB_ADDR);

        //15 Assert that there is Left Section
        indexPage.assertByXPath();

        //16 Assert that there is Footer
        indexPage.assertByCSS();

        //17  Close Browser
        indexPage.close();
    }
}