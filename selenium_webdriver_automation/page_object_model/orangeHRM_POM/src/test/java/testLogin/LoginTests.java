package testLogin;

import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import testSetup.setupTests;

public class LoginTests extends setupTests {
    //My Tests
    @Test (priority = 1)
    public void testALoginPanel ()
    {
        loginPage.verifyLoginPanel();
    }
    @Test (priority = 2)
    public void testACompanyLogo ()
    {
        loginPage.verifyCompanyLogo();
    }

    @Test (priority = 3)
    public void testAForgotPassword ()
    {
        loginPage.verifyForgotPassword();
    }

    @Test (priority = 4)
    public void VerifyLogin() throws InterruptedException
    {
        String username = "Admin";
        loginPage.enterUsername(username);
        loginPage.enterUserPassword("admin123");

        //Handler for DashboardPage
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.clickWelcomeAdmin();
    }
    @Test(priority = 1)
    public void testAPageTitle () throws InterruptedException {

        //Check whether the Page title is correct
        String pageTitle = loginPage.pageTitle();
        if (pageTitle.equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/")) {
            System.out.println("The page title is " + pageTitle);
        } else {
            System.out.println("The page title is incorrect. Actual page title is " + pageTitle);
        }
        Thread.sleep(5000);
    }
}