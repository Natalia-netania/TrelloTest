package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageBase1 {

    WebDriver driver;


    public PageBase1(WebDriver driver) {

        this.driver=driver;
    }


    public void waitUntilElemetIsClickable(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsClickable(WebElement element, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions
                    .elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsClickable(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions
                    .elementToBeClickable(locator));
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

    public void waitUntilAttributeValuesIs(WebElement element, String atribute, String value,int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.attributeToBe(element, atribute, value ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsVisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions
                    .visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsVisible(WebElement element, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions
                   .visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsNotVisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions
                    .invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilAllElementsAreVisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions
                    .visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilAllElementsAreVisible(List<WebElement> elementList, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions
                    .visibilityOfAllElements(elementList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilAttributeValueIs(By locator, String attribute, String value, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions
                    .attributeToBe(locator,attribute,value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
