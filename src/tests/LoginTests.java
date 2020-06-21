package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

        @Test
        public void loginTestPositive()  {
            WebElement loginButton = driver.findElement(By.linkText("Log In"));
            loginButton.click();
            waitUntilElemetIsClickable(By.id("login"),20);

            driver.findElement(By.id("user")).sendKeys(LOGIN);
            waitUntilAttributeValuesIs(By.id("login"),"value","Log in with Atlassian",10);
            WebElement logButton = driver.findElement(By.id("login"));
            logButton.click();
            waitUntilElemetIsClickable(By.id("login-submit"),15);
            driver.findElement(By.id("password")).sendKeys(PASSWORD);
            WebElement enterButton = driver.findElement(By.id("login-submit"));
            enterButton.click();
            waitUntilElemetIsClickable(By.xpath("//button[@data-test-id='header-boards-menu-button']/span[2]"),40);
            WebElement boardButton = driver.findElement(By.xpath("//button[@data-test-id='header-boards-menu-button']/span[2]"));
            //System.out.println(boardButton.getText());
            Assert.assertEquals("Доски",boardButton.getText(),"Text on the boardIcon is not 'Доски'");


        }

    @Test
        public void loginTestNegative1() {
            WebElement loginButton = driver.findElement(By.linkText("Log In"));
            loginButton.click();

             waitUntilElemetIsClickable(By.id("login"),20);
            driver.findElement(By.id("user")).sendKeys("1a@yahoo.com");
            //Thread.sleep(5000);
            driver.findElement(By.id("password")).sendKeys("123");

            WebElement enterButton = driver.findElement(By.id("login"));
            enterButton.click();

             waitUntilElemetIsVisible(By.xpath("//div[@id='error']"),30);
            WebElement mist1Button = driver.findElement(By.cssSelector("#error>p"));
            System.out.println("Error message: " + mist1Button.getText());
            Assert.assertEquals(mist1Button.getText(), "There isn't an account for this email","Error message is not correct");
        }

        @Test
        public void loginTestNegative2() {
            //--- Press log In menu button
            WebElement loginButton = driver.findElement(By.linkText("Log In"));
            loginButton.click();
            waitUntilElemetIsClickable(By.id("login"),20);

            //--- Enter Correct Login
            driver.findElement(By.id("user")).sendKeys(LOGIN);
            waitUntilAttributeValuesIs(By.id("login"),"value","Log in with Atlassian",10);

            //----Click 'Log in' button ----
            WebElement logButton = driver.findElement(By.id("login"));
            logButton.click();

            //---Enter incorrect password ---
            driver.findElement(By.id("password")).sendKeys("123");
            WebElement enterButton = driver.findElement(By.id("login-submit"));
            enterButton.click();
            waitUntilElemetIsVisible(By.id("login-error"),10);

            //---Print error message ---
            WebElement mistButton = driver.findElement(By.id("login-error"));
            System.out.println("Error message: " + mistButton.getText());
            Assert.assertTrue(mistButton.getText().contains("Incorrect email address and / or password."),
                    "There is no error message or the text of the message is not correct");
        }
    }
