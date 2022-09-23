package pageObjects;

import BasePage.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class RegistrationObject extends Base {
    private WebDriver driver;
    public RegistrationObject() throws IOException {
       super();
    }
    By username = By.xpath("//form//input[@type='text']");
    By email = By.xpath("//form//input[@type='email']");
    By password = By.xpath("//form//input[@type='password']");
    By regFormBtn = By.xpath("//button[@class='form-btn']");
    By registrationErrMsg = By.xpath("//p[@class='error']");

    public WebElement getEmail(){
        this.driver = getDriver();
        return driver.findElement(email);
    }
    public WebElement getRegErrMsg(){
        this.driver = getDriver();
        return driver.findElement(registrationErrMsg);
    }
    public WebElement getUsername(){
        this.driver = getDriver();
        return driver.findElement(username);
    }
    public WebElement getPassword(){
        this.driver = getDriver();
        return driver.findElement(this.password);
    }
    public WebElement getRegFormBtnFormBtn(){
        this.driver = getDriver();
        return driver.findElement(regFormBtn);
    }

    public void goToRegistration() throws IOException {
        HeaderObject header = new HeaderObject();

        header.getRegisterBtn().click();
        String url = getDriver().getCurrentUrl();
        Assert.assertEquals(url,"https://betting-react-app.herokuapp.com/api/v1/auth/register","Expected " +
                "https://betting-react-app.herokuapp.com/api/v1/auth/register" + ",Actual " + url);
    }
}
