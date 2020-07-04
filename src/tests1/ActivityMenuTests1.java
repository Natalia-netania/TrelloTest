package tests1;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages1.*;

public class ActivityMenuTests1 extends TestBase1 {

    LoginPageHelper1 loginPage;
    BoardsPageHelper1 boardsPage;
    CurrentBoardHelper1 qaHaifa56Page;
    UpperMenuHelper1 upperMenuPage;
    ActivityPageHelper1 activityPage;

    @BeforeMethod
    public void initTests() {

        loginPage = PageFactory.initElements(driver, LoginPageHelper1.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper1.class);
        qaHaifa56Page = new CurrentBoardHelper1(driver, BOARD_TITLE);
        upperMenuPage = PageFactory.initElements(driver, UpperMenuHelper1.class);
        activityPage = PageFactory.initElements(driver, ActivityPageHelper1.class);

        loginPage.openLoginPage();
        loginPage.loginAsAtlassian(LOGIN, PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        qaHaifa56Page.openCurrentBoard();
        qaHaifa56Page.waitUntilPageIsLoaded();

    }

    @Test
    public void addingNewListEventInActivity(){
        String listTitle = "Activity new";
        //qaHaifa56Page.createNewList(listTitle);
        qaHaifa56Page.createNewList("Test");
        //upperMenuPage.openMenuPage();
       // upperMenuPage.waitUntilPageIsLoaded();
       // upperMenuPage.openActivityPage();
      //  activityPage.waitUntilPageIsLoaded();

      //  Assert.assertTrue(activityPage.getLastActivityText().contains ("added list " + listTitle+ "to"),
        //        "The text in the last activity record doesn't correspond to event adding new list" + listTitle);


    }


}
