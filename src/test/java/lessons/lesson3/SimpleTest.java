package lessons.lesson3;

import homeworks.hw6.pages.IndexPage;
import base.lesson6.po.SeleniumBase;
import homeworks.enums.User;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleTest extends SeleniumBase {
    private IndexPage indexPage;
    private WebDriver driver;


    @BeforeMethod
    public void initTest () {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // лучшее, что можно сделать при тестировании, комфорта ради
        indexPage = new IndexPage(driver);
        indexPage = PageFactory.initElements(driver, IndexPage.class);


    }

    @Test
    public void SimmpleTest () {
        indexPage.open();
        indexPage.login(User.PITER);

    }


}
