package LocalBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by andrew on 12/3/16.
 */
@Test(groups = {"mac", "windows"})
public class Chrome {
    WebDriver driver;

    @BeforeTest
    public void chromeSetup(){
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
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
