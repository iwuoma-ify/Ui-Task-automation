package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    //In the page class, we need the fields that represents the elements on the page and methods to interact with the elements
    private WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }
    //Using By as a locator for elements
    private By username = By.xpath("//*[@id=\"username\"]");
    private By password$ = By.xpath("//*[@id=\"password\"]");
    private By click$ = By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button");
    private By companyLogo = By.cssSelector("img.f5e10_VzEXF:nth-child(1)");
    private By Account = By.linkText ("Login / Signup");
    private By welcomeAdmin = By.id("My Account");

    public void account$(){
        //find the login panel
        driver.findElement(Account).click();
    }
    public void verifyLogo(){
        //find the company logo
        driver.findElement(companyLogo).isDisplayed();
    }
    public void enterUsername(String uName)
    {
        //find the username element and enter the username
        driver.findElement(username).sendKeys(uName);
    }
    public String pageTitle(){
        WebDriverWait wait = new WebDriverWait(driver, 150);
        //wait until URL is visible
        wait.until(ExpectedConditions.urlToBe("Buy Phones, Fashion, Electronics in Nigeria | Konga Online Shopping"));
        return driver.getTitle();
    }
    public void enterUserPassword(String password)
    {
        WebElement pwd = driver.findElement(password$);
        pwd.sendKeys(password);
    }
    public DashboardPage clickLoginBtn()
    {
        driver.findElement(click$).click();
        return new DashboardPage (driver);

    }
    public String getLoginPageURL() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait until URL is visible
        wait.until(ExpectedConditions.urlToBe("https://www.konga.com/"));
        return driver.getCurrentUrl();
    }

    public void clickWelcomeAdmin() throws InterruptedException {
        //wait for ten seconds before executing the action
        Thread.sleep(10000);
        driver.findElement(welcomeAdmin).click();
    }
}