package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProfileVisabilityScreenHelper extends PageBase{

    public  ProfileVisabilityScreenHelper(WebDriver driver){

        super(driver);
    }

    public void waitUntilElementIsClickable(){
        waitUntilElemetIsClickable(By.xpath("//button[@data-test-id='header-boards-menu-button']/span[2]"),40);
    }

    public void clickMenuButton(){
        WebElement menuButton = driver.findElement(By.xpath("//button[@data-test-id='header-member-menu-button']"));
        menuButton.click();
        driver.findElement(By.xpath("//a[@data-test-id='header-member-menu-profile']")).click();
    }

    public void getNameButton(){
        WebElement menuButton = driver.findElement(By.xpath("//button[@data-test-id='header-member-menu-button']"));
        System.out.println(driver.findElement(By.xpath("//span[@class='_24AWINHReYjNBf'][contains(text(),'N')]")).getText());
    }

    public String getNameButtonText(){
        WebElement boardIcon = driver.findElement(By
                .xpath("//button[@data-test-id='header-member-menu-button']"));
        return boardIcon.getText();
    }

    public void waitUntilElementIsVisible(){
        waitUntilElemetIsClickable(By.xpath("//button[@data-test-id='header-member-menu-button']"),40);
    }

    public String getNameButtonTitleText(){
        WebElement nameButtonTitle = driver.findElement(By.xpath("//span[@class='_24AWINHReYjNBf'][contains(text(),'N')]"));
        return nameButtonTitle.getText();
    }

    public void waitUntilElemetIsClickable1(){
        waitUntilElemetIsClickable(By.xpath("//a[@class='tabbed-pane-nav-item-button js-member-activity']"),50);
    }

    public  String getNameUserName(){
        WebElement userName = driver.findElement(By.xpath("//span[contains(text(),'@')]"));
        return userName.getText();
    }

    public String getNameUserNamePub(){
        WebElement userNamePub = driver.findElement(By.xpath("//input[@name='username']"));
        return userNamePub.getAttribute("value");
    }

    public void loadButtonUserName(){
        WebElement userName = driver.findElement(By.xpath("//span[contains(text(),'@')]"));
        System.out.println("userName= "+ userName.getText());
    }

    public void loadButtonUserNamePub(){
        WebElement userNamePub = driver.findElement(By.xpath("//input[@name='username']"));
        //System.out.println("userNamePub = " + userNamePub.getText());
        System.out.println("userNamePub = " + userNamePub.getAttribute("value"));
    }

}
