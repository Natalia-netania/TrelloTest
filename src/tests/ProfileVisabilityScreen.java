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
import pages.BoardsPageHelper;
import pages.CurrentBoardHelper;
import pages.LoginPageHelper;
import pages.ProfileVisabilityScreenHelper;

public class ProfileVisabilityScreen extends TestBase{

    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardHelper qaHaifa56Page;
    ProfileVisabilityScreenHelper profilePage;

    @BeforeMethod
    public void initTests() {

        loginPage = new LoginPageHelper(driver);
        boardsPage = new BoardsPageHelper(driver);
        profilePage = new ProfileVisabilityScreenHelper(driver);
        loginPage.openLoginPage();
        loginPage.loginAsAtlassian(LOGIN, PASSWORD);
        boardsPage.waitUntilPageIsLoaded();

        //--- Press log In menu button
      //  driver.findElement(By.linkText("Log In")).click();
       // waitUntilElemetIsClickable(By.id("login"),20);

        //----Enter login value and click 'Log in' button ----
      //  driver.findElement(By.id("user")).sendKeys(LOGIN);
       // waitUntilAttributeValuesIs(By.id("login"),"value","Log in with Atlassian",10);
       // driver.findElement(By.id("login")).click();
      //  waitUntilElemetIsClickable(By.id("login-submit"),15);

        //---- Enter password value and click 'Log in' button
      //  driver.findElement(By.id("password")).sendKeys(PASSWORD);
      //  driver.findElement(By.id("login-submit")).click();
        profilePage.waitUntilElementIsClickable();
        //waitUntilElemetIsClickable(By.xpath("//button[@data-test-id='header-boards-menu-button']/span[2]"),40);
        profilePage.clickMenuButton();
       // WebElement menuButton = driver.findElement(By.xpath("//button[@data-test-id='header-member-menu-button']"));
       // menuButton.click();
       // driver.findElement(By.xpath("//a[@data-test-id='header-member-menu-profile']")).click();
    }

    @Test
    public void comparisonLabelTextVerification() throws InterruptedException {
        profilePage.waitUntilElementIsVisible();
        profilePage.getNameButton();
       // WebElement menuButton = driver.findElement(By.xpath("//button[@data-test-id='header-member-menu-button']"));
       // System.out.println(driver.findElement(By.xpath("//span[@class='_24AWINHReYjNBf'][contains(text(),'N')]")).getText());
        if(
                Objects.equals(profilePage.getNameButtonText(),profilePage.getNameButtonTitleText() )
        )
        {
            System.out.println("Profile labels match and equal " + profilePage.getNameButtonText());
        }

        //if (
       // Objects.equals(driver.findElement(By.xpath("//button[@data-test-id='header-member-menu-button']")).getText(),
        //        driver.findElement(By.xpath("//span[@class='_24AWINHReYjNBf'][contains(text(),'N')]")).getText()));
       // {
         //   System.out.println("Profile labels match and equal " +
         //           driver.findElement(By.xpath("//button[@data-test-id='header-member-menu-button']")).getText());
   // }
        Assert.assertEquals(profilePage.getNameButtonText(),"N","Error: Profile labels do not match");
    }

    @Test
    public void userNameVerification() throws InterruptedException {

        //profilePage.waitUntilElementIsVisible();
        profilePage.waitUntilElemetIsClickable1();
        profilePage.loadButtonUserName();
        //Thread.sleep(6000);
        profilePage.loadButtonUserNamePub();
        //waitUntilElemetIsClickable(By.xpath("//a[@class='tabbed-pane-nav-item-button js-member-activity']"),50);
        //WebElement userName = driver.findElement(By.xpath("//span[@class='YGN7y_VVuqFYYB']"));
        //WebElement userName = driver.findElement(By.xpath("//span[contains(text(),'@')]"));
        //System.out.println(userName.getText());
       // WebElement userNamePub = driver.findElement(By.xpath("//input[@name='username']"));
        //System.out.println(userNamePub.getText());
        //Thread.sleep(2000);
        //if (  Objects.equals(profilePage.getNameUserName(),profilePage.getNameUserNamePub()))
        //{
       //     System.out.println("User names match and equal " + profilePage.getNameUserName());
       // }
        //if (
        //        Objects.equals(userName.getText(),userNamePub.getText()));
        //{
        //    System.out.println("User names match and equal " +
        //            userName.getText());
       // }
       // Assert.assertEquals(profilePage.getNameUserName(),"@natalia46615563","Error: User names do not match");
        Assert.assertTrue(profilePage.getNameUserName().contains("natalia46615563")&&profilePage.getNameUserNamePub().equals("natalia46615563"));
    }

}
