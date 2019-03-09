package lessons.lesson6.steps;


//All those steps with THEN annotation


import homeworks.hw6.pages.SelenideIndexPage;
import cucumber.api.java.en.Then;

import static com.codeborne.selenide.Condition.text;

public class AssertionSteps {
    @Then("^User name should be 'PITER CHAILOVSKII'$")
    public void userNameShouldBe(String expected) {
           new SelenideIndexPage().getUserName().shouldBe(text(expected));
    }

    @Then("^User name should be as for user '([^\"]*)'$")
    public void userNameShouldBeAsForUser() {

    }
}

