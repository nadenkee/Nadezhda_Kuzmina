package base.jdi.pages;

import base.jdi.entities.User;
import base.jdi.forms.LoginForm;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Icon;
import com.epam.jdi.light.ui.html.complex.Menu;

public class IndexPageJdi extends WebPage {

    LoginForm loginForm;

    @Css("[id='user-icon']")
    private Icon loginIcon;

    @Css(".m-l8")
    private Menu menu;

    @FindBy(xpath = "li[4]/a")
    private Button metAndCol;

    public void login(User user) {
        loginIcon.click();
        loginForm.loginAs(user);
    }

    public void clickMetalsAndColors() {
        metAndCol.click();
    }
}