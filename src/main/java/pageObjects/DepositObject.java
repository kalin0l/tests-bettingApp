package pageObjects;

import BasePage.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class DepositObject extends Base {
    private WebDriver driver;
    public DepositObject() throws IOException {
        super();
    }

    By depositInput = By.xpath("//div[@class='deposit']//input");
    By depositBtn = By.xpath("//div[@class='deposit-btn-container']/button[@class='deposit-btn']");
    By depositCloseBtn = By.xpath("//button[@class='close-deposit-btn']");

    public WebElement getDepositInput(){
        this.driver = getDriver();
        return driver.findElement(depositInput);
    }
    public WebElement getDepositBtn(){
        this.driver = getDriver();
        return driver.findElement(depositBtn);
    }
    public WebElement getDepositCloseBtn(){
        this.driver = getDriver();
        return driver.findElement(depositCloseBtn);
    }
}
