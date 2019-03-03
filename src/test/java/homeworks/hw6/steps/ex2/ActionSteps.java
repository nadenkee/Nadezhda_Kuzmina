package homeworks.hw6.steps.ex2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import homeworks.enums.SubData;
import homeworks.hw6.pages.SelenideIndexPage;
import homeworks.enums.User;
import homeworks.hw6.pages.GherkinHomePage;
import homeworks.hw6.ex2.UserTablePage;
import homeworks.hw6.enums.SuperHeroes;

import static com.codeborne.selenide.Selenide.page;
import static homeworks.enums.SubData.USER_TABLE;

public class ActionSteps {

    private GherkinHomePage homePage = page(GherkinHomePage.class);
    private UserTablePage userTablePage = page(UserTablePage.class);

    @When("^I login as user '([^\"]*)'$")
    public void iLoginAsUser(User user) {
        new SelenideIndexPage().login(user);
    }

    @When("^I click on Service button in Header$")
    public void iClickOnServiceButtonInHeader() {
        homePage.clickHeaderService();
    }

    @And("^I click on User Table button in Service dropdown$")
    public void iClickOnUserTableButtonInServiceDropdown() {

    }

    @When("^I click on Service button in Header$")
    public void clickHeaderService() {
        homePage.clickHeaderService();
    }

    @And("^I click on User Table button in Service dropdown$")
    public void openUserTable() {
        homePage.openUserTable();
    }

    @When("^I select Vip checkbox for '([^\"]*)'$")
    public void selectVip(SuperHeroes user) {
        userTablePage.clickVip(user);
    }

    @When("^I click on dropdown in column Type for user '([^\"]*)'$")
    public void clickDropdown(SuperHeroes user) {
        userTablePage.clickOnDropdown(user);
    }
}