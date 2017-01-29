package localbrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by andrew on 12/3/16.
 */
@Test(groups = {"mac", "windows"})
public class Firefox {
    private WebDriver driver;

    @BeforeTest
    public void firefoxSetup() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        // mac requires the binary location to be set for firefox, not sure why at time of update
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            FirefoxBinary ff = new FirefoxBinary(new File("/Applications/Firefox.app/Contents/MacOS/firefox-bin"));
            FirefoxProfile ffp = new FirefoxProfile();
            driver = new FirefoxDriver(ff, ffp, capabilities);
        } else {
            driver = new FirefoxDriver();
        }
    }

    @Test
    public void test() {
        driver.get("http://lazycoder.io/about.html");
        Assert.assertEquals(driver.getTitle(), "Lazy Coder Origins");
    }

    @AfterTest
    public void testTeardown() {
        driver.quit();
    }
}
