package base.lesson6.po;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;



public abstract  class SeleniumBase {

    @BeforeSuite
    public void beforeSuite () {
        setProperty ("WebDriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

}
