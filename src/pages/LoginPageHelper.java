package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.TestBase;

public class LoginPageHelper extends PageBase {
   // WebDriver driver;

    public  LoginPageHelper(WebDriver driver){

        super(driver);
    }

    public void openLoginPage()

    {
        WebElement loginButton = driver.findElement(By.linkText("Log In"));
        loginButton.click();
        waitUntilElemetIsClickable(By.id("login"), 20);
    }

    public void enterLoginAtlassianAndClicLogin(String login){
        driver.findElement(By.id("user")).sendKeys(login);
        waitUntilAttributeValuesIs(By.id("login"),"value","Log in with Atlassian",10);
        WebElement logButton = driver.findElement(By.id("login"));
        logButton.click();
        waitUntilElemetIsClickable(By.id("login-submit"),15);

    }
    public void enterPasswordAtlassionAndClickPassword(String password){
        driver.findElement(By.id("password")).sendKeys(password);
        WebElement enterButton = driver.findElement(By.id("login-submit"));
        enterButton.click();
    }

    //public void loginAsAtlassian(String login, String password){
     //   this.enterLoginAtlassianAndClickLogin(login);
    //    this.enterPasswordAtlassionAndClickLogin(password);
   // }

    public void enterLoginAtlassianAndClickLogin(String login) {
        driver.findElement(By.id("user")).sendKeys(login);
        waitUntilAttributeValueIs(By.
                id("login"),"value","Log in with Atlassian",10);
        driver.findElement(By.id("login")).click();

        waitUntilElementIsClickable(By.id("login-submit"),15);
    }

    public void enterPasswordAtlassionAndClickLogin(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-submit")).click();
    }

    public void loginAsAtlassian(String login, String password){
        this.enterLoginAtlassianAndClicLogin(login);
        this.enterPasswordAtlassionAndClickPassword(password);
    }


    public void pressLoginButton() {
        driver.findElement(By.id("login")).click();
    }

    public void waitErrorMessage() {
        waitUntilElementIsVisible(By.cssSelector("#error>p"),10);
    }

    public String getErrorMessage(){
        WebElement errorMessage = driver.findElement(By.cssSelector("#error>p"));
        return errorMessage.getText();
    }

    public  void enterLoginAndPassword(String login){
        driver.findElement(By.id("user")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys("123");
    }

    public void clickLoginButtonNormal() {
        driver.findElement(By.id("login")).click();
    }

    public void waitErrorMessageLoginIncorrect(){
        waitUntilElementIsVisible(By.xpath("(//*[@class= 'error-message'])[1]"),50);
        WebElement mist1Button = driver.findElement(By.xpath("(//*[@class= 'error-message'])[1]"));
        System.out.println("Error message: " + mist1Button.getText());
    }

    public String getErrorMessageloginIncorrect() {
        WebElement errorMessage = driver.findElement(By.xpath("(//*[@class= 'error-message'])[1]"));
        return errorMessage.getText();
    }

    public void waitLoginButtonIsClickable(){
        waitUntilElemetIsClickable(By.id("login"), 30);
    }

    public void waitErrorMessagePasswordIncorrect() {
        WebElement errorMessageIncorrectPassword;
        waitUntilElementIsVisible(By.xpath("//div[@id='login-error']/span"),15);
        System.out.println("Error message: " + driver.findElement(By.xpath("//div[@id='login-error']/span")).getText());
    }

    public String getIncorrectPassswordMessage(){
        WebElement errorMessageIncorrectPassword = driver.findElement(By.xpath("//div[@id='login-error']/span"));
        return errorMessageIncorrectPassword.getText();
    }
}
