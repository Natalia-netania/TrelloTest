package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;

public class HomePageHelper extends PageBase {

    @FindBy(linkText = "Log In")
    WebElement logInIcon;

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded() {
       // waitUntilElemetIsClickable(By.linkText("Log In"),20);
        waitUntilElementIsClickable(logInIcon,20);
    }
}
