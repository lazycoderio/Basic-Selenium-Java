package LocalBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by andrew on 12/3/16.
 */
public class PhantomJS {
    WebDriver driver;

    @BeforeTest
    public void phantomJSSetup(){
        //DesiredCapabilities capabilities = new DesiredCapabilities.phantomjs();
        PhantomJSDriver d = new PhantomJSDriver();
    }

    @Test(groups = {"mac", "windows"})
    public void test(){
        driver.get("http://lazycoder.io/about.html");
        Assert.assertEquals(driver.getTitle(), "About");
    }

    @AfterTest
    public void testTeardown(){
        driver.quit();
    }
}
