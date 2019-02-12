package lessons.lesson6.steps;


//All those steps with THEN annotation


import base.SelenideIndexPage;
import cucumber.api.java.en.Then;

import java.util.concurrent.locks.Condition;

import static com.codeborne.selenide.Condition.text;

public class AssertionSteps {
    @Then("^User name should be 'PITER CHAILOVSKII'$")
    public void userNameShouldBe(String expected) {
           new SelenideIndexPage().getUserName().shouldBe(text(expected));
    }
}
