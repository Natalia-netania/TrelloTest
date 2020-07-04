package tests1;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;
import pages1.BoardsPageHelper1;
import pages1.LoginPageHelper1;
import pages1.ProfileVisabilityScreenHelper1;

public class ProfileVisabilityScreen1 extends TestBase1 {

    LoginPageHelper1 loginPage;
    BoardsPageHelper1 boardsPage;
    ProfileVisabilityScreenHelper1 profilePage;

    @BeforeMethod
    public void initTests() {

        //loginPage = new LoginPageHelper(driver);
       // boardsPage = new BoardsPageHelper(driver);
        loginPage = PageFactory.initElements(driver, LoginPageHelper1.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper1.class);
        //profilePage = new ProfileVisabilityScreenHelper(driver);
        profilePage = PageFactory.initElements(driver, ProfileVisabilityScreenHelper1.class);
        loginPage.openLoginPage();
        loginPage.loginAsAtlassian(LOGIN, PASSWORD);
        boardsPage.waitUntilPageIsLoaded();

        profilePage.waitUntilElementIsClickable();
        profilePage.clickMenuButton();
    }

    @Test
    public void comparisonLabelTextVerification() {
        profilePage.waitUntilElementIsVisible();
        profilePage.getNameButton();
        if(
                Objects.equals(profilePage.getNameButtonText(),profilePage.getNameButtonTitleText() )
        )
        {
            System.out.println("Profile labels match and equal " + profilePage.getNameButtonText());
        }
        Assert.assertEquals(profilePage.getNameButtonText(),"N","Error: Profile labels do not match");
    }

    @Test
    public void userNameVerification(){

        profilePage.waitUntilElementIsClickable1();
        profilePage.loadButtonUserName();
        profilePage.loadButtonUserNamePub();
        Assert.assertTrue(profilePage.getNameUserName().contains("natalia46615563")&&profilePage.getNameUserNamePub().equals("natalia46615563"));
    }

}
