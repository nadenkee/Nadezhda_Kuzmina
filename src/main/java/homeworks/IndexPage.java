package homeworks;


import homeworks.enums.User;
import homeworks.enums.PageData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static homeworks.enums.PageData.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    public void login(User PITER) {
        loginIcon.click();
        userField.sendKeys(PITER.login);
        passwordField.sendKeys(PITER.password);
        submitButton.click();
    }

    public void open() {
        driver.get("https://epam.github.io/JDI/index.html");
    }

    public void close() {
        driver.quit();
    }

    public void checkTitle(PageData title) {
        assertEquals(driver.getTitle(), title.toString());
    }

    public void checkLoginned(User person) {
        assertTrue(driver.findElement(By.cssSelector("[id='user-name']")).isDisplayed());
        assertEquals(driver.findElement(By.id("user-name")).getText(), person.username);
    }

    public void assertFourTexts() {
        assertEquals(driver.findElement(By.linkText("HOME")).getText(), "HOME");
        assertEquals(driver.findElement(By.linkText("CONTACT FORM")).getText(), "CONTACT FORM");
        assertEquals(driver.findElement(By.linkText("SERVICE")).getText(), "SERVICE");
        assertEquals(driver.findElement(By.linkText("METALS & COLORS")).getText(), "METALS & COLORS");
    }

    public void assertFourImages() {
        assertTrue(driver.findElement(By.cssSelector("[class='icons-benefit icon-practise']")).isDisplayed());
        assertTrue(driver.findElement(By.className("benefit-icon")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("[class='icons-benefit icon-multi']")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("[class='icons-benefit icon-base']")).isDisplayed());
    }

    public void assertTextsWords() {
        assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[" + 1 + "]/div/span")).getText(), TEXT_ONE);
        assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[" + 2 + "]/div/span")).getText(), TEXT_TWO);
        assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[" + 34 + "]/div/span")).getText(), TEXT_THREE);
        assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/main/div[2]/div/div[" + 1 + "]/div/span")).getText(), TEXT_FOUR);
    }

    public void assertTextHeaders() {
        assertTrue(driver.findElement(By.cssSelector("[class='main-title text-center']")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("[class='main-title text-center']")).getText(), TEXT_CENTER.toString());
        assertTrue(driver.findElement(By.cssSelector("[class='main-txt text-center']")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("[class='main-txt text-center']")).getText(), TEXT_MAIN_TITLE.toString());
    }

    public void assertFrame() {
        assertTrue(driver.findElement(By.id("iframe")).isDisplayed());
    }

    public void switchFrameEPAMLogo() {
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.className("epam-logo")).isDisplayed());
    }

    public void switchDef() {
        driver.switchTo().defaultContent();
    }

    public void assertSubHeader() {
        assertTrue(driver.findElement(By.linkText("JDI GITHUB")).isDisplayed());
    }

    public void assertProperURL(PageData URL) {
        driver.findElement(By.linkText("JDI GITHUB")).click();
        assertEquals(driver.getCurrentUrl(), URL.toString());
        driver.switchTo().parentFrame();
        assertTrue(driver.findElement(By.className("footer-bg")).isDisplayed());
    }

    public void assertByXPath() {
        assertTrue(driver.findElement(By.xpath("//*[@id=\"mCSB_1\"]")).isDisplayed());
    }

    public void assertByCSS() {
        assertTrue(driver.findElement(By.cssSelector("[class='footer-bg']")).isDisplayed());
    }
}