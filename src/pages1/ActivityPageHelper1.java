package pages1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ActivityPageHelper1 extends PageBase1 {

@FindBy(xpath = "//div[@class='phenom-desc']")
List<WebElement> activityRecordsList;

    public ActivityPageHelper1(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded(){

        waitUntilAllElementsAreVisible(activityRecordsList,30);
    }

    public String getLastActivityText() {
        return activityRecordsList.get(0).getText();
    }
}