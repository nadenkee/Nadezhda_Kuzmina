
package lessons.lesson4;

/* Selenide, Best Practices UI Testing

PRESENTATION

open(String url)

$(String cssSelector) -- SelenideElement
$(By)

$$(String cssSelector) -- SelenideCollection
$$(By)

getWebDriver() - return WebDriver object

METHODS                                 CONDITIONS
should                                  text()
shouldNot                               visible
shouldBe                                hidden
shouldNotBe                             focused
shouldHave                              checked
shouldNotHave                           attribute()
==============================================================
$$().shouldHave(CollectionCondition)    texts()
$$().shouldHaveSize(int size)           sizeLessThan()
                                        sizeGreaterThan()

Потом разбираем Configuration.browser....pageLoadStrategy etc.
pollingInterval - время ожидания, селеинд этим отличается!



 */

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.CHROME;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.System.setProperty;
import static org.openqa.selenium.By.cssSelector;
import static org.testng.Assert.assertEquals;

public class SimpleTest {

    @BeforeSuite
    public void beforeSuite () {
        browser = CHROME;
        timeout = 5000;
        pollingInterval = 300;
    }


    @BeforeClass
    public void BeforeClass() {

        setProperty ("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @Test
    public void simpleTest () {
        //1
        //2
        open ("https://epam.github.io/JDI/index.html");

        //3
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //4
/*
        $("[id='user-icon']").click();
        $("[id='name']").sendKeys("epam");
        $("[id='password']").sendKeys("1234");
        $("[id='login-button']").click();
*/
       // $("[id='user-name']".shouldHave(text("Piter Chailovskii")));

        close();
    }

}
