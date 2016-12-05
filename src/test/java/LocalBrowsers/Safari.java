package LocalBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by andrew on 12/3/16.
 */
@Test//(groups = {"mac"})
public class Safari {
    WebDriver driver;

    @BeforeTest
    public void safariSetup(){
        DesiredCapabilities capabilities = DesiredCapabilities.safari();
        SafariOptions options = new SafariOptions();
        capabilities.setCapability(SafariOptions.CAPABILITY, options);
        driver = new SafariDriver(capabilities);
    }
    @Test
    public void test(){
        driver.get("http://lazycoder.io/about.html");
        Assert.assertEquals(driver.getTitle(), "About");
    }

    @AfterTest
    public void testTeardown(){
        driver.quit();
    }
}
