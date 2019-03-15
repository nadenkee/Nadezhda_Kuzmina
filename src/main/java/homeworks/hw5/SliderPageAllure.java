package homeworks.hw5;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.actions;
import static org.testng.Assert.assertTrue;

public class SliderPageAllure {

    @FindBy(css = "[class='panel-body-list logs']")
    private SelenideElement logs;

    @FindBy(css = ".ui-slider-handle.ui-state-default.ui-corner-all")
    private ElementsCollection sliders;

    public void moveSlidersBoundaryPosition(int left, int right) {
        assertCorrectValues(left, right);
        SelenideElement leftSlider = sliders.get(0);
        SelenideElement rightSlider = sliders.get(1);
        moveSliderLeftEnd(leftSlider);
        moveSliderRightEnd(rightSlider);
//            int step = step();
        moveSliderLeftEnd(rightSlider);
        if (right == 100) {
            moveSliderRightEnd(rightSlider);
        } else {
            moveSlider(rightSlider, right);
        }
        if (left == 100) {
            moveSliderRightEnd(leftSlider);
        } else {
            moveSlider(leftSlider, left);
        }
    }

    public void moveSliderLeftEnd(SelenideElement slider) {
        actions().dragAndDropBy(slider, -1000, 0).build().perform();

    }

    public void moveSliderRightEnd(SelenideElement slider) {
        actions().dragAndDropBy(slider, 1000, 0).build().perform();
    }

    public void moveSlider(SelenideElement slider, int set) {
        int step = 1;
        int actualValue = Integer.valueOf(slider.getText());
        if (set < actualValue) {
            step = -1;
        }
        while (actualValue != set) {
            actions().dragAndDropBy(slider, step, 0).build().perform();
            actualValue = Integer.valueOf(slider.getText()) - 1;
        }
    }

//        public int step() {
//            moveSliderRightEnd(sliders.get(1));
//            moveSliderLeftEnd(sliders.get(0));
//            return (sliders.get(1).getLocation().getX() - sliders.get(0).getLocation().getX()) / 100;
//        }

    public void checkFromAndToInLogs(int left, int right) {
        assertCorrectValues(left, right);
        assertTrue(logs.getText().contains("(To):" + right));
        assertTrue(logs.getText().contains("(From):" + left));
    }

    public void assertCorrectValues(int right, int left) {
        if (left < 0 || left > 100 || right < 0 || right > 100) {
            throw new IllegalArgumentException("The range of the sliders should be in [0, 100]");
        }
    }
}
