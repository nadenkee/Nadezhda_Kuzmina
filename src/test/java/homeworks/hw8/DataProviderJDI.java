package homeworks.hw8;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import static base.jdi.entities.User.PETER;
import static homeworks.hw8.JdiSite.homePage;
import static homeworks.hw8.JdiSite.metalsColorsPage;
import static java.lang.System.setProperty;

public class DataProviderJDI {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initElements(JdiSite.class);
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriverManager.chromedriver().version("73");
        homePage.open();
        // 1 Login on JDI site as User
        homePage.login(PETER);
        // 2 Open Metals&Colors page by Header menu
        homePage.clickMetalsAndColors();
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }

    @AfterMethod
    public void afterMethod() {
        WebDriverFactory.getDriver().manage().deleteAllCookies();
    }

    @Test(dataProvider = "getData")
    public void testMethod(MetalsAndColorsPOJO data) {
        // 3 Fill form Metals & Colors by data from file and submit
        metalsColorsPage.metalsForm.submit(data);
        // 4 Result Section contains correct data
        metalsColorsPage.checkResultLog(data);
    }

    @DataProvider
    public Object[][] getData() throws FileNotFoundException {
        JsonObject jsonMap = new JsonParser()
                .parse(new FileReader("src/test/resources/hw8/JDI_ex8_metalsColorsDataSet.json"))
                .getAsJsonObject();
        Object[][] returnedArray = new Object[jsonMap.size()][1];
        int index = 0;
        for (Map.Entry<String, JsonElement> entry : jsonMap.entrySet()) {
            returnedArray[index++][0] = new Gson()
                    .fromJson(entry.getValue(), MetalsAndColorsPOJO.class);
        }
        return returnedArray;
    }
}

