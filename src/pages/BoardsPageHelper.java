package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardsPageHelper extends PageBase{

    @FindBy(xpath = "//button[@data-test-id='header-boards-menu-button']/span[2]")
    WebElement boardIcon;

    public BoardsPageHelper(WebDriver driver) {

        super(driver);
    }

    public void waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(boardIcon, 40);
        //waitUntilElemetIsClickable(By.xpath("//button[@data-test-id='header-boards-menu-button']/span[2]"),40);
    }

    public String getButtonBoardsText(){
       // WebElement boardIcon = driver.findElement(By
             //   .xpath("//button[@data-test-id='header-boards-menu-button']/span[2]"));
        return boardIcon.getText();
    }
}
