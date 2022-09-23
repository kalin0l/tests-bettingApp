package BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDriverInstance {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static WebDriver getDriver(){
        if(driver.get() == null){
           try {
                driver.set(createDriver());
           }catch (IOException e){
                e.printStackTrace();
           }
        }
        return driver.get();
    }
    private static WebDriver createDriver() throws IOException {
        WebDriver driver = null;
       Properties prop = new Properties();
        FileInputStream data = new FileInputStream(
                System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.resources"
        );
        prop.load(data);

        if(prop.getProperty("browser").equals("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;

    }

    protected static void cleanUpDriver(){
        driver.get().quit();
        driver.remove();
    }
}
