package pageObjects;

import BasePage.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class LoginObject extends Base {
    private WebDriver driver;
    public LoginObject() throws IOException {
        super();
    }

    By email = By.xpath("//form//input[@type='email']");
    By password = By.xpath("//form//input[@type='password']");
    By loginFormBtn = By.xpath("//button[@class='form-btn']");
    By registrationBtn = By.xpath("//button[@type='submit' and text()='Register']");
    By loginErrMsg = By.xpath("//p[@class='error']");

    public WebElement getEmail(){
        this.driver = getDriver();
        return driver.findElement(email);
    }
    public WebElement getLoginError(){
        this.driver = getDriver();
        return driver.findElement(loginErrMsg);
    }
    public WebElement getPassword(){
        this.driver = getDriver();
        return driver.findElement(password);
    }
    public WebElement getLoginFormBtn(){
        this.driver = getDriver();
        return driver.findElement(loginFormBtn);
    }
    public WebElement getRegistrationBtn(){
        this.driver = getDriver();
        return driver.findElement(registrationBtn);
    }

    public void goToLogin() throws IOException {
        HeaderObject header = new HeaderObject();
        header.getLoginBtn().click();
        String url = getDriver().getCurrentUrl();
        Assert.assertEquals(url,"https://betting-react-app.herokuapp.com/api/v1/auth/login","Expected " +
                "https://betting-react-app.herokuapp.com/api/v1/auth/login" + ",Actual " + url);
    }

}
