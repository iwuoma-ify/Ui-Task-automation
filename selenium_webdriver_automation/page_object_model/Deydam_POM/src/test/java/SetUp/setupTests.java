package SetUp;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObject.DashboardPage;
import pageObject.LoginPage;

public class setupTests {
    //Create a WebDriver object
    private WebDriver driver;
    //Create a Login Object
    protected LoginPage loginPage;


    @BeforeTest
    public void setUp()
    {
        //Browser setup for Chrome
        System.setProperty("webdriver.chrome.driver", "Resources/ChromeDriver.exe");
        //Instantiate WebDriver object
        driver = new ChromeDriver();

        //Launch the application
        driver.get("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login");

        //Maximize window size
        driver.manage().window().maximize();

        //Initialize the login page after launching the browser
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void closeBrowser()
    {
        // this will close the session
        driver.quit();
    }
}