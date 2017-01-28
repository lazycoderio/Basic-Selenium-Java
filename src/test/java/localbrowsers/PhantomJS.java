package localbrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by andrew on 12/3/16.
 */
@Test(groups = {"mac", "windows"})
public class PhantomJS {
    private WebDriver driver;

    @BeforeTest
    public void phantomJSSetup(){
        //DesiredCapabilities capabilities = new DesiredCapabilities.phantomjs();
        driver = new PhantomJSDriver();
    }
    @Test
    public void test(){
        this.driver.get("http://lazycoder.io/about.html");
        Assert.assertEquals(driver.getTitle(), "Lazy Coder Origins");
    }

    @AfterTest
    public void testTeardown(){
        driver.quit();
    }
}
