package homeworks.hw6.steps.ex1;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import homeworks.enums.*;
import homeworks.hw6.pages.GherkinHomePage;
import homeworks.hw6.ex1.ServicePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class AssertionSteps {


    private GherkinHomePage homePage = page(GherkinHomePage.class);
    private ServicePage differentElementsPage = page(ServicePage.class);

    @Then("^The browser title should be '([^\"]*)'$")
    public void checkTitle(PageData homePageTitle) {
        homePage.checkTitle(homePageTitle);
    }

    @Then("^User's name should be '([^\"]*)'$")
    public void checkUser(User user) {
        homePage.checkUserIsLoggined(user);
    }

    @And("^Interface should have all needed elements$")
    public void checkElements() {
        homePage.checkElementsExists();
    }

    @Then("^Service dropdown menu in header displays following options$")
    public void checkHeaderService(List<SubData> options) {
        homePage.checkHeaderService(options);
    }

    @Then("^Service dropdown in left section displays following options$")
    public void checkLeftService(List<SubData> options) {
        homePage.checkLeftService(options);
    }

    @Then("^Different Elements page contains all elements needed$")
    public void checkDifferentElements() {
        differentElementsPage.checkCheckboxesRadios();
    }

    @And("^I see the Right section$")
    public void checkRightSection() {
        differentElementsPage.checkRightSection();
    }

    @And("^I see the Left section$")
    public void checkLeftSection() {
        differentElementsPage.checkLeftSection();
    }

    @Then("^Checkboxes '([^\"]*)' and '([^\"]*)' is correct on log$")
    public void checkTrueWaterInLog(NatureElements firstNature, NatureElements secondNature) {
        differentElementsPage.checkCheckboxInLog(firstNature, true);
        differentElementsPage.checkCheckboxInLog(secondNature, true);
    }

    @Then("^Radio button '([^\"]*)' is correct on log$")
    public void checkRadioInLog(Metals metal) {
        differentElementsPage.checkRadioInLog(metal);
    }

    @Then("^Color '([^\"]*)' is correct on log$")
    public void checkColorOnLog(Colors color) {
        differentElementsPage.checkSelectedColor(color);
    }

    @Then("^Check checkboxes '([^\"]*)' and '([^\"]*)' is unchecked$")
    public void checkFalseWaterInLog(NatureElements firstNature, NatureElements secondNature) {
        differentElementsPage.checkCheckboxInLog(firstNature, false);
        differentElementsPage.checkCheckboxInLog(secondNature, false);
    }

}
