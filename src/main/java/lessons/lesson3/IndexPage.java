package lessons.lesson3;


import homeworks.enums.User;
import homeworks.enums.PageData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

// TODO All homework stuff should be in appropriate package
// TODO This is completely prohibited to find elements in PO methods
// TODO You should not hard-code data in PO methods
public class IndexPage {

    @FindBy(css = "[id='user-icon']")
    private WebElement loginIcon;

    @FindBy(css = "[id='name']")
    private WebElement userField;

    @FindBy(css = "[id='password']")
    private WebElement passwordField;

    @FindBy(css = "[id='login-button']")
    private WebElement submitButton;

    private WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }
    public void login(String name, String password) {
        loginIcon.click();
        userField.sendKeys(name);
        passwordField.sendKeys(password);
        submitButton.click();
    }
    public void open() {
        driver.get("https://www.epam.github.io/JDI/index.html");
    }
    public void close () {
        driver.quit();
    }
    public void checkTitle(PageData title) {
        assertEquals(driver.getTitle(), title.toString());
    }
    public void checkLoginned(User person) {
        assertTrue(driver.findElement(By.cssSelector("[id='user-name']")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.id("user-name")).getText(), person.username);
    }
    public void assertFourTexts() {
        Assert.assertEquals(driver.findElement(By.linkText("HOME")).getText(), "HOME");
        Assert.assertEquals(driver.findElement(By.linkText("CONTACT FORM")).getText(), "CONTACT FORM");
        Assert.assertEquals(driver.findElement(By.linkText("SERVICE")).getText(), "SERVICE");
        Assert.assertEquals(driver.findElement(By.linkText("METALS & COLORS")).getText(), "METALS & COLORS");
    }
    public void assertFourImages() {
        assertTrue(driver.findElement(By.cssSelector("[class='icons-benefit icon-practise']")).isDisplayed());
        assertTrue(driver.findElement(By.className("benefit-icon")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("[class='icons-benefit icon-multi']")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("[class='icons-benefit icon-base']")).isDisplayed());
    }
    public void assertTextsWords(int index, PageData text) {
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div["+index+"]/div/span")).getText(), text);
    }
    public void assertTextHeaders (String cssClass, PageData header) {
        assertTrue(driver.findElement(By.cssSelector(cssClass)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.cssSelector(cssClass)).getText(), header);
    }
    public void assertFrame (String id) {
        assertTrue(driver.findElement(By.id(id)).isDisplayed());
    }
    public void switchFrameEPAMLogo (String idFrame, String className) {
        driver.switchTo().frame(idFrame);
        assertTrue(driver.findElement(By.className(className)).isDisplayed());
    }
    public void switchDef () {
        driver.switchTo().defaultContent();
    }
    public void assertSubHeader (String linkText) {
        assertTrue(driver.findElement(By.linkText(linkText)).isDisplayed());
    }
    public void assertProperURL (String linkText, PageData URL, String className) {
        driver.findElement(By.linkText(linkText)).click();
        Assert.assertEquals(driver.getCurrentUrl(), URL);
        driver.switchTo().parentFrame();
        assertTrue(driver.findElement(By.className(className)).isDisplayed());
    }
    public void assertByXPath (String path) {
        assertTrue(driver.findElement(By.xpath(path)).isDisplayed());
    }
    public void assertByCSS (String selector) {
        assertTrue(driver.findElement(By.cssSelector(selector)).isDisplayed());
    }
}