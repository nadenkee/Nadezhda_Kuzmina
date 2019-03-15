package base.jdi.pages;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Checkbox;
import com.epam.jdi.light.ui.html.common.TextField;
import com.epam.jdi.light.ui.html.complex.Checklist;
import com.epam.jdi.light.ui.html.complex.Dropdown;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import homeworks.enums.NatureElements;
import homeworks.enums.Vegs;
import homeworks.hw7.entities.MetalsAndColors;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static homeworks.enums.ColorsMetalsData.*;
import static homeworks.enums.Vegs.VEGETABLES;
import static homeworks.hw7.entities.MetalsAndColors.TEST_ENTITY;
import static org.testng.Assert.assertEquals;

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

    @FindBy(css = "#odds-selector p")
    private RadioButtons radioOddButton;

    @FindBy(css = "#even-selector p")
    private RadioButtons radioEvenButton;

    @FindBy(css = "#g1")
    private Checkbox waterCheckBox;

    @FindBy(css = "#g4")
    private Checkbox fireCheckBox;

    @FindBy(xpath = "///*[@id=\"metals\"]/div/div")
    private Dropdown pickMetals;

    @FindBy(xpath = "//*[@id=\"salad-dropdown\"]/button")
    private Button veggieDropdown;

    @FindBy(xpath = "//*[@id=\"salad-dropdown\"]/ul")
    private Checklist pickVeggies;

    @FindBy(css = "#submit-button")
    private Button submitForm;

    @FindBy(xpath = "body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(4) > a")
    private Button metalsAndColors;

    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option", list = "li", expand = ".caret")
    public Droplist colorsDrop;

    @JDropdown(root = "#salad-dropdown", value = ".dropdown-toggle", list = "li", expand = ".caret")
    public static Droplist vegetablesDrop;

    @JDropdown(root = "div[ui=combobox]", value = "input", list = "li", expand = ".caret")
    public Droplist metalsDrop;

    @Css("[class='panel-body-list results'] li")
    public WebList resultLog;

    @Css(".vertical-group p")
    public WebList natureElements;

    public void subForm() {
        submitForm.click();
    }

    public void clickMetalsAndColors() {
        metalsAndColors.click();
    }

    public void checkCorrectData(MetalsAndColors results) {
        List<String> logList = resultLog.getAll().stream().map(WebElement::getText).collect(Collectors.toList());
        assertEquals(logList.get(0), "Summary: " + (SUMMARY));
        assertEquals(logList.get(1), "Elements: " + TEST_ENTITY.natureElements[0].toString() + ", " + TEST_ENTITY.natureElements[1].toString());
        assertEquals(logList.get(2), "Color: " + COLORS.toString());
        assertEquals(logList.get(3), "Metal: " + METALS.toString());
        assertEquals(logList.get(4), "Vegetables: " + TEST_ENTITY.vegetables[0].toString() + ", " + TEST_ENTITY.vegetables[1].toString());
    }

    public void fillForm(MetalsAndColors data) {
        radioEvenButton.select(String.valueOf(data.evenSum));
        radioOddButton.select(String.valueOf(data.oddSum));
        for (NatureElements element : data.natureElements) {
            natureElements.select(element.toString());
        }
        colorsDrop.select(data.color.toString());
        metalsDrop.select(data.metal.toString());
        vegetablesDrop.select(VEGETABLES.toString());
        for (Vegs vegetable : data.vegetables) {
            vegetablesDrop.select(vegetable.toString());
        }
    }
}
