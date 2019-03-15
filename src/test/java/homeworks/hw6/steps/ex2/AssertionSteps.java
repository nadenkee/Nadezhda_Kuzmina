package homeworks.hw6.steps.ex2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import homeworks.enums.UserTablePageInfo;
import homeworks.hw6.entities.SuperHero;
import homeworks.hw6.ex2.UserTablePage;
import homeworks.hw6.pages.GherkinHomePage;
import homeworks.hw6.pages.SelenideIndexPage;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class AssertionSteps {
    @Then("^User name should be 'PITER CHAILOVSKII'$")
    public void userNameShouldBe(String expected) {
        new SelenideIndexPage().getUserName().shouldBe(text(expected));
    }

    private GherkinHomePage homePage = page(GherkinHomePage.class);
    private UserTablePage userTablePage = page(UserTablePage.class);

    @Then("^'([^\"]*)' page is opened$")
    public void userTablePageIsOpened(UserTablePageInfo title) {
        userTablePage.checkTitle(title);
    }

    @And("^'([^\"]*)' NumberType Dropdowns are displayed on User Table Page$")
    public void checkDropdown(int number) {
        userTablePage.checkTypeDropdown(number);
    }

    @And("^'([^\"]*)' User names are displayed on Users Table on User Table Page$")
    public void checkUserNames(int number) {
        userTablePage.checkUserNames(number);
    }

    @And("^'([^\"]*)' Description images are displayed on Users Table on User Table Page$")
    public void checkImages(int number) {
        userTablePage.checkImages(number);
    }

    @And("^'([^\"]*)' Description texts under images are displayed on Users Table on User Table Page")
    public void checkDescriptionTexts(int number) {
        userTablePage.checkDescriptionTexts(number);
    }

    @And("^'([^\"]*)' checkboxes are displayed on Users Table on User Table Page$")
    public void checkCheckboxes(int number) {
        userTablePage.checkCheckboxes(number);
    }

    @And("^User table contains following values:$")
    public void check(List<SuperHero> superHeroes) {
        userTablePage.checkTableElements(superHeroes);
    }

    @Then("^I check condition in log section changed to '([^\"]*)'$")
    public void checkVipOnLog(boolean isOn) {
        userTablePage.checkVipOnLog(isOn);
    }

    @Then("^Droplist contains values:$")
    public void checkDroplist(List<String> values) {
        userTablePage.checkDroplistValues(values);
    }
}