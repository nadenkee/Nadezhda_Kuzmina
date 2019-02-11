package homeworks.hw2;

/*

TASK

Exercise 1:
1.	Develop a dedicated test for asserting 4 texts below 4 pictures on the Index Page -https://epam.github.io/JDI/index.html. The test must be developed with help of the DataProvider. Run it in the parallel by methods through the configuring parameters in a @DataProvider annotation.

Exercise 2:
1.	Create 3 copies of the HW1 test in a new class.
2.	Include all these tests to the group “Smoke”
3.	Create 3 copies of the HW1 test in a next class.
4.	Include all these tests to the group “Regression”
5.	Create 3 copies of the HW1 test in a next class.
6.	Include 2 of them to the group “Regression” another one to the group “Smoke”
7.	Create 3 copies of the HW1 test in a next class.
8.	Include all these tests to the groups “Regression” and “Smoke” simultaneously
9.	Create two TestNg config files, the first one runs all “Smoke” test, the second runs “Regression”. Run both of configs must be in parallel by methods mode and with 3 threads.

Exercise 3:
1.	Copy your HW1 test and refactor it in a such way that the test uses all annotations and instructions listed below. Each annotation can contain the only 1 instruction.
2.	Create a dedicated TestNG config for particular test.
@BeforeSuite
@AfterMethod
@BeforeMethod
@BeforeClass
@AfterSuite
@AfterClass
setProperty("webdriver.chrome.driver", driverPath);
WebDriver driver = new ChromeDriver();
System.out.println(driver.getTitle());
driver.manage().window().maximize();
System.out.println(System.currentTimeMillis());
driver.close()

REQUIREMENT
File placement requirements:
      1. Homework must be performed in a new Java class
      2. Use the CamelCase style for class naming
      3. Test method should has a name in accordance with checking functionality
      4. Class must be placed into src/test/java/hw2 package
      5. Each Exercise must be placed to dedicated package src/test/java/hw2/ex1, etc.
      6. When you are ready and have pushed your homework task, please ping me in Skype personally

 */

public class homework2 {
}
