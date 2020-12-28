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
    private By username = By.xpath("//*[@id=\"txtUsername\"]");
    private By password$ = By.id("txtPassword");
    private By click$ = By.xpath("//*[@id=\"btnLogin\"]");
    private By companyLogo = By.xpath("//*[@id=\"divLogo\"]/img");
    private By forgotPassword = By.xpath("//div[@id='forgotPasswordLink']/a[@href='/index.php/auth/requestPasswordResetCode']");
    private By loginPanel = By.xpath ("//*[@id=\"frmLogin\"]");

    public void verifyLoginPanel(){
        //find the login panel
        driver.findElement(loginPanel).isDisplayed();
    }
    public void verifyCompanyLogo(){
        //find the company logo
        driver.findElement(companyLogo).isDisplayed();
    }
    public void verifyForgotPassword(){
        //find the forgot password element on the page
        driver.findElement(forgotPassword).isDisplayed();
    }
    public void enterUsername(String uName)
    {
        //find the username element and enter the username
        driver.findElement(username).sendKeys(uName);
    }
    public String pageTitle(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait until URL is visible
        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/"));
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
        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/"));
        return driver.getCurrentUrl();
    }
}