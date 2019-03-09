package lessons.lesson8;

/*
WE USED:
src/test/resources/test.properties
target/classes/test.properties

WE MADE:
pom.xml - resourses, properties w/ JDI 1.0.39 or smth like that
 */

import base.jdi.JDISiteLesson;
import base.jdi.entities.User;
import com.epam.jdi.light.actions.ActionHelper;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.preconditions.WebPreconditions;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static base.jdi.entities.User.*;
import static com.epam.jdi.light.logger.LogLevels.INFO;
import static homeworks.enums.PageData.WEB_ADDR;

public class JdiSimpleExample {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        WebSettings.logger.setLogLevel(INFO);
        PageFactory.initElements(JDISiteLesson.class);
    }

    @Test
    public void simpleJdiTest() {
        JDISiteLesson.indexPageJdi.open(WEB_ADDR);
        JDISiteLesson.indexPageJdi.login(PETER);
    }

//    @Test
//    public void tableTestJdi() {
//        JDISiteLesson.indexPageJdi.open();
//        JDISiteLesson.indexPageJdi.login(PETER);
//        JDISiteLesson.indexPageJdi.checklist.check("Fire");
//    }


    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }

}