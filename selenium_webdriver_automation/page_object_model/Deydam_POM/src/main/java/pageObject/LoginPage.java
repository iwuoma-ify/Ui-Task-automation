package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    //import WebDriver
    private WebDriver driver;

    //setting the driver controller
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Using By as a locator for elements
    private By Username = By.id("username");
    private By passwordField = (By.id("password"));

    public void enterUsername(String uName)
    {
        //find the username element
        driver.findElement (Username).sendKeys (uName);
    }
    public void enterUserPassword (String pwd)
    {
        //enter the password
        driver.findElement(passwordField).sendKeys(pwd);
    }

    public DashboardPage ClickLoginButton () throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(5000);
        return new DashboardPage(driver);
    }
}