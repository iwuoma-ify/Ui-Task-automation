package setUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.LoginPage;

public class setUps {
    //Create a WebDriver object
    private WebDriver driver;
    //Create a Login Object
    public static LoginPage loginPage;


    @BeforeTest
    public void setUp()
    {
        //Selenium WebDriver needs this executable in order to in orser to know which browser to run your test
        //Browser setup for Chrome
        System.setProperty("webdriver.chrome.driver", "resources/ChromeDriver.exe");
        //Instantiate WebDriver object
        driver = new ChromeDriver();

        //Any activity you want to do concerning your automated test can now be done using the driver

        //Maximize window size
        driver.manage().window().maximize();

        //Launch the application
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //Initialize the login page after launching the browser - Handle
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void closeBrowser()
    {
        //".close" would close the window while ".quit" would exit the session.
        driver.quit();
    }
}