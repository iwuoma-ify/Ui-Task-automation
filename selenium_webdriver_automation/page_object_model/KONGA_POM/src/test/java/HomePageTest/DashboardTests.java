package HomePageTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTests extends LoginTests{

    @Test(priority = 5)
    public void AssertURL(){
        String URL = driver.getCurrentUrl();
        if (URL.equalsIgnoreCase("https://www.konga.com/")){
            System.out.println("This is the correct Homepage URL");
        }else{
            System.out.println("This is not the right Homepage");
        }
    }

    @Test(priority = 6)
    public void assertName() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.linkText("My Account")).click();
        Thread.sleep(3000);
        boolean dName = driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/div[2]/div[2]/div/div/form/div[1]/input")).isDisplayed();
        if (dName){
            System.out.println("The First Name is there!");
        }else{
            System.out.println("The First Name is not there");
        }
    }
}