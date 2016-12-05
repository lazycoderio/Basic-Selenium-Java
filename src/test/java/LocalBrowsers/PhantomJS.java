package LocalBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by andrew on 12/3/16.
 */
@Test(groups = {"mac", "windows"})
public class PhantomJS {
    WebDriver driver;

    @BeforeTest
    public void phantomJSSetup(){
        //DesiredCapabilities capabilities = new DesiredCapabilities.phantomjs();
        driver = new PhantomJSDriver();
    }
    @Test
    public void test(){
        this.driver.get("http://lazycoder.io/about.html");
        Assert.assertEquals(driver.getTitle(), "About");
    }

    @AfterTest
    public void testTeardown(){
        driver.quit();
    }
}
