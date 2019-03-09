package jdi;

import base.jdi.JDISiteLesson;
import base.jdi.entities.User;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//public class JdiSimpleExample {
//
//    @BeforeSuite
//    public void beforeSuite () {
//        PageFactory.initElements(JDISiteLesson.class);
//    }
//    @Test
//    public void simpleJdiTest () {
//        JDISiteLesson.indexPageJdi.open();
//        JDISiteLesson.indexPageJdi.login(User.PETER);
//    }
//    @AfterSuite
//    public void afterSuite () {
//        WebDriverFactory.close();
//    }
//}
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

public class JdiSimpleExample {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        WebSettings.logger.setLogLevel(INFO);
        PageFactory.initElements(JDISiteLesson.class);
    }

//    @Test
//    public void simpleJdiTest() {
//        JDISite.indexPageJdi.open();
//        JDISite.indexPageJdi.login(PETER);
//    }

    @Test
    public void tableTestJdi() {
        JDISiteLesson.indexPageJdi.open();
        JDISiteLesson.indexPageJdi.login(PETER);
    }


    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }

}