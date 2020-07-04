package pages1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageHelper1 extends PageBase1 {

    @FindBy(linkText = "Log In")
    WebElement logInIcon;

    public HomePageHelper1(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded() {
       // waitUntilElemetIsClickable(By.linkText("Log In"),20);
        waitUntilElementIsClickable(logInIcon,20);
    }
}
