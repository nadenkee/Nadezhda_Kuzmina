package homeworks.hw2.ex2;

// TASK

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/*
Exercise 2:
        1.	Create 3 copies of the HW1 test in a new class.
        2.	Include all these tests to the group “Smoke”
        3.	Create 3 copies of the HW1 test in a next class.
        4.	Include all these tests to the group “Regression”
        5.	Create 3 copies of the HW1 test in a next class.
        6.	Include 2 of them to the group “Regression” another one to the group “Smoke”
        7.	Create 3 copies of the HW1 test in a next class.
        8.	Include all these tests to the groups “Regression” and “Smoke” simultaneously
        9.	Create two TestNg config files, the first one runs all “Smoke” test, the second runs “Regression”.
        Run both of configs must be in parallel by methods mode and with 3 threads.

*/
public class SmokeTests {

    @Test(groups = {"smoke"})
    public void SmokeTestsOne() {
        //0 Preparations
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        String NAME = "PITER CHAILOVSKII";
        String WEBADDR = "https://epam.github.io/JDI/index.html";
        String PageName = "Home Page";
        String textCenter = "EPAM FRAMEWORK WISHES…";
        String textMainTitle = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

        //1 Open test site by URL
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //развернули окно браузера максимально
        driver.navigate().to(WEBADDR);

        //2 Assert Browser title
        assertEquals(driver.getTitle(), PageName);

        //3 Perform login
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        assertTrue(driver.findElement(By.cssSelector("[id='user-name']")).isDisplayed());
        assertEquals(driver.findElement(By.id("user-name")).getText(), NAME);

        //5 Assert Browser title
        assertEquals(driver.getTitle(), PageName);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        assertEquals(driver.findElement(By.linkText("HOME")).getText(), "HOME");
        assertEquals(driver.findElement(By.linkText("CONTACT FORM")).getText(), "CONTACT FORM");
        assertEquals(driver.findElement(By.linkText("SERVICE")).getText(), "SERVICE");
        assertEquals(driver.findElement(By.linkText("METALS & COLORS")).getText(), "METALS & COLORS");


        //7 Assert that there are 4 images on the Index Page and they are displayed	4 images
        assertTrue(driver.findElement(By.cssSelector("[class='icons-benefit icon-practise']")).isDisplayed());
        assertTrue(driver.findElement(By.className("benefit-icon")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("[class='icons-benefit icon-multi']")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("[class='icons-benefit icon-base']")).isDisplayed());


        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[1]/div/span")).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/div/span")).getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[3]/div/span")).getText(), "To be multiplatform");
        assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/div/span")).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main headers
        assertTrue(driver.findElement(By.cssSelector("[class='main-title text-center']")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("[class='main-title text-center']")).getText(), textCenter);

        assertTrue(driver.findElement(By.cssSelector("[class='main-txt text-center']")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("[class='main-txt text-center']")).getText(), textMainTitle);

        //10 Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.id("iframe")).isDisplayed());

        //11 Switch to the iframe and check Epam logo is in the left top conner of iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.className("epam-logo")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        assertTrue(driver.findElement(By.linkText("JDI GITHUB")).isDisplayed());

        //14 Assert that JDI GITHUB is a link and has a proper URL
        driver.findElement(By.linkText("JDI GITHUB")).click();
        assertEquals(driver.getCurrentUrl(), WEBADDR);
        driver.switchTo().parentFrame();
        assertTrue(driver.findElement(By.className("footer-bg")).isDisplayed());

        //17  Close Browser
        driver.quit();
    }

    @Test(groups = {"smoke"})
    public void SmokeTestsTwo() {
        //0 Preparations
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        String NAME = "PITER CHAILOVSKII";
        String WEBADDR = "https://epam.github.io/JDI/index.html";
        String PageName = "Home Page";
        String textCenter = "EPAM FRAMEWORK WISHES…";
        String textMainTitle = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

        //1 Open test site by URL
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //развернули окно браузера максимально
        driver.navigate().to(WEBADDR);

        //2 Assert Browser title
        assertEquals(driver.getTitle(), PageName);

        //3 Perform login
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        assertTrue(driver.findElement(By.cssSelector("[id='user-name']")).isDisplayed());
        assertEquals(driver.findElement(By.id("user-name")).getText(), NAME);

        //5 Assert Browser title
        assertEquals(driver.getTitle(), PageName);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        assertEquals(driver.findElement(By.linkText("HOME")).getText(), "HOME");
        assertEquals(driver.findElement(By.linkText("CONTACT FORM")).getText(), "CONTACT FORM");
        assertEquals(driver.findElement(By.linkText("SERVICE")).getText(), "SERVICE");
        assertEquals(driver.findElement(By.linkText("METALS & COLORS")).getText(), "METALS & COLORS");


        //7 Assert that there are 4 images on the Index Page and they are displayed	4 images
        assertTrue(driver.findElement(By.cssSelector("[class='icons-benefit icon-practise']")).isDisplayed());
        assertTrue(driver.findElement(By.className("benefit-icon")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("[class='icons-benefit icon-multi']")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("[class='icons-benefit icon-base']")).isDisplayed());


        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[1]/div/span")).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/div/span")).getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[3]/div/span")).getText(), "To be multiplatform");
        assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/div/span")).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main headers
        assertTrue(driver.findElement(By.cssSelector("[class='main-title text-center']")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("[class='main-title text-center']")).getText(), textCenter);

        assertTrue(driver.findElement(By.cssSelector("[class='main-txt text-center']")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("[class='main-txt text-center']")).getText(), textMainTitle);

        //10 Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.id("iframe")).isDisplayed());

        //11 Switch to the iframe and check Epam logo is in the left top conner of iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.className("epam-logo")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        assertTrue(driver.findElement(By.linkText("JDI GITHUB")).isDisplayed());

        //14 Assert that JDI GITHUB is a link and has a proper URL
        driver.findElement(By.linkText("JDI GITHUB")).click();
        assertEquals(driver.getCurrentUrl(), WEBADDR);
        driver.switchTo().parentFrame();
        assertTrue(driver.findElement(By.className("footer-bg")).isDisplayed());

        //17  Close Browser
        driver.quit();
    }

    @Test(groups = {"smoke"})
    public void SmokeTestsThree() {
        //0 Preparations
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        String NAME = "PITER CHAILOVSKII";
        String WEBADDR = "https://epam.github.io/JDI/index.html";
        String PageName = "Home Page";
        String textCenter = "EPAM FRAMEWORK WISHES…";
        String textMainTitle = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

        //1 Open test site by URL
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //развернули окно браузера максимально
        driver.navigate().to(WEBADDR);

        //2 Assert Browser title
        assertEquals(driver.getTitle(), PageName);

        //3 Perform login
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        assertTrue(driver.findElement(By.cssSelector("[id='user-name']")).isDisplayed());
        assertEquals(driver.findElement(By.id("user-name")).getText(), NAME);

        //5 Assert Browser title
        assertEquals(driver.getTitle(), PageName);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        assertEquals(driver.findElement(By.linkText("HOME")).getText(), "HOME");
        assertEquals(driver.findElement(By.linkText("CONTACT FORM")).getText(), "CONTACT FORM");
        assertEquals(driver.findElement(By.linkText("SERVICE")).getText(), "SERVICE");
        assertEquals(driver.findElement(By.linkText("METALS & COLORS")).getText(), "METALS & COLORS");


        //7 Assert that there are 4 images on the Index Page and they are displayed	4 images
        assertTrue(driver.findElement(By.cssSelector("[class='icons-benefit icon-practise']")).isDisplayed());
        assertTrue(driver.findElement(By.className("benefit-icon")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("[class='icons-benefit icon-multi']")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("[class='icons-benefit icon-base']")).isDisplayed());


        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[1]/div/span")).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[2]/div/span")).getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[3]/div/span")).getText(), "To be multiplatform");
        assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[4]/div/span")).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main headers
        assertTrue(driver.findElement(By.cssSelector("[class='main-title text-center']")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("[class='main-title text-center']")).getText(), textCenter);

        assertTrue(driver.findElement(By.cssSelector("[class='main-txt text-center']")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("[class='main-txt text-center']")).getText(), textMainTitle);

        //10 Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.id("iframe")).isDisplayed());

        //11 Switch to the iframe and check Epam logo is in the left top conner of iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.className("epam-logo")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        assertTrue(driver.findElement(By.linkText("JDI GITHUB")).isDisplayed());

        //14 Assert that JDI GITHUB is a link and has a proper URL
        driver.findElement(By.linkText("JDI GITHUB")).click();
        assertEquals(driver.getCurrentUrl(), WEBADDR);
        driver.switchTo().parentFrame();
        assertTrue(driver.findElement(By.className("footer-bg")).isDisplayed());

        //17  Close Browser
        driver.quit();
    }
}