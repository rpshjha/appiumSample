import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.lang.UsesSunMisc;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class SampleTest {
    public AppiumDriver driver;
    WebDriverWait wait;
    private static AppiumDriverLocalService service = null;
    private AppiumServiceBuilder builder = null;
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private AppiumDriverLocalService appiumService;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
        //String appiumServiceUrl = appiumService.getUrl().toString();
        capabilities.setCapability("noReset", "false");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "TestDevice");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 700000);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/VodQA.apk");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


    }

    @Test
    public void SampleTest() {
        wait = new WebDriverWait(driver, 30);
        wait.until(presenceOfElementLocated(MobileBy.AccessibilityId("login"))).click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
