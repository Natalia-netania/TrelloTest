package pages1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpperMenuHelper1 extends PageBase1 {

    @FindBy (xpath = "//button[@data-test-id = 'headed-member-menu-button']")
    WebElement upperRight;

    @FindBy (xpath = "//a[@data-test-id = 'headed-member-menu-button']")
    WebElement profilevisabilityMenuItem;

    @FindBy(xpath = "(//span[contains(text(),'Действия')]/..)[2]")
    WebElement activityMenuItem;

    public UpperMenuHelper1(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(profilevisabilityMenuItem,20);
        waitUntilElementIsClickable(activityMenuItem,20);
    }

    public void openProfileVisabilityScreen(){
        profilevisabilityMenuItem.click();
    }

    public void openMenuPage(){
        waitUntilElementIsClickable(upperRight,20);
        upperRight.click();
    }

    public void openActivityPage() {
        activityMenuItem.click();
    }

}
