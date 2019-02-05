package base;

import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.open;
import java.util.List;

public class SelenideIndexPage {


  //  @FindBy


    public void opennIndexPage () {
        open ("https://epam.github.io/JDI/index.html");

    }
}
