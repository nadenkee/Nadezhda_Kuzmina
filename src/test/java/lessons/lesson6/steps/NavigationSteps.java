package lessons.lesson6.steps;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NavigationSteps {

    private static final String INDEX_PAGE_URL = "";

    @Given("^I open EPAM JDI site$")
    public void iOpenEPAMJDISite() {
        Selenide.open(INDEX_PAGE_URL);
    }


}
