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
import pages.BoardsPageHelper;
import pages.CurrentBoardHelper;
import pages.LoginPageHelper;

public class CurrentBoardTest extends TestBase {

    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardHelper qaHaifa56Page;

    @BeforeMethod
    public void initTests() {

        loginPage = new LoginPageHelper(driver);
        boardsPage = new BoardsPageHelper(driver);
        qaHaifa56Page = new CurrentBoardHelper(driver, BOARD_TITLE);
        loginPage.openLoginPage();
        loginPage.loginAsAtlassian(LOGIN, PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        qaHaifa56Page.openCurrentBoard();
        qaHaifa56Page.waitUntilPageIsLoaded();
    }

    @Test
    public void createNewList() {

        int beforeAdding = qaHaifa56Page.getListsQuantity();
        System.out.println("Lists before adding: " + beforeAdding);
        qaHaifa56Page.createNewList("Test");

        int afterAdding = qaHaifa56Page.getListsQuantity();
        Assert.assertEquals(afterAdding, beforeAdding + 1,
                "The quantity of lists before adding new list is not the same as the quantity after adding");

    }

    @Test
    public void createNewCard() {

        if (!qaHaifa56Page.existsList()) qaHaifa56Page.createNewList("Test");

        int beforeAdding = qaHaifa56Page.receiveQuantityOfCards();
        qaHaifa56Page.pressAddCardButton();
        qaHaifa56Page.enterTextToCard("test card");
        qaHaifa56Page.submitAddingCard();
        qaHaifa56Page.cancelEditCardMode();

        int afterAdding = qaHaifa56Page.receiveQuantityOfCards();
        Assert.assertEquals(afterAdding, beforeAdding + 1,
                "The quantity of cards before adding new card is not the same as the quantity after adding");



    }

    private String boardLocator(String boardTitle) {
        return "//div[@title = '" + boardTitle + "']/../..";
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    }

