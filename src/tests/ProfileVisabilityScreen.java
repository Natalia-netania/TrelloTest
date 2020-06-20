package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Objects;

public class ProfileVisabilityScreen extends TestBase{

    @BeforeMethod
    public void initTests() throws InterruptedException {
        //--- Press log In menu button
        driver.findElement(By.linkText("Log In")).click();
        Thread.sleep(2000);

        //----Enter login value and click 'Log in' button ----
        driver.findElement(By.id("user")).sendKeys(LOGIN);
        Thread.sleep(1000);
        driver.findElement(By.id("login")).click();
        Thread.sleep(1000);

        //---- Enter password value and click 'Log in' button
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(10000);
        WebElement menuButton = driver.findElement(By.xpath("//button[@data-test-id='header-member-menu-button']"));
        menuButton.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@data-test-id='header-member-menu-profile']")).click();
        Thread.sleep(2000);
    }
    @Test
    public void comparisonLabelTextVerification() throws InterruptedException {

        WebElement menuButton = driver.findElement(By.xpath("//button[@data-test-id='header-member-menu-button']"));
        System.out.println(driver.findElement(By.xpath("//span[@class='_24AWINHReYjNBf'][contains(text(),'N')]")).getText());
        if (
        Objects.equals(driver.findElement(By.xpath("//button[@data-test-id='header-member-menu-button']")).getText(),
                driver.findElement(By.xpath("//span[@class='_24AWINHReYjNBf'][contains(text(),'N')]")).getText()));
        {
            System.out.println("Profile labels match and equal " +
                    driver.findElement(By.xpath("//button[@data-test-id='header-member-menu-button']")).getText());
    }
        Assert.assertEquals(menuButton.getText(),"N","Error: Profile labels do not match");
    }

    @Test
    public void userNameVerification() throws InterruptedException {

        WebElement userName = driver.findElement(By.xpath("//span[@class='YGN7y_VVuqFYYB']"));
        //System.out.println(userName.getText());
        WebElement userNamePub = driver.findElement(By.xpath("//input[@name='username']"));
        System.out.println(userNamePub.getText());
        if (
                Objects.equals(userName.getText(),userNamePub.getText()));
        {
            System.out.println("User names match and equal " +
                    userName.getText());
        }
        Assert.assertEquals(userName.getText(),"@natalia46615563","Error: User names do not match");
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
