package pageObjects;

import BasePage.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class InfoObject extends Base {
    private WebDriver driver;
    public InfoObject() throws IOException {
        super();
    }
    By sport = By.xpath("//div[@class='info-section']/p");
    By league = By.xpath("//div[@class='info-section']/h1");
    By opponents = By.xpath("//div[@class='info-section']/h1[2]");
    By result = By.xpath("//div[@class='info-section']/p[2]");
    By closeBtn = By.xpath("//button[@class=close-btn]");

    public WebElement getSport(){
        this.driver = getDriver();
        return driver.findElement(sport);
    }
    public WebElement getLeague(){
        this.driver = getDriver();
        return driver.findElement(league);
    }
    public WebElement getOpponents(){
        this.driver = getDriver();
        return driver.findElement(opponents);
    }
    public WebElement getResult(){
        this.driver = getDriver();
        return driver.findElement(result);
    }
    public WebElement getCloseBtn(){
        this.driver = getDriver();
        return driver.findElement(closeBtn);
    }
}
