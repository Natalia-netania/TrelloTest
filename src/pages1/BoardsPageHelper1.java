package pages1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardsPageHelper1 extends PageBase1 {

    @FindBy(xpath = "//button[@data-test-id='header-boards-menu-button']/span[2]")
    WebElement boardIcon;

    @FindBy(xpath = "//button[@data-test-id = 'header-member-menu-button']")
    WebElement upperRight;

    public BoardsPageHelper1(WebDriver driver) {

        super(driver);
    }

    public void waitUntilPageIsLoaded(){

        waitUntilElementIsClickable(boardIcon, 40);
        waitUntilElementIsClickable(upperRight,20);
    }

    public String getButtonBoardsText(){
        return boardIcon.getText();
    }
}
