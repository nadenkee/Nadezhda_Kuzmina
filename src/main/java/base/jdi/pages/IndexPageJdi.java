package base.jdi.pages;

import base.jdi.entities.User;
import base.jdi.forms.LoginForm;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.base.HtmlChecklist;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Checkbox;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.common.TextField;
import com.epam.jdi.light.ui.html.complex.Checklist;
import com.epam.jdi.light.ui.html.complex.Dropdown;
import com.epam.jdi.light.ui.html.complex.Menu;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import homeworks.enums.ColorsMetalsData;
import org.openqa.selenium.support.FindBy;


import static homeworks.enums.ColorsMetalsData.*;
import static org.testng.Assert.assertEquals;

public class IndexPageJdi extends WebPage {
    private LoginForm loginForm;

    @FindBy(css = "[id='user-icon']")
    private Icon loginIcon;

    @FindBy(xpath = "body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(4) > a")
    private Button metalsAndColors;

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

    public void login(User user) {
        loginIcon.click();
        loginForm.login(user);
    }

    public void clickMetalsAndColots() {
        metalsAndColors.click();
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
    }

    public void subForm() {
        submitForm.click();
    }

    public void checkCorrectData(ColorsMetalsData results) {
        assertEquals(SUMMARY.toString(), summary.toString());
        assertEquals(ELEMENTS.toString(), elements.toString());
        assertEquals(METALS.toString(), metal.toString());
        assertEquals(VEGS.toString(), vegs.toString());
        assertEquals(COLORS.toString(), color.toString());
    }

    @FindBy(xpath = "//ul[@class='sidebar-menu'] //span[text()='%s']")
    public Menu menu;

    @UI("[name=checks-group]")
    public static Checklist weather;

    @UI("[name=colors]")
    public static RadioButtons colors;

    @FindBy(css = "p input[type='checkbox']")
    public Checklist checklist = new HtmlChecklist() {
        @Override
        public void check(String... names) {
            super.check(names);
        }
    };

    @JTable
    Table userTable;
}