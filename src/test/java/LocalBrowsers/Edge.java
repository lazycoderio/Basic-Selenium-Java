package LocalBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by andrew on 12/3/16.
 */
public class Edge {
    WebDriver driver;

    @BeforeClass
    public void edgeSetup(){
        DesiredCapabilities capabilities = DesiredCapabilities.edge();
        EdgeOptions options = new EdgeOptions();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new EdgeDriver(capabilities);
    }
    @Test(groups = {"windows"})
    public void test(){
        driver.get("http://lazycoder.io/about.html");
        Assert.assertEquals(driver.getTitle(), "About");
    }

    @AfterTest
    public void testTeardown(){
        driver.quit();
    }
}
