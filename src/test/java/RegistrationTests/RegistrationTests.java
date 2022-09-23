package RegistrationTests;

import BasePage.Base;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.RegistrationObject;

import java.io.IOException;

public class RegistrationTests extends Base {
    RegistrationObject reg = new RegistrationObject();

    public RegistrationTests() throws IOException {
        super();
    }
    @Parameters({"regUsername","regEmail","regPassword"})
    @Test
    public void registerNewUser(String regUsername,String regEmail,String regPassword) throws IOException {
       reg.goToRegistration();
        reg.getUsername().sendKeys(regUsername);
        reg.getEmail().sendKeys(regEmail);
        reg.getPassword().sendKeys(regPassword);
        reg.getRegFormBtnFormBtn().click();
    }

    @Parameters({"regEmail","regPassword"})
    @Test
    public void tryToRegisterUserWithoutUsername(String regEmail,String regPassword) throws IOException {
        reg.goToRegistration();
        reg.getEmail().sendKeys(regEmail);
        reg.getPassword().sendKeys(regPassword);
        reg.getRegFormBtnFormBtn().click();

        String error = reg.getRegErrMsg().getText();
        Assert.assertEquals(error,"Please provide credentials","Expected " +
                "Please provide credentials" + " Actual:" +error );
    }
    @Parameters({"regUsername","regPassword"})
    @Test
    public void tryToRegisterUserWithoutEmail(String regUsername,String regPassword) throws IOException {
        reg.goToRegistration();
        reg.getUsername().sendKeys(regUsername);
        reg.getPassword().sendKeys(regPassword);
        reg.getRegFormBtnFormBtn().click();

        String error = reg.getRegErrMsg().getText();
        Assert.assertEquals(error,"Please provide credentials","Expected " +
                "Please provide credentials" + " Actual:" +error );
    }
    @Parameters({"regUsername","regEmail"})
    @Test
    public void tryToRegisterUserWithoutPassword(String regEmail,String regUsername) throws IOException {
        reg.goToRegistration();
        reg.getUsername().sendKeys(regUsername);
        reg.getEmail().sendKeys(regEmail);
        reg.getRegFormBtnFormBtn().click();

        String error = reg.getRegErrMsg().getText();
        Assert.assertEquals(error,"Please provide credentials","Expected " +
                "Please provide credentials" + " Actual:" +error );
    }
    @Test
    public void tryToRegisterUserWithoutCredentials() throws IOException {
        reg.goToRegistration();
        reg.getRegFormBtnFormBtn().click();

        String error = reg.getRegErrMsg().getText();
        Assert.assertEquals(error,"Please provide credentials","Expected " +
                "Please provide credentials" + " Actual:" +error );
    }
}
