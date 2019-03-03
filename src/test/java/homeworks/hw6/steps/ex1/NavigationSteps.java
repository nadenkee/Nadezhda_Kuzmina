package homeworks.hw6.steps.ex1;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class NavigationSteps {

    private static final String INDEX_PAGE_URL = "";

    @Given("^I am on Home Page$")
    public void iAmOnHomePage() {
        Selenide.open(INDEX_PAGE_URL);
        getWebDriver().manage().window().maximize();
    }
}
