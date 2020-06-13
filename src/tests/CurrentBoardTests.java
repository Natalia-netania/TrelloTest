package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CurrentBoardTests {

    WebDriver driver;

    @BeforeMethod
    public void initTests() throws InterruptedException {
        //---- Enter to the application ---
        driver = new ChromeDriver();
        driver.get("https://trello.com/");
        Thread.sleep(1000);
            //--- Press log In menu button
        driver.findElement(By.linkText("Log In")).click();
        Thread.sleep(5000);

        //----Enter login value and click 'Log in' button ----
        driver.findElement(By.id("user")).sendKeys("serg_ya@yahoo.com");
        Thread.sleep(1000);
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);

        //---- Enter password value and click 'Log in' button
        driver.findElement(By.id("password")).sendKeys("Leto2020zara");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(20000);
    }

    @Test
    public void createNewList() throws InterruptedException {
        WebElement createNewBoardButton = driver.findElement(By.xpath("//*[@class='board-tile mod-add']"));
        createNewBoardButton.click();
        Thread.sleep(1000);
       driver.findElement(By.xpath("//input[@placeholder='Добавить заголовок доски']")).sendKeys("Haifa1");
        WebElement createBoardButton = driver.findElement(By.xpath("//button[@data-test-id='create-board-submit-button']"));
        createBoardButton.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@placeholder='Ввести заголовок списка']")).sendKeys("List1");
        driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']")).click();
        Thread.sleep(5000);

    }
    @Test
    public void createNewCard() throws InterruptedException {
        driver.findElement(By.xpath("//body//div[@class='content-all-boards']//div//div[@class='boards-page-board-section mod-no-sidebar']//li[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[@class='js-add-a-card']")).click();
        Thread.sleep(5000);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}