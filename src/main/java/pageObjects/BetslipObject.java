package pageObjects;

import BasePage.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class BetslipObject extends Base {
    private WebDriver driver;

    public BetslipObject() throws IOException {
        super();
    }

    By myBetSlipTab = By.xpath("//div[@class='tabs-container']/p[1]");
    By openBetsTab = By.xpath("//div[@class='tabs-container']/p[contains(.,'Open')]");
    By warningMsg = By.xpath("//div[@class='empty']");
    By incBtn = By.xpath("//button[@class='btn' and text()='+']");
    By decBtn = By.xpath("//button[@class='btn' and text()='-']");
    By stakeValue = By.xpath("//div[@class='betslip-btn']/input");
    By betBtn = By.xpath("//button[@class='bet-btn']");
    By clearAllBtn = By.xpath("//button[@class='clear-all-btn']");
    By teams = By.xpath("//div[@class='bet-container']/h3");
    By teamsInOpenBets = By.xpath("//div[@class='team-names']/h3");
    By moneLineOne = By.xpath("//div[@class='odd-btn-container']//button[1]");
    By moneLineX = By.xpath("//div[@class='odd-btn-container']//button[2]");
    By moneLineTwo = By.xpath("//div[@class='odd-btn-container']//button[3]");

    public WebElement getMyBetSlipTab() {
        this.driver = getDriver();
        return driver.findElement(myBetSlipTab);
    }
    public WebElement getTeams() {
        this.driver = getDriver();
        return driver.findElement(teams);
    }
    public WebElement getTeamsInOpenBets() {
        this.driver = getDriver();
        return driver.findElement(teamsInOpenBets);
    }
    public WebElement getOpenBetsTab() {
        this.driver = getDriver();
        return driver.findElement(openBetsTab);
    }
    public WebElement getWarningMsg() {
        this.driver = getDriver();
        return driver.findElement(warningMsg);
    }
    public WebElement getIncBtn() {
        this.driver = getDriver();
        return driver.findElement(incBtn);
    }
    public WebElement getDecBtn() {
        this.driver = getDriver();
        return driver.findElement(decBtn);
    }
    public WebElement getStakeValue() {
        this.driver = getDriver();
        return driver.findElement(stakeValue);
    }
    public WebElement getBetBtn() {
        this.driver = getDriver();
        return driver.findElement(betBtn);
    }
    public WebElement getClearAllBtn() {
        this.driver = getDriver();
        return driver.findElement(clearAllBtn);
    }
    public WebElement getMoneyLineOne() {
        this.driver = getDriver();
        return driver.findElement(moneLineOne);
    }
    public WebElement getMoneyLineX() {
        this.driver = getDriver();
        return driver.findElement(moneLineX);
    }
    public WebElement getMoneyLineTwo() {
        this.driver = getDriver();
        return driver.findElement(moneLineTwo);
    }


}
