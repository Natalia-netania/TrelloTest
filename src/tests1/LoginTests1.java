package tests1;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages1.BoardsPageHelper1;
import pages1.LoginPageHelper1;

public class LoginTests1 extends TestBase1 {
    LoginPageHelper1 loginPage;
    BoardsPageHelper1 boardsPage;

    @BeforeMethod
    public void initTests(){

        loginPage = PageFactory.initElements(driver, LoginPageHelper1.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper1.class);
        loginPage.openLoginPage();
    }
        @Test
        public void loginTestPositive()  {

           // loginPage.openLoginPage();
            loginPage.enterLoginAtlassianAndClicLogin(LOGIN);
            loginPage.enterPasswordAtlassionAndClickPassword(PASSWORD);
            boardsPage.waitUntilPageIsLoaded();
            Assert.assertEquals(boardsPage.getButtonBoardsText(),"Доски","Text on the boardIcon is not 'Доски'");

        }

    @Test
        public void loginTestNegative1() throws InterruptedException {

        //loginPage.openLoginPage();
        loginPage.enterLoginAndPassword("1a@yahoo.com");
        Thread.sleep(2000);
         //loginPage.waitLoginButtonIsClickable();
        loginPage.pressLoginButton();
        loginPage.waitErrorMessageLoginIncorrect();
          Assert.assertEquals(loginPage.getErrorMessageloginIncorrect(), "There isn't an account for this email",
                "Error message is not correct");
        }

        @Test
        public void loginTestNegative2() {
           //  loginPage.openLoginPage();
             loginPage.loginAsAtlassian(LOGIN,"123");
             loginPage.waitLoginButtonIsClickable();
            loginPage.waitErrorMessagePasswordIncorrect();
            Assert.assertTrue(loginPage.getIncorrectPassswordMessage().contains("Incorrect email address and / or password."),
                    "There is no error message or the text of the message is not correct");
        }
    }
