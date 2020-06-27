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
import pages.BoardsPageHelper;
import pages.LoginPageHelper;

public class LoginTests extends TestBase{
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;

    @BeforeMethod
    public void initTests(){
        loginPage = new LoginPageHelper(driver);
        boardsPage = new BoardsPageHelper(driver);
    }
        @Test
        public void loginTestPositive()  {

            //WebElement loginButton = driver.findElement(By.linkText("Log In"));
            //loginButton.click();
            //waitUntilElemetIsClickable(By.id("login"),20);

            loginPage.openLoginPage();
            loginPage.enterLoginAtlassianAndClicLogin(LOGIN);
            loginPage.enterPasswordAtlassionAndClickPassword(PASSWORD);
            boardsPage.waitUntilPageIsLoaded();


            //driver.findElement(By.id("user")).sendKeys(LOGIN);
           // waitUntilAttributeValuesIs(By.id("login"),"value","Log in with Atlassian",10);
           // WebElement logButton = driver.findElement(By.id("login"));
           // logButton.click();
           // waitUntilElemetIsClickable(By.id("login-submit"),15);
            //driver.findElement(By.id("password")).sendKeys(PASSWORD);
            //WebElement enterButton = driver.findElement(By.id("login-submit"));
           // enterButton.click();
           // waitUntilElemetIsClickable(By.xpath("//button[@data-test-id='header-boards-menu-button']/span[2]"),40);
            //WebElement boardButton = driver.findElement(By.xpath("//button[@data-test-id='header-boards-menu-button']/span[2]"));
            //System.out.println(boardButton.getText());
            //Assert.assertEquals("Доски",boardButton.getText(),"Text on the boardIcon is not 'Доски'");
            Assert.assertEquals(boardsPage.getButtonBoardsText(),"Доски","Text on the boardIcon is not 'Доски'");

        }

    @Test
        public void loginTestNegative1() {

        loginPage.openLoginPage();
           // WebElement loginButton = driver.findElement(By.linkText("Log In"));
         //  loginButton.click();
          //  waitUntilElemetIsClickable(By.id("login"),20);
        loginPage.enterLoginAndPassword("1a@yahoo.com");
          //  driver.findElement(By.id("user")).sendKeys("1a@yahoo.com");
          //  driver.findElement(By.id("password")).sendKeys("123");
         //Thread.sleep(3000);
         loginPage.waitLoginButtonIsClickable();
        loginPage.pressLoginButton();
          //  WebElement enterButton = driver.findElement(By.id("login"));
           // enterButton.click();
       //Thread.sleep(3000);
        loginPage.waitErrorMessageLoginIncorrect();
           //  waitUntilElemetIsVisible(By.xpath("//div[@id='password-error']"),30);
           //WebElement mist1Button = driver.findElement(By.xpath("//div[@id='password-error']"));
           // System.out.println("Error message: " + mist1Button.getText());
          Assert.assertEquals(loginPage.getErrorMessageloginIncorrect(), "There isn't an account for this email","Error message is not correct");
        }

        @Test
        public void loginTestNegative2() {
            //--- Press log In menu button
             loginPage.openLoginPage();
            //WebElement loginButton = driver.findElement(By.linkText("Log In"));
            //loginButton.click();
           // waitUntilElemetIsClickable(By.id("login"),20);

            //--- Enter Correct Login
             loginPage.loginAsAtlassian(LOGIN,"123");
            //driver.findElement(By.id("user")).sendKeys(LOGIN);
            //waitUntilAttributeValuesIs(By.id("login"),"value","Log in with Atlassian",10);

            //----Click 'Log in' button ----
           // WebElement logButton = driver.findElement(By.id("login"));
           // logButton.click();
             loginPage.waitLoginButtonIsClickable();
            //---Enter incorrect password ---
           // driver.findElement(By.id("password")).sendKeys("123");
           // WebElement enterButton = driver.findElement(By.id("login-submit"));
           // enterButton.click();
            loginPage.waitErrorMessagePasswordIncorrect();
            //waitUntilElemetIsVisible(By.id("login-error"),10);

            //---Print error message ---
            //WebElement mistButton = driver.findElement(By.id("login-error"));
            //System.out.println("Error message: " + mistButton.getText());
            Assert.assertTrue(loginPage.getIncorrectPassswordMessage().contains("Incorrect email address and / or password."),
                    "There is no error message or the text of the message is not correct");
        }
    }
