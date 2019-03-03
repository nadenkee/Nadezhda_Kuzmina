package homeworks.hw6.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.enums.PageData;
import homeworks.enums.User;
import homeworks.enums.SubData;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class GherkinHomePage {
    @FindBy(css = "[id='user-icon']")
    private SelenideElement loginIcon;

    @FindBy(css = "[id='name']")
    private SelenideElement userField;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordField;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    @FindBy(css = "[id='user-name']")
    private SelenideElement userName;

    @FindBy(css = "[class='benefit-icon']")
    private ElementsCollection pictures;

    @FindBy(css = "[class='benefit-txt']")
    private ElementsCollection picturesTexts;

    @FindBy(css = "[class='main-title text-center']")
    private SelenideElement headlineText;

    @FindBy(css = "[class='main-txt text-center']")
    private SelenideElement descriptionText;

    @FindBy(css = "[class='menu-title']")
    private ElementsCollection serviceOnLeftSection;

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 li.dropdown")
    private SelenideElement serviceOnHeader;

    @FindBy(css = "[class='dropdown-menu'] li")
    private ElementsCollection dropDownService;

    @FindBy(css = "[class='sub'] li")
    private ElementsCollection dropDownServiceLeft;

    public void login(User user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }

    public void checkTitle(PageData homePageTitle) {
        assertEquals(getWebDriver().getTitle(), homePageTitle.toString());
    }

    public void checkUserIsLoggined(User user) {
        userName.shouldHave(visible, text(user.login));
    }

    public void checkElementsExists() {
        pictures.shouldHave(CollectionCondition.size(4));
        for (SelenideElement picture : pictures) {
            picture.should(visible);
        }
        picturesTexts.shouldHave(CollectionCondition.size(4));
        for (SelenideElement pictureText : picturesTexts) {
            pictureText.should(visible);
        }
        headlineText.should(visible);
        descriptionText.should(visible);
    }

    public void clickHeaderService() {
        serviceOnHeader.click();
    }

    public void checkHeaderService(List<SubData> options) {
        dropDownService.shouldHaveSize(options.size());
        List<String> expectedTexts = options.stream().map(SubData::toString).collect(Collectors.toList());
        dropDownService.shouldHave(texts(expectedTexts));
    }

    public void clickLeftService() {
        serviceOnLeftSection.get(0).click();
    }

    public void checkLeftService(List<SubData> options) {
        dropDownServiceLeft.shouldHaveSize(options.size());
        List<String> expectedTexts = options.stream().map(SubData::toString).collect(Collectors.toList());
        dropDownServiceLeft.shouldHave(texts(expectedTexts));
    }

    public void openDifferentElements() {
        dropDownService.get(6).click();
    }

    public void openUserTable() {
        dropDownService.get(4).click();
    }
}
