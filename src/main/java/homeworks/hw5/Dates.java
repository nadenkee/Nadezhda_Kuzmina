package homeworks.hw5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Dates {
    Actions actions = new Actions(getWebDriver());

    @FindBy(css = "div#mCSB_2_container li")
    private ElementsCollection log;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliders;

    @FindBy(css = ".uui-slider")
    private SelenideElement track;

    @Step("Move slider {0} from/to  {1}")
    public void moveSliderCheckLog(int slider, int direction) {
        actions.clickAndHold(sliders.get(slider)).moveToElement(track, ((track.getSize().width) * (direction) / 100), 0).release().build().perform();
        log.get(0).should(Condition.text(direction + " link clicked"));
    }
}
