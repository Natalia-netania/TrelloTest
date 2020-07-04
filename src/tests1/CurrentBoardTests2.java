package tests1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class CurrentBoardTests2 extends TestBase1 {

    //WebDriver driver;

    @BeforeMethod
    public void initTests() throws InterruptedException {
                    //--- Press log In menu button
        driver.findElement(By.linkText("Log In")).click();
        Thread.sleep(2000);

        //----Enter login value and click 'Log in' button ----
        driver.findElement(By.id("user")).sendKeys(LOGIN);
        Thread.sleep(1000);
        driver.findElement(By.id("login")).click();
        Thread.sleep(1000);

        //---- Enter password value and click 'Log in' button
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(10000);
        System.out.println(driver.findElement(By.xpath("//button[@data-test-id='header-boards-menu-button']/span[2]")).getText());

        /* --- Open 'QA Haifa56' */
        System.out.println(BOARD_TITLE);
        WebElement ourBoard = driver
                .findElement(By.xpath(boardLocator(BOARD_TITLE)));
        ourBoard.click();
        Thread.sleep(5000);
    }

    @Test
    public void createNewList() throws InterruptedException {
        //--- Add new list---
        List<WebElement> listLists = driver.
                findElements(By.xpath("//div[@class = 'list js-list-content']"));
        int beforeAdding = listLists.size();
        System.out.println("Lists before adding: " + beforeAdding);
        WebElement addListOption = driver.findElement(By.xpath("//span[@class='placeholder']"));
        addListOption.click();
        WebElement addTitleField = driver.findElement(By.xpath("//input[@placeholder='Ввести заголовок списка']"));

        //----Add title of the list
        addTitleField.click();
        addTitleField.sendKeys("Test");
        Thread.sleep(2000);

        //----Submit of adding list ----
        WebElement addListButton = driver.findElement(By.xpath("//input[@type='submit']"));
        addListButton.click();
        Thread.sleep(2000);

        //--- Cancel from edit mode ----
        WebElement cancelEdit = driver
                .findElement(By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel-edit']"));
        cancelEdit.click();
        Thread.sleep(2000);
        //--- Receive new list of Lists---
        listLists = driver.findElements(By.xpath("//div[@class = 'list js-list-content']"));
        int afterAdding = listLists.size();
        System.out.println("Lists after adding: " + listLists.size());

        Assert.assertEquals(afterAdding,beforeAdding+1,
                "The quantity of lists before adding new list is not the same as the quantity after adding");


    }
    @Test
    public void createNewCard() throws InterruptedException {
        Boolean existsList = false;
        System.out.println(driver.findElement(By.xpath("//a[@class='open-card-composer js-open-card-composer']")).getText());
        if (driver.findElement(By
                .xpath("//a[@class='open-card-composer js-open-card-composer']")).getText().contains("Добавить еще одну карточку")) {
            existsList = true;
        }
        //System.out.println(existsList);
        if (!existsList) {
            //--- Add new list---
            System.out.println("Lists before adding: " + driver.
                    findElements(By.xpath("//div[@class = 'list js-list-content']")).size());
            WebElement addListOption = driver.findElement(By.xpath("//span[@class='js-add-a-card']"));
            Thread.sleep(5000);
            addListOption.click();
            WebElement addTitleField = driver.findElement(By.xpath("//textarea[@placeholder='Ввести заголовок для этой карточки']"));
            Thread.sleep(5000);
            //----Add title of the list
            addTitleField.click();
            addTitleField.sendKeys("Cart1");
            Thread.sleep(2000);

            //----Submit of adding list ----
            WebElement addListButton = driver.findElement(By.xpath("//input[@type='submit']"));
            addListButton.click();
            Thread.sleep(2000);

            //--- Cancel from edit mode ----
            WebElement cancelEdit = driver
                .findElement(By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel']"));
            cancelEdit.click();
            Thread.sleep(2000);
            System.out.println("Lists after adding: " + driver.
                    findElements(By.xpath("//div[@class = 'list js-list-content']")).size());
        }

        else {
            //---Receive the quantity of cards ---
            int beforeAdding = driver.findElements(By.cssSelector("a.list-card")).size();

            //--- Define two possible buttons for adding new card and click on the displayed one---

            WebElement addAnotherCardButton = driver
                    .findElement(By.xpath("//span[@class='js-add-another-card']"));
                addAnotherCardButton.click();

            //--- Enter text, submit the card
            //WebElement textCurrentCard = driver.findElement(By.cssSelector("textarea.list-card-composer-textarea"));
            WebElement textCurrentCard = driver.findElement(By.xpath("//textarea[@placeholder='Ввести заголовок для этой карточки']"));
            textCurrentCard.click();
            textCurrentCard.sendKeys("test card");
            WebElement submitCardButton = driver.findElement(By.xpath("//input[@type='submit'][@value = 'Добавить карточку']"));
            submitCardButton.click();

            // ---- Cancel edit mode of the next card
            //WebElement cancelEditCardButton = driver.findElement(By.cssSelector("div.card-composer a.icon-close"));-it does not work for me
            WebElement cancelEditCardButton = driver.findElement(By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel']"));
            cancelEditCardButton.click();
            Thread.sleep(2000);
            //---Receive the quantity of cards ---
            System.out.println(driver.findElements(By.cssSelector("a.list-card")).size());
            int afterAdding = driver.findElements(By.cssSelector("a.list-card")).size();
            Assert.assertEquals(afterAdding,beforeAdding+1,
                    "The quantity of cards before adding new card is not the same as the quantity after adding");

        }
    }
    private String boardLocator(String boardTitle) {
        //System.out.println();
        return "//div[@title = '" + boardTitle + "']/../..";
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
