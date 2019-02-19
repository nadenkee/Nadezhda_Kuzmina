package base.hw4;

import homeworks.enums.User;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import homeworks.enums.PageData;
import homeworks.enums.SubData;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.AssertJUnit.assertEquals;

public class ServicePage {

    @FindBy(css = "[id='user-name']")
    private SelenideElement userName;

    @FindBy(css = "[id='user-icon']")
    private SelenideElement loginIcon;

    @FindBy(css = "[id='name']")
    private SelenideElement userField;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordField;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 li.dropdown")
    private SelenideElement serviceOnHeader;

    @FindBy(css = "[class='dropdown-menu'] li")
    private ElementsCollection dropDownService;

    @FindBy(css = "[class='menu-title']")
    private ElementsCollection serviceOnLeftSection;

    @FindBy(css = "[class='sub'] li")
    private ElementsCollection dropDownServiceLeft;

    public void open(PageData url) {
        Selenide.open(url.toString());
    }

    public void checkTitle(PageData title) {
        assertEquals(getWebDriver().getTitle(), title.toString());
    }

    public void login(User user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }

    public void checkUserIsLogged(User user) {
        userName.shouldHave(visible, text(user.username));
    }

    public void checkHeaderService(SubData[] values) {
        serviceOnHeader.shouldHave(visible);
        serviceOnHeader.click();
        dropDownService.shouldHaveSize(values.length);
        List<String> expectedTexts = Arrays.stream(values).map(SubData::toString).collect(Collectors.toList());
        dropDownService.shouldHave(texts(expectedTexts));
        serviceOnHeader.click();
    }

    public void checkLeftService(SubData[] values) {
        serviceOnLeftSection.get(0).shouldHave(visible);
        serviceOnLeftSection.get(0).click();
        assertEquals(dropDownServiceLeft.size(), values.length);
        List<String> expectedTexts = Arrays.stream(values).map(SubData::toString).collect(Collectors.toList());
        dropDownServiceLeft.shouldHave(texts(expectedTexts));
        serviceOnHeader.click();
    }

    public void openPageHeaderMenu(SubData item) {
        dropDownService.find(text(item.toString())).click();
    }

    public void openHeaderDates(PageData title) {
        serviceOnHeader.click();
        dropDownService.get(1).click();
        assertEquals(getWebDriver().getTitle(), title.toString());
    }
}
