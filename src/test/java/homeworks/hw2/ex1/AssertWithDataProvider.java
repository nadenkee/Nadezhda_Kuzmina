package homeworks.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;


public class AssertWithDataProvider {
    WebDriver driver;
    String WEB_ADDR = "https://epam.github.io/JDI/index.html";

    @BeforeSuite
    public void BeforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeClass
    public void BeforeClass() {
        driver = new ChromeDriver();
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

        return new Object[][]{
                {1, firstText},
                {2, secondText},
                {3, thirdText},
                {4, forthText}};
    }

    @Test(dataProvider ="correctData")
    public void SimpleTest (int index, String text) {
        driver.navigate().to(WEB_ADDR);
        driver.manage().window().maximize();
        assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div["+index+"]/div/span")).getText(), text);
    }

    @AfterSuite
    public void afterSuite () {
        driver.quit();
    }
}




