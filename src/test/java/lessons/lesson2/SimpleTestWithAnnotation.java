package lessons.lesson2;

import base.lesson6.po.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SimpleTestWithAnnotation extends SeleniumBase {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }
    @AfterMethod
    public void afterMethod () {
        driver.close();
    }

    @Test (invocationCount = 3) //threadPoolSize = 3)
        public void simpleTest () {

        //1

        WebDriver driver = new ChromeDriver(); //импортим два класса, которые предлагает идея
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2
        driver.manage().window().maximize(); //развернули окно браузера максимально
        String handle = driver.getWindowHandle(); //получаем ID нулевой вкладки , если хотим Linked Hash Set со ВСЕМИ вкладками - то добавляем в конце s
        driver.switchTo().frame(handle);

        //3
        assertEquals(driver.getTitle(), "Home Page");

        //4


        // работаем с контентом, By - класс в селениуме
        driver.findElement(By.cssSelector("id='user-icon'")).click();
        driver.findElement(By.cssSelector("id='name'")).sendKeys("epam");
        driver.findElement(By.cssSelector("id='password'")).sendKeys("1234");
        driver.findElement(By.cssSelector("id='login-button'")).click();

        //5

        driver.close();
    }

}

/* 2 лекция. СЕлениум - это инструмент для автоматизации, ЭТО ПРОСТО НАБОР КЛАССОВ */


