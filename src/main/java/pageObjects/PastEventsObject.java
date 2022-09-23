package pageObjects;

import BasePage.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class PastEventsObject extends Base {
    private WebDriver driver;
    public PastEventsObject() throws IOException {
        super();
    }
    By activeSpan = By.xpath("//div[@class='past-events']");
    By infoBtn = By.xpath("//div[@class='link']");
    By eventContainer = By.xpath("//div[@class='events-container']");


    public WebElement getActiveSpan(){
        this.driver = getDriver();
        return driver.findElement(activeSpan);
    }
    public WebElement getInfoBtn(){
        this.driver = getDriver();
        return driver.findElement(infoBtn);
    }
    public WebElement getEventContainer(){
        this.driver = getDriver();
        return driver.findElement(eventContainer);
    }

}
