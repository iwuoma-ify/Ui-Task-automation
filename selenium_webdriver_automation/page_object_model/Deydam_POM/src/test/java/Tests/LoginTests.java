package Tests;

import org.testng.annotations.Test;
import pageObject.DashboardPage;
import SetUp.setupTests;

public class LoginTests extends setupTests {
    //TestNG annotation
    @Test
    public void testLogin() throws InterruptedException{
        String username = "performanceTest";
        loginPage.enterUsername(username);
        loginPage.enterUserPassword("admin123.");

        DashboardPage dashboardPage = loginPage.ClickLoginButton();
        dashboardPage.clickWelcomeAdmin();
        loginPage = dashboardPage.clickLogout();
    }
}