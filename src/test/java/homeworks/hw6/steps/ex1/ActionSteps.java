package homeworks.hw6.steps.ex1;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import homeworks.enums.User;
import homeworks.enums.Colors;
import homeworks.enums.Metals;
import homeworks.enums.NatureElements;
import homeworks.hw6.pages.GherkinHomePage;
import homeworks.hw6.ex1.ServicePage;

import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {

    private GherkinHomePage homePage = page(GherkinHomePage.class);
    private ServicePage differentElementsPage = page(ServicePage.class);

    @And("^I login as user '([^\"]*)'$")
    public void login(User user) {
        homePage.login(user);
    }

    @When("^I click on Service subcategory in the header$")
    public void clickHeaderService() {
        homePage.clickHeaderService();
    }

    @When("^I click on Service subcategory in the left section$")
    public void clickLeftService() {
        homePage.clickLeftService();
    }

    @When("^I open menu '([^\"]*)' from header$")
    public void openDifferentElementsPage() {
        homePage.openDifferentElements();
    }

    @When("^I click checkboxes '([^\"]*)' and '([^\"]*)'$")
    public void selectCheckboxWater(NatureElements firstNature, NatureElements secondNature) {
        differentElementsPage.clickNatureElements(firstNature);
        differentElementsPage.clickNatureElements(secondNature);
    }

    @When("^I select radio button:'([^\"]*)'$")
    public void selectRadio(Metals metal) {
        differentElementsPage.selectRadio(metal);
    }

    @When("^I select '([^\"]*)' from the color selection dropdown$")
    public void selectColor(Colors color) {
        differentElementsPage.selectDropdown(color);
    }

    @When("^I unselect checkboxes '([^\"]*)'$")
    public void unselectCheckboxWater(NatureElements water) {
        differentElementsPage.clickNatureElements(water);
    }

    @And("^I unselect checkbox '([^\"]*)'$")
    public void unselectCheckboxWind(NatureElements wind) {
        differentElementsPage.clickNatureElements(wind);
    }

}