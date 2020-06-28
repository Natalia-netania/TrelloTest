package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePageHelper;

public class TestBase {

    WebDriver driver;
    public static final String BOARD_TITLE = "QA Haifa56";
    public static final String LOGIN = "serg_ya@yahoo.com";
    public static final String PASSWORD = "Leto2020zara";
    HomePageHelper homePage;

    @BeforeMethod
    public void initTestsSuit() throws InterruptedException {
        //---- Enter to the application ---
        driver = new ChromeDriver();
        driver.get("https://trello.com/");
        homePage = PageFactory.initElements(driver,HomePageHelper.class);
        homePage.waitUntilPageIsLoaded();
        waitUntilElemetIsClickable(By.linkText("Log In"),20);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public void waitUntilElemetIsVisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElemetIsClickable(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilAttributeValuesIs(By locator, String atribute, String value,int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.attributeToBe(locator, atribute, value ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
