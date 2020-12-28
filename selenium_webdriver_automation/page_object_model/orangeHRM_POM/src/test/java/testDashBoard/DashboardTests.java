package testDashBoard;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import testLogin.LoginTests;

public class DashboardTests extends LoginTests{

    @Test
    public void testLeaveRequest () throws InterruptedException {
        String AD = driver.findElement(By.cssSelector("tr.even:nth-child(10) > td:nth-child(1) > a:nth-child(1)")).getText();
        if (AD.equalsIgnoreCase("Kevin Mathews 2020-12-14")) {
            System.out.println("Text is present");
        }else{
            System.out.println("Text is absent");
        }
    }

    @Test(priority = 1)

    //This class entends to the SetupTests class contains all the setup requirements to run our test
    public void testLogout () throws InterruptedException {
        //Handler for dashboard page
        driver.findElement(By.id("welcome")).click();
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(100);
        String loginPageURL = "https://opensource-demo.orangehrmlive/";
        Assert.assertEquals(loginPage.getLoginPageURL(), loginPageURL, "Not on user dashboard");
    }

    @Test(priority = 1)
    public void CheckingLogout () throws InterruptedException
    {
        Thread.sleep(1000);
    }
}