package Login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","resources/ChromeDriver.exe");
        driver=new ChromeDriver();
        driver.get("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login");

        //sleep for 5 seconds
        Thread.sleep(2000);
        //maximize the window
        driver.manage().window().maximize();
        System.out.println (driver.getTitle());
        driver.manage ().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

        //enter the email and password
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("performancetest");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("admin123.");

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(1000);
    
    }
    @Test(priority = 0)
    public void testSuccessfulLogin(){
        if (driver.getCurrentUrl().contains("https://dev.d2rxvhrryr2bkn.amplifyapp.com/app/feed"))
            //pass
            System.out.println("The Login Page contains /app/feed");
        else
            //false
            System.out.println("The Login URL does not contain /app/feed");
    }

    @Test(priority = 1)
    public void testSuccessfulLogout() throws InterruptedException {
        //click profile button
        driver.findElement (By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/button/p")).click();
        Thread.sleep(2000);

        //click on the logout button
        driver.findElement (By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/div/div/a[3]/p")).click();

        if(driver.getCurrentUrl().contains("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login"))
            //show that we have successfully logout
            System.out.println("You have successfully Logged Out");
        else
            System.out.println("you are yet to log out!");
    }
    @Test(priority = 2)
    public void testNegativeLogin(){
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("performanceTesters");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("admin123.");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        String expectedErrorMessage = "Login Failed: Invalid username or password";
        String actualErrorMessage = driver.findElement(By.className("alert__content")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        driver.quit();
    }
    public static void main(String[] args) throws InterruptedException {
        LoginTest test = new LoginTest();
        test.setUp();
    }

    public void tearDown() {
        driver.quit();
    }
}
