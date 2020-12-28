package HomePageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CategoryTest extends DashboardTests {

    @Test(priority = 7)
    public void checkCurrentURL(){
        String ApplePage = driver.getTitle();
        String ExpectedTitle = "title";
        Assert.assertEquals("title","title");
    }
    @Test(priority = 8)
    public void CategoryTest1() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/nav/div[3]/div/a[2]")).click();
        Thread.sleep(10000);
        driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[2]/section/div/section/div[2]/div[2]/ul/li/a/ul/li[1]/a/label/span")).click();

        boolean T2 = driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[2]/section/section/section[2]/section/ul/li[3]/div/div/div[2]/a/div[1]/h3")).isDisplayed();
        if (T2) {
            System.out.println("This is the right Object 1");
        } else {
            System.out.println("This is the wrong object");
        }
    }

    @Test(priority = 9)
    public void CategoryTest2() {

        boolean T2 = driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[2]/section/section/section[2]/section/ul/li[3]/div/div/div[2]/a/div[1]/h3")).isDisplayed();
        if (T2) {
            System.out.println("This is the right Object 2");
        } else {
            System.out.println("This is the wrong object");
        }
    }

    @Test(priority = 10)
    public void CategoryTest3() {

        boolean T3 = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[2]/section/section/section[2]/section/ul/li[11]/div/div/div[1]/a[1]/picture/img")).isDisplayed();
        if (T3) {
            System.out.println("This is the right Object 3");
        } else {
            System.out.println("This is the wrong object");
        }
    }

    @Test(priority = 11)
    public void CategoryTest4() throws InterruptedException {

        boolean T4 = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[2]/section/section/section[2]/section/ul/li[17]/div/div/div[1]/a[1]/picture/img")).isDisplayed();
        if (T4) {
            System.out.println("This is the right Object 4");
        } else {
            System.out.println("This is the wrong object");
        }
    }

    @Test(priority = 12)
    public void CategoryTest5() {

        boolean T5 = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[2]/section/section/section[2]/section/ul/li[19]/div/div/div[1]/a[1]/picture/img")).isDisplayed();
        if (T5){
            System.out.println("This is the right Object 5");
        } else {
            System.out.println("This is the wrong object");
        }
    }

    @Test(priority = 13)
    public void CheckingLogout () throws InterruptedException
    {
        Thread.sleep(1000);
        WebElement ChName = driver.findElement(By.linkText("My Account"));
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
        String URl = driver.getCurrentUrl();
        String expectedURL = "https://www.konga.com/category/accessories-computing-5227";
        Assert.assertEquals(URl, expectedURL, "you have Successfully logged out!");
    }
}