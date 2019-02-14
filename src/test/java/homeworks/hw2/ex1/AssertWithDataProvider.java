package homeworks.hw2.ex1;

/*

TASK

Exercise 1:
1.	Develop a dedicated test for asserting 4 texts below 4 pictures on the Index Page
 -https://epam.github.io/JDI/index.html. The test must be developed with help of the DataProvider.
 Run it in the parallel by methods through the configuring parameters in a @DataProvider annotation.



 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;


public class AssertWithDataProvider {

    String WEBADDR = "https://epam.github.io/JDI/index.html";
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void BeforeClass() {
        setProperty ("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @DataProvider(parallel = true)
    public Object [][] correctData () {
        String firstText = "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project";
        String secondText = "To be flexible and\n" +
                "customizable";
        String thirdText = "To be multiplatform";
        String forthText = "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…";
        String xPathOne = "/html/body/div/div[2]/main/div[2]/div/div[1]/div/span";
        String xPathTwo = "/html/body/div/div[2]/main/div[2]/div/div[2]/div/span";
        String xPathThree = "/html/body/div/div[2]/main/div[2]/div/div[3]/div/span";
        String xPathFour = "/html/body/div/div[2]/main/div[2]/div/div[4]/div/span";

        return new Object[][]{{xPathOne, firstText}, {xPathTwo, secondText}, {xPathThree, thirdText}, {xPathFour, forthText}};
    }

    @Test(dataProvider ="correctData")
    public void SimpleTest (String path, String text)
    {
        driver.navigate().to(WEBADDR);
        driver.manage().window().maximize(); //развернули окно браузера максимально
        assertEquals(driver.findElement(By.xpath(path)).getText(), text);
    }

    @AfterSuite
    public void afterSuite () {
        driver.quit();
    }
}




