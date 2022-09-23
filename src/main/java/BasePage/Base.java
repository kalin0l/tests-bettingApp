package BasePage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.HeaderObject;
import pageObjects.LoginObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import static pageObjects.HeaderObject.validateHeaderItems;

public class Base extends WebDriverInstance  {

    private String url;

    private Properties prop;

    public Base () throws IOException {
        prop = new Properties();
        FileInputStream data = new FileInputStream(
                System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.resources"
        );
        prop.load(data);

    }
    protected static WebDriver getDriver(){
        return WebDriverInstance.getDriver();
    }

    private String getUrl(){
        url = prop.getProperty("url");
        return url;
    }

    protected void takeScreenShots(String name) throws IOException {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("C:\\Users\\user\\Desktop\\WORK\\Java\\InteliJava\\Betting-react-app\\src\\main\\java\\screenshots\\" + timeStamp() + ".png");

        FileUtils.copyFile(srcFile,destinationFile);
    }

    private String timeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    protected static void wait4ElVisible(WebElement el, Duration timer){
        WebDriverWait wait = new WebDriverWait(getDriver(),timer);
        wait.until(ExpectedConditions.invisibilityOf(el));
    }
    protected void loginAndVerify(LoginObject login, String email, String password, HeaderObject header) throws IOException {
        login.goToLogin();
        login.getEmail().sendKeys(email);
        login.getPassword().sendKeys(password);
        login.getLoginFormBtn().click();
        validateHeaderItems(header);
    }
    @BeforeTest
    protected void setup(){
        getDriver().get(getUrl());
    }

    @AfterTest
    protected void tearDown(){
        WebDriverInstance.cleanUpDriver();
    }


}
