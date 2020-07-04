package tests1;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages1.BoardsPageHelper1;
import pages1.CurrentBoardHelper1;
import pages1.LoginPageHelper1;

public class CurrentBoardTest1 extends TestBase1 {

    LoginPageHelper1 loginPage;
    BoardsPageHelper1 boardsPage;
    CurrentBoardHelper1 qaHaifa56Page;

    @BeforeMethod
    public void initTests() {

        loginPage = PageFactory.initElements(driver, LoginPageHelper1.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper1.class);
        qaHaifa56Page = new CurrentBoardHelper1(driver, BOARD_TITLE);
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

