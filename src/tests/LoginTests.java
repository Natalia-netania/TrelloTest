package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
    WebDriver driver;

    @BeforeMethod
    public void initTests() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://trello.com/");
        Thread.sleep(5000);
        System.out.println("Title: " + driver.getTitle());
    }
        @Test
        public void loginTestPositive() throws InterruptedException {
            WebElement loginButton = driver.findElement(By.linkText("Log In"));
            loginButton.click();
            Thread.sleep(1000);
            driver.findElement(By.id("user")).sendKeys("serg_ya@yahoo.com");
            Thread.sleep(1000);
            WebElement logButton = driver.findElement(By.id("login"));
            logButton.click();
            Thread.sleep(1000);
            driver.findElement(By.id("password")).sendKeys("Leto2020zara");
            Thread.sleep(1000);
            WebElement enterButton = driver.findElement(By.id("login-submit"));
            enterButton.click();
            Thread.sleep(30000);
            WebElement boardButton = driver.findElement(By.xpath("//button[@data-test-id='header-boards-menu-button']/span[2]"));
            System.out.println(boardButton.getText());


        }
        @Test
        public void loginTestNegative1() throws InterruptedException {
            WebElement loginButton = driver.findElement(By.linkText("Log In"));
            loginButton.click();
            Thread.sleep(1000);
            driver.findElement(By.id("user")).sendKeys("1a@yahoo.com");
            Thread.sleep(5000);
            driver.findElement(By.id("password")).sendKeys("123");
            Thread.sleep(3000);
            WebElement enterButton = driver.findElement(By.id("login"));
            enterButton.click();
            Thread.sleep(3000);
            WebElement mist1Button = driver.findElement(By.cssSelector("#error>p"));
            System.out.println("Error message: " + mist1Button.getText());
        }

        @Test
        public void loginTestNegative2() throws InterruptedException {
            WebElement loginButton = driver.findElement(By.linkText("Log In"));
            loginButton.click();
            Thread.sleep(1000);
            driver.findElement(By.id("user")).sendKeys("serg_ya@yahoo.com");
            Thread.sleep(1000);
            WebElement logButton = driver.findElement(By.id("login"));
            logButton.click();
            Thread.sleep(1000);
            driver.findElement(By.id("password")).sendKeys("123");
            Thread.sleep(3000);
            WebElement enterButton = driver.findElement(By.id("login-submit"));
            enterButton.click();
            Thread.sleep(3000);
            WebElement mistButton = driver.findElement(By.id("login-error"));
            System.out.println("Error message: " + mistButton.getText());
        }
        @AfterMethod
        public void tearDown(){
            driver.quit();
        }
    }
