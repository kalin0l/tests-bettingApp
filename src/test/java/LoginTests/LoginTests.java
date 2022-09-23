package LoginTests;

import BasePage.Base;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.EventsObject;
import pageObjects.HeaderObject;
import pageObjects.LoginObject;
import java.io.IOException;

import static pageObjects.HeaderObject.validateHeaderItems;

@Listeners(resources.Listener.class)


public class LoginTests extends Base {

    HeaderObject header = new HeaderObject();
    LoginObject login = new LoginObject();



    public LoginTests() throws IOException {
        super();
    }



    @Test
    public void tryToLoginWithoutCredentials() throws IOException {
        login.goToLogin();
        login.getLoginFormBtn().click();
        String error = login.getLoginError().getText();
        Assert.assertEquals(error,"Please provide email and password","Expected " +
                "Please provide email and password" + " Actual:" +error );
    }
    @Parameters({"email","password"})
    @Test
    public void loginAndLogout(String email,String password) throws IOException {
        loginAndVerify(login,email,password,header);

        header.getLogoutBtn().click();
        Assert.assertTrue(header.getLoginBtn().isDisplayed());
    }
    @Parameters({"email","wrongPassword"})
    @Test
    public void tryToLoginWithInvalidPassword(String email,String wrongPassword) throws IOException {
        login.goToLogin();
        login.getEmail().sendKeys(email);
        login.getPassword().sendKeys(wrongPassword);
        login.getLoginFormBtn().click();
        String error = login.getLoginError().getText();
        Assert.assertEquals(error,"Invalid password","Expected " +
                "Invalid password" + " Actual:" +error );
    }
    @Parameters({"wrongEmail","wrongPassword"})
    @Test
    public void tryToLoginWithInvalidCredentials(String wrongEmail,String wrongPassword) throws IOException {
        login.goToLogin();
        login.getEmail().sendKeys(wrongEmail);
        login.getPassword().sendKeys(wrongPassword);
        login.getLoginFormBtn().click();
        String error = login.getLoginError().getText();

        Assert.assertEquals(error,"Invalid credentials","Expected " +
                "Invalid credentials" + " Actual:" +error );
    }
    @Parameters({"email","password"})
    @Test
    public void successfullLogin(String email,String password) throws IOException {
        loginAndVerify(login,email,password,header);
    }
}
