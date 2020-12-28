package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    //create a webDriver object for this class
    private WebDriver driver;
    //create a constructor
    public DashboardPage(WebDriver driver)
    {
        this.driver = driver;
    }
    //locate elements
    private By welcomeAdmin = By.cssSelector(".topbar__avatar-name");
    private By logout   = By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/div/div/a[3]/p");
    //functions to interact with the element
    public void clickWelcomeAdmin() throws InterruptedException{
        //wait for ten seconds before executing the action
        Thread.sleep(10000);
        driver.findElement(welcomeAdmin).click();
    }
    public LoginPage clickLogout() throws InterruptedException
    {
        //Wait for 3 seconds before executing the action
        Thread.sleep(3000);
        driver.findElement(logout).click();
        return new LoginPage(driver);
    }
}