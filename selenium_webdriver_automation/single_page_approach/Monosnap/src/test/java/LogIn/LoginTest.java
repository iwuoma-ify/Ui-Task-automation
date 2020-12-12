package LogIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","resources/ChromeDriver.exe");
        driver=new ChromeDriver();
        driver.get("https://monosnap.com/");

        //sleep for 5 seconds
        Thread.sleep(5000);
        //maximize the window
        driver.manage().window().maximize();
        System.out.println (driver.getTitle());
        driver.manage ().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

        //find the signin icon first and click it
        driver.findElement(By.className("headButton")).click();
        //insert email and password in the placeholders and click the sign in button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/div[2]/input[1]")).sendKeys("iwuomadoris396@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/div[2]/input[2]")).sendKeys("@D0ris1.2.");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/button")).click();

    }

    @Test(priority = 0)
    public void testSuccessfulLogin(){
        if (driver.getCurrentUrl().contains("https://monosnap.com/list/5fcace408a2e6039241d45bf"))
            //pass
            System.out.println("The Login Page successfully loaded!");
        else
            //false
            System.out.println("The Login URL did not successfully load!");
    }

    @Test(priority = 1)
    public void testSuccessfulLogout() throws InterruptedException {
        //click profile button
        driver.findElement (By.xpath("//*[@id=\"store\"]/div[4]/div/div[1]/div/div[3]/div[3]")).click();
        Thread.sleep(2000);

        //click on the logout button
        driver.findElement (By.xpath("//*[@id=\"store\"]/div[4]/div/div[1]/div/div[1]/div[2]")).click();

        if(driver.getCurrentUrl().contains("https://monosnap.com/"))
            //show that we have successfully logout
            System.out.println("You have successfully Logged Out");
        else
            System.out.println("you are yet to log out!");
        Thread.sleep(10000);
    }
    @Test(priority = 2)
    public void testNegativeLogin(){
        driver.findElement(By.className("headButton")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/div[2]/input[1]")).sendKeys("performance@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/div[2]/input[2]")).sendKeys("admin123.");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/div[2]/form/button")).click();
        String expectedErrorMessage = "";
        String actualErrorMessage = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div/header")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        LoginTest test = new LoginTest();
        test.setUp();
    }

    public void tearDown() {
        driver.quit ();
    }
}
