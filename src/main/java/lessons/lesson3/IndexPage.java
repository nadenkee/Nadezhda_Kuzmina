package lessons.lesson3;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {

    @FindBy(css = "[id='user-icon']")
    private WebElement loginIcon;

    @FindBy (css = "[id='name']")
    private WebElement userField;

    @FindBy(css = "[id='password']")
    private WebElement passwordField;
    
    @FindBy(css = "[id='login-button']")
    private WebElement submitButton;

    private WebDriver driver;

    public IndexPage (WebDriver driver) {
        this.driver = driver;
    }
    
    public void login(String name, String password) {

       /*
       Это то, что мы заменяем pageFactory
       loginIcon = driver.findElement(By.cssSelector("[id='user-icon']"));
       userField = driver.findElement(By.cssSelector("[id='name']"));
        passwordField = driver.findElement(By.cssSelector("[id='password']"));
        driver.findElement(By.cssSelector("[id='login-button']"));
        */
        loginIcon.click();
        userField.sendKeys(name);
        passwordField.sendKeys(password);
        submitButton.click();
    }
    
    public void open () {
        driver.get("https://www.epam.github.io/JDI/index.html");
    }

    public void navigateMenu() {
    }
}