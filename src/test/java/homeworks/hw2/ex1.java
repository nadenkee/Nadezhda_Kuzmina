package homeworks.hw2;

/*

TASK

Exercise 1:
1.	Develop a dedicated test for asserting 4 texts below 4 pictures on the Index Page -https://epam.github.io/JDI/index.html. The test must be developed with help of the DataProvider. Run it in the parallel by methods through the configuring parameters in a @DataProvider annotation.



REQUIREMENT
File placement requirements:
      1. Homework must be performed in a new Java class
      2. Use the CamelCase style for class naming
      3. Test method should has a name in accordance with checking functionality
      4. Class must be placed into src/test/java/hw2 package
      5. Each Exercise must be placed to dedicated package src/test/java/hw2/ex1, etc.
      6. When you are ready and have pushed your homework task, please ping me in Skype personally

 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;


public class ex1 {

    @BeforeClass
    public void BeforeClass() {
        setProperty ("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @DataProvider
    public Object [][] correctData () {
        String firstText = "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project";
        String secondText = "To be flexible and\n" +
                "customizable";
        String thirdText = "To be multiplatform";
        String forthText = "Already have good base\\n\" +\n" +
                "                \"(about 20 internal and\\n\" +\n" +
                "                \"some external projects),\\n\" +\n" +
                "                \"wish to get more…";
        String xPathOne = "/html/body/div/div[2]/main/div[2]/div/div[1]/div/span";
        String xPathTwo = "/html/body/div/div[2]/main/div[2]/div/div[2]/div/span";
        String xPathThree = "/html/body/div/div[2]/main/div[2]/div/div[3]/div/span";
        String xPathFour = "/html/body/div/div[2]/main/div[2]/div/div[4]/div/span";

        return new Object[][]{{xPathOne, firstText}, {xPathTwo, secondText}, {xPathThree, thirdText}, {xPathFour, forthText}};
    }

    @Test(dataProvider ="correctData")
    public void SimpleTest (String path, String text)
    {
        String WEBADDR = "https://epam.github.io/JDI/index.html";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //развернули окно браузера максимально
        driver.navigate().to(WEBADDR);
        assertEquals(driver.findElement(By.xpath(path)).getText(), text);
    }
}




