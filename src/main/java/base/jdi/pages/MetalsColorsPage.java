package base.jdi.pages;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.base.HtmlChecklist;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Checkbox;
import com.epam.jdi.light.ui.html.common.TextField;
import com.epam.jdi.light.ui.html.complex.Checklist;
import com.epam.jdi.light.ui.html.complex.Dropdown;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import homeworks.enums.ColorsMetalsData;
import org.testng.AssertJUnit;

import static homeworks.enums.ColorsMetalsData.*;

public class MetalsColorsPage {

    @UI("[name=checks-group]")
    public static Checklist weather;

    @UI("[name=colors]")
    public static RadioButtons colors;
    @FindBy(css = "li.summ-res")
    private TextField summary;
    @FindBy(css = "li.elem-res")
    private TextField elements;
    @FindBy(css = "li.col-res")
    private TextField color;
    @FindBy(css = "li.met-res")
    private TextField metal;
    @FindBy(css = "li.sal-res")
    private TextField vegs;
    @FindBy(xpath = "//*[@id=\"p2\"]")
    private RadioButtons radioOddButton;

    @FindBy(xpath = "//*[@id=\"p8\"]")
    private RadioButtons radioEvenButton;

    @FindBy(css = "#g1")
    private Checkbox waterCheckBox;

    @FindBy(css = "#g4")
    private Checkbox fireCheckBox;

    @FindBy(xpath = "//*[@id=\"colors\"]/div/button")
    private Dropdown pickColors;

    @FindBy(xpath = "//*[@id=\"metals\"]/div/button")
    private Button metalsDropdown;

    @FindBy(xpath = "///*[@id=\"metals\"]/div/div")
    private Dropdown pickMetals;

    @FindBy(xpath = "//*[@id=\"salad-dropdown\"]/button")
    private Button veggieDropdown;

    @FindBy(xpath = "//*[@id=\"salad-dropdown\"]/ul")
    private Checklist pickVeggies;

    @FindBy(xpath = "//*[@id=\"submit-button\"]")
    private Button submitForm;

    @FindBy(xpath = "body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(4) > a")
    private Button metalsAndColors;

    @JDropdown(root = "#salad-dropdown", value = ".dropdown-toggle", list = "li", expand = ".caret")
    public static Droplist vegetables;

    public void subForm() {
        submitForm.click();
    }

    public void clickMetalsAndColors() {
        metalsAndColors.click();
    }

    public void checkCorrectData(ColorsMetalsData results) {
        AssertJUnit.assertEquals(SUMMARY.toString(), summary.toString());
        AssertJUnit.assertEquals(ELEMENTS.toString(), elements.toString());
        AssertJUnit.assertEquals(METALS.toString(), metal.toString());
        AssertJUnit.assertEquals(VEGS.toString(), vegs.toString());
        AssertJUnit.assertEquals(COLORS.toString(), color.toString());
    }

    public void fillForm() {
        radioEvenButton.select();
        radioOddButton.select();
        waterCheckBox.click();
        fireCheckBox.click();
        pickColors.select(2);
        metalsDropdown.click();
        pickMetals.select("Selen");
        veggieDropdown.click();
        pickVeggies.select("g5", "g6");
        pickVeggies.uncheck("g7");
        vegetables.click();
        vegetables.getSelected().contains("Cucumber");
        vegetables.getSelected().contains("Tomato");
    }

    @FindBy(css = "p input[type='checkbox']")
    public Checklist checklist = new HtmlChecklist() {
        @Override
        public void check(String... names) {
            super.check(names);
        }
    };
}
