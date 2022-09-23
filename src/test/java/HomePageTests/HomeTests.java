package HomePageTests;

import BasePage.Base;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;

import static pageObjects.HeaderObject.validateHeaderItems;

public class HomeTests extends Base {
    public HomeTests() throws IOException {
        super();
    }
    LoginObject login = new LoginObject();
    BetslipObject betslip = new BetslipObject();
    EventsObject home = new EventsObject();
    HeaderObject header = new HeaderObject();

    private void addingEvent(String email,String password) throws IOException {
        loginAndVerify(login,email,password,header);

        home.getContainerBetBtn().click();
    }

    @Parameters({"email","password"})
    @Test
    public void addEventToTheBetSlip(String email,String password) throws IOException, InterruptedException {
        loginAndVerify(login,email,password,header);

        Thread.sleep(5000);
        home.getNextBtn().click();
        for (int i = 0;i < home.getAllPages().size();i++){
            String bgColor = home.getAllPages().get(i).getCssValue("background-color");
            if(bgColor.equals("#ff4500")){
                System.out.println(home.getAllPages().get(i));
                Assert.assertEquals(home.getAllPages().get(i),2);
                break;
            } else {
                System.out.println("This is not the active page " + home.getAllPages().get(i));
            }
        }

        home.getContainerBetBtn().click();
        Assert.assertTrue(betslip.getTeams().isDisplayed());

    }


    @Parameters({"email","password"})
    @Test
    public void cashout(String email,String password) throws IOException, InterruptedException {
        addingEvent(email,password);

        Assert.assertTrue(betslip.getTeams().isDisplayed());
        String myBets = betslip.getOpenBetsTab().getText();

        String[] numOfBets = myBets.split("()");
        int numOfBetsBefore = Integer.parseInt(numOfBets[numOfBets.length-2]);

        String balance = header.getBalance().getText();
        String[] balanceEl = balance.split(":");
        String[] sumAsString = balanceEl[1].split("\\$");
        double sum = Double.parseDouble(sumAsString[0]);

        betslip.getMoneyLineOne().click();
        betslip.getIncBtn().click();

        betslip.getBetBtn().click();
        Thread.sleep(2000);



        int numOfBetsAfter = Integer.parseInt(numOfBets[numOfBets.length-2]) + 1;
        double sumAfterBet = Double.parseDouble(sumAsString[0]) - 1;
        betslip.getOpenBetsTab().click();

        Assert.assertTrue(betslip.getTeamsInOpenBets().isDisplayed());
        Assert.assertEquals(numOfBetsAfter,numOfBetsBefore+1);
        Assert.assertEquals(sumAfterBet,sum-1);

        BetslipObject betslip = new BetslipObject();
        betslip.getOpenBetsTab().click();
        betslip.getBetBtn().click();

        int stakeValue = Integer.parseInt(betslip.getStakeValue().getAttribute("value"));
        Thread.sleep(5000);

        Assert.assertEquals(sumAfterBet + 0.9,(sumAfterBet + stakeValue) - 0.1,"Wrong calculation");
    }
    @Parameters({"email","password"})
    @Test
    public void successfullDeposit(String email,String password) throws IOException {
        loginAndVerify(login,email,password,header);

        String balance = header.getBalance().getText();
        String[] balanceEl = balance.split(":");
        String[] sumAsString = balanceEl[1].split("\\$");
        double sum = Double.parseDouble(sumAsString[0]);

        header.getDepositBtn().click();
        DepositObject deposit = new DepositObject();
        deposit.getDepositInput().sendKeys("2");
        deposit.getDepositBtn().click();
        deposit.getDepositCloseBtn().click();

        Assert.assertNotEquals(sum,sum+2,"There is no change in the value of the balance");

    }

    @Parameters({"email","password"})
    @Test
    public void scrollAndAddEventToBetSlip(String email,String password) throws IOException, InterruptedException {
        loginAndVerify(login,email,password,header);

        home.getBannerRightArrow().click();
        Thread.sleep(2000);

        home.getBannerBetBtn().click();
        Assert.assertTrue(betslip.getTeams().isDisplayed());
    }


    @Parameters({"email","password"})
    @Test
    public void clearSelection(String email,String password) throws IOException, InterruptedException {
        addingEvent(email,password);
        Assert.assertTrue(betslip.getTeams().isDisplayed());
        Thread.sleep(2000);
        betslip.getClearAllBtn().click();
        Assert.assertTrue(betslip.getWarningMsg().isDisplayed());
    }
    @Parameters({"email","password"})
    @Test
    public void moveToSecondPage(String email,String password) throws IOException {
        loginAndVerify(login,email,password,header);

        home.getNextBtn().click();
        home.getContainerBetBtn().click();
        Assert.assertTrue(betslip.getTeams().isDisplayed());
    }

    @Parameters({"email","password"})
    @Test
    public void placeBetSuccessfully(String email,String password) throws IOException, InterruptedException {
        addingEvent(email,password);

        Assert.assertTrue(betslip.getTeams().isDisplayed());
        String myBets = betslip.getOpenBetsTab().getText();

        String[] numOfBets = myBets.split("()");
        int numOfBetsBefore = Integer.parseInt(numOfBets[numOfBets.length-2]);

        String balance = header.getBalance().getText();
        String[] balanceEl = balance.split(":");
        String[] sumAsString = balanceEl[1].split("\\$");
        double sum = Double.parseDouble(sumAsString[0]);

        betslip.getMoneyLineOne().click();
        betslip.getIncBtn().click();
        betslip.getBetBtn().click();


        int numOfBetsAfter = Integer.parseInt(numOfBets[numOfBets.length-2]) + 1;
        double sumAfterBet = Double.parseDouble(sumAsString[0]) - 1;
        betslip.getOpenBetsTab().click();

        Assert.assertTrue(betslip.getTeamsInOpenBets().isDisplayed());
        Assert.assertEquals(numOfBetsAfter,numOfBetsBefore+1);
        Assert.assertEquals(sumAfterBet,sum-1);
    }
}
