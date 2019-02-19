package jdi.lesson1;

import base.jdi.lesson1.JDISite;
import base.jdi.lesson1.pages.IndexPageJdi;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;

public class JdiSimpleExample {

    @BeforeSuite
    public void beforeSuite () {
        PageFactory.initElements(JDISite.class);
    }
    @Test
    public void simpleJdiTest () {
        JDISite.indexPageJdi.open();
        JDISite.indexPageJdi.login("epam", "1234");
    }
    @AfterSuite
    public void afterSuite () {
        //JDISite.indexPageJdi.driver().close();
        WebDriverFactory.close();
    }
}
