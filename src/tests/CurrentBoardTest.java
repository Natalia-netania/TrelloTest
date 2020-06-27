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
        //--- Press log In menu button
        //  driver.findElement(By.linkText("Log In")).click();
        // waitUntilElemetIsClickable(By.id("login"),20);

        //----Enter login value and click 'Log in' button ----
      /*  driver.findElement(By.id("user")).sendKeys(LOGIN);
        waitUntilAttributeValuesIs(By.id("login"),"value","Log in with Atlassian",10);
        driver.findElement(By.id("login")).click();
        waitUntilElemetIsClickable(By.id("login-submit"),15);

        //---- Enter password value and click 'Log in' button
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.id("login-submit")).click();
        waitUntilElemetIsClickable(By.xpath("//button[@data-test-id='header-boards-menu-button']/span[2]"),40);
        System.out.println(driver.findElement(By.xpath("//button[@data-test-id='header-boards-menu-button']/span[2]")).getText());

        /* --- Open 'QA Haifa56' */
      /*  System.out.println(BOARD_TITLE);
        WebElement ourBoard = driver
                .findElement(By.xpath(boardLocator(BOARD_TITLE)));
        ourBoard.click();
        waitUntilElemetIsVisible(By.xpath("span[contains(text(),'QA Haifa56')]"),10);
        waitUntilElemetIsClickable(By.xpath("//span[@class='placeholder'])"),10);*/
    }

    @Test
    public void createNewList() {

        int beforeAdding = qaHaifa56Page.getListsQuantity();
        System.out.println("Lists before adding: " + beforeAdding);
        qaHaifa56Page.createNewList("Test");

        int afterAdding = qaHaifa56Page.getListsQuantity();
        Assert.assertEquals(afterAdding, beforeAdding + 1,
                "The quantity of lists before adding new list is not the same as the quantity after adding");

        //--- Add new list---
        /*List<WebElement> listLists = driver.
                findElements(By.xpath("//div[@class = 'list js-list-content']"));
        int beforeAdding = listLists.size();
        System.out.println("Lists before adding: " + beforeAdding);
        WebElement addListOption = driver.findElement(By.xpath("//span[@class='placeholder']"));
        addListOption.click();
        waitUntilElemetIsVisible(By.xpath("//input[@placeholder='Ввести заголовок списка']"),10);
        WebElement addTitleField = driver.findElement(By.xpath("//input[@placeholder='Ввести заголовок списка']"));

        //----Add title of the list

        addTitleField.click();
        addTitleField.sendKeys("Test");
       waitUntilElemetIsClickable(By.xpath("//input[@type='submit']"),10);

        //----Submit of adding list ----
        WebElement addListButton = driver.findElement(By.xpath("//input[@type='submit']"));
        addListButton.click();

        //--- Cancel from edit mode ----
        WebElement cancelEdit = driver
                .findElement(By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel-edit']"));
        cancelEdit.click();

        //--- Receive new list of Lists---
        listLists = driver.findElements(By.xpath("//div[@class = 'list js-list-content']"));
        int afterAdding = listLists.size();
        System.out.println("Lists after adding: " + listLists.size());

        Assert.assertEquals(afterAdding,beforeAdding+1,
                "The quantity of lists before adding new list is not the same as the quantity after adding");
                */

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


       /* Boolean existsList = false;
        if (driver.findElement(By
                .xpath("//span[@class='placeholder']")).getText().contains("Добавьте еще одну колонку"))
        {
            existsList = true;
        }
        //System.out.println( existsList);
        if (!existsList) {
            //--- Add new list---
            System.out.println("Lists before adding: " + driver.
                    findElements(By.xpath("//div[@class = 'list js-list-content']")).size());
            WebElement addListOption = driver.findElement(By.xpath("//span[@class='placeholder']"));
            addListOption.click();
            //----Add title of the list
            WebElement addTitleField = driver.findElement(By.xpath("//input[@placeholder='Ввести заголовок списка']"));
            addTitleField.click();
            addTitleField.sendKeys("Test");

            waitUntilElemetIsClickable(By.xpath("//input[@type='submit']"),10);
            //----Submit of adding list ----
            WebElement addListButton = driver.findElement(By.xpath("//input[@type='submit']"));
            addListButton.click();


            //--- Cancel from edit mode ----
            WebElement cancelEdit = driver
                    .findElement(By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel-edit']"));
            cancelEdit.click();

            System.out.println("Lists after adding: " + driver.
                    findElements(By.xpath("//div[@class = 'list js-list-content']")).size());
        }

        //---Receive the quantity of cards ---
        int beforeAdding = driver.findElements(By.cssSelector("a.list-card")).size();

        //--- Define two possible buttons for adding new card and click on the displayed one---
        WebElement addCardButton = driver
                .findElement(By.cssSelector("span.js-add-a-card"));
        WebElement addAnotherCardButton = driver
                .findElement(By.cssSelector("span.js-add-another-card"));
        if (addCardButton.isDisplayed()) {
            addCardButton.click();
        }
        else addAnotherCardButton.click();

        //--- Enter text, submit the card
        WebElement textCurrentCard = driver.findElement(By.cssSelector("textarea.list-card-composer-textarea"));
        textCurrentCard.click();
        textCurrentCard.sendKeys("test card");
        WebElement submitCardButton = driver.findElement(By.xpath("//input[@type='submit'][@value = 'Добавить карточку']"));
        submitCardButton.click();

        // ---- Cancel edit mode of the next card
        WebElement cancelEditCardButton = driver.findElement(By.cssSelector("div.card-composer a.icon-close"));
        cancelEditCardButton.click();

        //---Receive the quantity of cards ---
        int afterAdding = driver.findElements(By.cssSelector("a.list-card")).size();
        Assert.assertEquals(afterAdding,beforeAdding+1,
                "The quantity of cards before adding new card is not the same as the quantity after adding");


    }

    private String boardLocator(String boardTitle) {
        return "//div[@title = '" + boardTitle + "']/../..";
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
*/
    }
}
