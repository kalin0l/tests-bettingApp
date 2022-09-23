package pageObjects;

import BasePage.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class EventsObject extends Base {
    private WebDriver driver;
    public EventsObject() throws IOException {
        super();
    }

    By bannerBetBtn = By.xpath("//div[@class='btn-container']/button[1]");
    By bannerRightArrow = By.xpath("//*[@class='arrow-right']");
    By bannerLeftArrow = By.xpath("//*[@class='arrow-left']");
    By clubsOrPlayersName = By.xpath("//*[@class='home-away-container']/h4[1]");
    By leagueName = By.xpath("//*[@class='date-country-container'][1]");
    By events = By.xpath("//div[@class='events-container']");
    By containerBetBtn = By.xpath("//div[@class='link']");
    By prevBtn = By.xpath("//button[@class='prev-btn']");
    By nextBtn = By.xpath("//button[@class='next-btn']");
    By activePage = By.xpath("//button[@class='activePage']");
    By allPages = By.xpath("//button[@class='null']");
    By pastEventsTab = By.xpath("//div[@class='sports-tabs']/button[contains(.,'Past')]");
    By liveEventsTab = By.xpath("//div[@class='sports-tabs']/button[contains(.,'Live')]");
    By eventContainer = By.xpath("//div[@class='events-container']");
    By activeSpan = By.xpath("//div[@class='sports-tabs']/span");
    By paginationPages = By.xpath("//button[@class='null']");

    public WebElement getBannerBetBtn() {
        this.driver = getDriver();
        return driver.findElement(bannerBetBtn);
    }
    public WebElement getBannerRightArrow() {
        this.driver = getDriver();
        return driver.findElement(bannerRightArrow);
    }
    public WebElement getBannerLeftArrow() {
        this.driver = getDriver();
        return driver.findElement(bannerLeftArrow);
    }
    public WebElement getClubsOrPlayersName() {
        this.driver = getDriver();
        return driver.findElement(clubsOrPlayersName);
    }
    public WebElement getLeagueName() {
        this.driver = getDriver();
        return driver.findElement(leagueName);
    }
    public WebElement getEvents() {
        this.driver = getDriver();
        return driver.findElement(events);
    }
    public WebElement getContainerBetBtn() {
        this.driver = getDriver();
        return driver.findElement(containerBetBtn);
    }
    public WebElement getPrevBtn() {
        this.driver = getDriver();
        return driver.findElement(prevBtn);
    }
    public WebElement getActivePage() {
        this.driver = getDriver();
        return driver.findElement(activePage);
    }
    public List<WebElement> getAllPages() {
        this.driver = getDriver();
        return driver.findElements(allPages);
    }
    public WebElement getPastEventsTab() {
        this.driver = getDriver();
        return driver.findElement(pastEventsTab);
    }
    public WebElement getLiveEventsTab() {
        this.driver = getDriver();
        return driver.findElement(liveEventsTab);
    }
    public WebElement getNextBtn() {
        this.driver = getDriver();
        return driver.findElement(nextBtn);
    }
    public WebElement getEventContainer() {
        this.driver = getDriver();
        return driver.findElement(eventContainer);
    }
    public List getEventContainers() {
        this.driver = getDriver();
        return driver.findElements(eventContainer);
    }
    public WebElement getActiveSpan() {
        this.driver = getDriver();
        return driver.findElement(activeSpan);
    }
    public List getPaginationPages() {
        this.driver = getDriver();
        return driver.findElements(paginationPages);
    }

}
