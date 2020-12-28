package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DashboardPage {
    //create a webDriver object for this class
    private WebDriver driver;

    //create a constructor
    public DashboardPage(WebDriver driver)
    {
        this.driver = driver;
    }
    //locate elements
    private By logout   = By.linkText("Logout");
    private By account =By.className("a391f_3X97l");
    private By category = By.xpath("/html/body/div[1]/div/section/div[2]/nav/div[3]/div/a[2]");
    private By laptop = By.className("_2d663_Ov43s");
    private By apple = By.xpath("//*[@id=\"mainContent\"]/section[2]/section/div/section/div[2]/div[2]/ul/li[5]/a/ul/li[1]/a/label/span");
    private By type1 = By.linkText("Apple Macbook Air 13inch Intel Core I...");
    private By type2 =By.linkText("Apple Macbook Air 2017 13\" Core I5 8g...");
    private By type3 = By.xpath("//*[@id=\"mainContent\"]/section[2]/section/section/section[2]/section/ul/li[11]/div/div/div[1]/a[1]/picture/img");
    private By type4 = By.xpath("//*[@id=\"mainContent\"]/section[2]/section/section/section[2]/section/ul/li[17]/div/div/div[1]/a[1]/picture/img");
    private By type5 = By.xpath("//*[@id=\"mainContent\"]/section[2]/section/section/section[2]/section/ul/li[19]/div/div/div[1]/a[1]/picture/img");
    private By me = By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/nav/div[2]/div/div[3]/div[2]/div/a/span");

    //functions to interact with the element
    public void clickWelcomeAdmin() throws InterruptedException{
        //wait for ten seconds before executing the action
        Thread.sleep(10000);
        driver.getCurrentUrl();
    }

    public DashboardPage clickAccount()
    {
        driver.findElement(me).click();
        return new DashboardPage(driver);
    }

    public LoginPage clickLogout() throws InterruptedException
    {
        //Wait for 3 seconds before executing the action
        Thread.sleep(3000);
        driver.findElement(logout).click();
        return new LoginPage(driver);
    }

    public void accountName() {
        driver.findElement(account).click();
    }

    public LoginPage LoggedOut() {
        //Find the logout element and click on the logout button
        WebElement ChName = driver.findElement(By.className("_7ad32_SD12Y _16536_xxIKG"));
        Actions act = new Actions(driver);
        act.moveToElement(ChName).perform();
        List<WebElement> links = driver.findElements(By.className("_7bc1a_1hRUi ab414_1YBm2"));
        int total_count = links.size();
        for (int i = 0; i < total_count; i++) {
            WebElement element = links.get(i);
            String text = element.getText();
            if (text.equalsIgnoreCase("logout")) {
                element.click();
                break;
            }
        }
        return new LoginPage(driver);
    }
    public void Dashboard() {
        driver.findElement(category).click();
    }

    public void laptopsCategory() {
        driver.findElement(laptop).click();
    }

    public void appleFamily() {
        driver.findElement(apple).click();
    }

    //search for type 1
    public void Type1()
    {
        driver.findElement(type1).isDisplayed();
    }

    //search for type 2
    public void Type2(){
        driver.findElement(type2).isDisplayed();
    }

    //search for type3
    public void Type3()
    {
        driver.findElement(type3).isDisplayed();
    }

    //search for type4
    public void Type4()
    {
        driver.findElement(type4).isDisplayed();
    }
    //search for type5
    public void Type5()
    {
        driver.findElement(type5).isDisplayed();
    }
}