package homeworks.hw8.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import homeworks.hw8.MetalsAndColorsPOJO;

public class MetalForm extends Form<MetalsAndColorsPOJO> {
    @FindBy(css = "#odds-selector p")
    public RadioButtons odds;

    @FindBy(css = "#even-selector p")
    public RadioButtons even;

    @JDropdown(root = "div[ui=combobox]", value = "input",
            list = "li", expand = ".caret")
    public Droplist metals;

    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option",
            list = "li", expand = ".caret")
    public Droplist colors;

    @JDropdown(root = "div[ui=droplist]",
            value = ".dropdown-toggle",
            list = "li",
            expand = ".caret")
    public static Droplist vegetables;

    @Css(".vertical-group p")
    public WebList natureElements;

    @FindBy(css = "#submit-button")
    public Button submitButton;

    @Override
    public void submit(MetalsAndColorsPOJO data) {
        odds.select(String.valueOf(data.summary[0]));
        even.select(String.valueOf(data.summary[1]));
        for (String s : data.elements) {
            natureElements.select(s);
        }
        vegetables.select(vegetables.getSelected());
        for (String vegetable : data.vegetables) {
            vegetables.select(vegetable);
        }
        colors.select(data.color);
        metals.select(data.metals);
        submitButton.click();
    }
}
