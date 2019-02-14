package lessons.lesson6.steps;

//import com.codeborne.selenide.Browsers;  //почему-то не импортится
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;


@CucumberOptions (
        features =  "classpath:lesson6",
        glue = "classpath:lesson6.steps"
)

public class RunAcceptanceIT extends AbstractTestNGCucumberTests {

    @BeforeSuite()
        public void driverSetUp()  {
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
    }
    }
