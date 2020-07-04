package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper1 extends PageBase1 {

    @FindBy(linkText = "Log In")
    WebElement logInIcon;

    @FindBy(id="login")
    WebElement loginButton;

    @FindBy(id="user")
    WebElement userField;

    @FindBy(id="login-submit")
    WebElement loinSubmitButton;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//div[@id='error']//p[@class='error-message']")
    //@FindBy(xpath = "(//*[@class= 'error-message'])[1]")
    WebElement noLoginError;
    ////div[@id='error']//p[@class='error-message']
    //(//*[@class= 'error-message'])[1]")


    @FindBy(xpath="(//*[@class= 'error-message'])[1]")
    WebElement loginError;

    @FindBy(css = "#error>p")
    WebElement noLoginNoPasswordError;

    @FindBy(xpath = "//div[@id='login-error']/span")
    WebElement noPasswordError;

    public LoginPageHelper1(WebDriver driver){

        super(driver);
    }

    public void openLoginPage()

    {
        //WebElement loginButton = driver.findElement(By.linkText("Log In"));
        //loginButton.click();
        logInIcon.click();
        //waitUntilElemetIsClickable(By.id("login"), 20);
        waitUntilElementIsClickable(loginButton, 10);
    }

    public void enterLoginAtlassianAndClicLogin(String login){
        //driver.findElement(By.id("user")).sendKeys(login);
        userField.sendKeys(login);
        waitUntilAttributeValuesIs(loginButton,"value","Log in with Atlassian",10);
        //WebElement logButton = driver.findElement(By.id("login"));
       // logButton.click();
        loginButton.click();
       // waitUntilElemetIsClickable(By.id("login-submit"),15);
        waitUntilElementIsClickable(loinSubmitButton,15);

    }
    public void enterPasswordAtlassionAndClickPassword(String password){
       // driver.findElement(By.id("password")).sendKeys(password);
        passwordField.sendKeys(password);
        loinSubmitButton.click();
        //WebElement enterButton = driver.findElement(By.id("login-submit"));
        //enterButton.click();
    }


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

    public void waitUntilFieldPasswordIsVisible(){
        //passwordField.waitUntilElementIsVisible
        waitUntilElementIsVisible(passwordField,30);
    }
    public void pressLoginButton() {

        //driver.findElement(By.id("login")).click();
        loginButton.click();
    }

    public void waitErrorMessage() {
        waitUntilElementIsVisible(By.cssSelector("#error>p"),10);
    }

    public String getErrorMessage(){
        WebElement errorMessage = driver.findElement(By.cssSelector("#error>p"));
        return errorMessage.getText();
    }

    public  void enterLoginAndPassword(String login){
        //driver.findElement(By.id("user")).sendKeys(login);
        userField.sendKeys(login);
        //passwordField.sendKeys("123");
        //driver.findElement(By.id("password")).sendKeys("123");
    }

    public void clickLoginButtonNormal() {
        driver.findElement(By.id("login")).click();
    }

    public void waitErrorMessageLoginIncorrect(){
      // waitUntilElementIsVisible(By.xpath("(//*[@class= 'error-message'])[1]"),50);
        //waitUntilElementIsVisible(loginError,50);
       waitUntilElementIsVisible(noLoginError,10);
      //  WebElement mist1Button = driver.findElement(By.xpath("(//*[@class= 'error-message'])[1]"));
        System.out.println("Error message1: " + noLoginError.getText());
       // System.out.println("Error message1: " + mist1Button.getText());
    }

    public String getErrorMessageloginIncorrect() {
        //WebElement errorMessage = driver.findElement(By.xpath("(//*[@class= 'error-message'])[1]"));
       // return errorMessage.getText();
        return noLoginError.getText();
    }

    public void waitLoginButtonIsClickable(){

        waitUntilElementIsClickable(loginButton,20);
        System.out.println("Login Button " + loginButton.getTagName());
        //waitUntilElementIsClickable(By.id("login"), 30);
    }

    public void waitErrorMessagePasswordIncorrect() {
        WebElement errorMessageIncorrectPassword;
        //waitUntilElementIsVisible(By.xpath("//div[@id='login-error']/span"),15);
        waitUntilElementIsVisible(noPasswordError,15);
        //System.out.println("Error message: " + driver.findElement(By.xpath("//div[@id='login-error']/span")).getText());
        System.out.println("Error message: " + noPasswordError.getText());
    }

    public String getIncorrectPassswordMessage(){
       // WebElement errorMessageIncorrectPassword = driver.findElement(By.xpath("//div[@id='login-error']/span"));
       // return errorMessageIncorrectPassword.getText();
        return noPasswordError.getText();
    }
}
