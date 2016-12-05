import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by andrew on 12/3/16.
 */
public class LocalBrowsersSampleTest {
    WebDriver driver;

    @BeforeTest(groups = "firefox")
    public void firefoxSetup() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        FirefoxBinary ff = new FirefoxBinary(new File("/Applications/Firefox.app/Contents/MacOS/firefox-bin"));
        FirefoxProfile ffp = new FirefoxProfile();
        driver = new FirefoxDriver(ff, ffp, capabilities);
    }

    @BeforeTest(groups = "chrome")
    public void chromeSetup(){
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
    }

    @BeforeTest(groups = "safari")
    public void safariSetup(){
        DesiredCapabilities capabilities = DesiredCapabilities.safari();
        SafariOptions options = new SafariOptions();
        capabilities.setCapability(SafariOptions.CAPABILITY, options);
        driver = new SafariDriver(capabilities);
    }

    @Test(groups = {"firefox", "chrome", "safari"})
    public void test(){
        driver.get("http://lazycoder.io/about.html");
        Assert.assertEquals(driver.getTitle(), "About");
    }

    @AfterTest
    public void testTeardown(){
        driver.quit();
    }
}
