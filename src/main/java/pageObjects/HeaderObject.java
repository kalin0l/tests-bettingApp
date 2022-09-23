package pageObjects;

import BasePage.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class HeaderObject extends Base {

    private WebDriver driver;

    By loginBtn = By.xpath("//div[@class='user-info']//button[contains(.,'Login')]");
    By logout = By.xpath("//div[@class='user-info']//button[contains(.,'Logout')]");
    By deposit = By.xpath("//div[@class='user-info']//button[contains(.,'Deposit')]");
    By registerBtn = By.xpath("//div[@class='user-info']//button[contains(.,'Register')]");
    By logo = By.xpath("//section[@class='header-buttons']//a");
    By name = By.xpath("//h4[contains(.,'Welcome')]");
    By balance = By.xpath("//p[contains(.,'Balance')]");


    public HeaderObject() throws IOException {
        super();
    }

    public WebElement getLoginBtn() {
        this.driver = getDriver();
        return driver.findElement(loginBtn);
    }

    public WebElement getRegisterBtn() {
        this.driver = getDriver();
        return driver.findElement(registerBtn);
    }

    public WebElement getLogoutBtn() {
        this.driver = getDriver();
        return driver.findElement(logout);
    }

    public WebElement getDepositBtn() {
        this.driver = getDriver();
        return driver.findElement(deposit);
    }

    public WebElement getLogo() {
        this.driver = getDriver();
        return driver.findElement(logo);
    }

    public WebElement getName() {
        this.driver = getDriver();
        return driver.findElement(name);
    }

    public WebElement getBalance() {
        this.driver = getDriver();
        return driver.findElement(balance);
    }

    public static void validateHeaderItems(HeaderObject header) throws IOException {

        Assert.assertTrue(header.getLogo().isDisplayed(),"There is no logo in the header");
        Assert.assertTrue(header.getName().isDisplayed(),"There is no username");
        Assert.assertTrue(header.getBalance().isDisplayed(),"There is no balance");
    }
}

