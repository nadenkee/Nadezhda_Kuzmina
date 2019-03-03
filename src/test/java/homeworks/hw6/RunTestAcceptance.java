package homeworks.hw6;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.close;

@CucumberOptions(
        features = {"src/test/java/resources/hw6/DifferentElementsTest", "src/test/java/resources/hw6/UserTablePageTest"},
        glue = {"classpath:homeworks.hw6.steps.ex1", "classpath:homeworks.hw6.steps.ex2"}
)

public class RunTestAcceptance extends AbstractTestNGCucumberTests {
    @BeforeSuite()
    public void driverSetUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
    }

    @AfterMethod
    public void closeBrowser() {
        close();
    }
}

