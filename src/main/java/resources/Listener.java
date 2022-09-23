package resources;

import BasePage.Base;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listener extends Base implements ITestListener {
    public Listener() throws IOException {
        super();
    }
    public void onTestFailure(ITestResult result) {
        try {
            takeScreenShots(result.getName());
        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
