package Base; /**
 * Write Message.
 */

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author rahul saini
 */
public class BaseLib extends AppiumServerLib{

   public AppiumDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        //location of the app
        ConfigReader configReader=new ConfigReader();
        File app = new File(System.getProperty("user.dir")+"\\app\\"+configReader.getApp());

        //To create an object of Desired Capabilities
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capability.setCapability(MobileCapabilityType.DEVICE_NAME, configReader.getDeviceName());
        capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, configReader.getPlateformVersion());
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, configReader.getPlateformName());
        capability.setCapability("app-package", "io.appium.android.apis");
        capability.setCapability("app-activity", ".ApiDemos");
        capability.setCapability("noRest", true);
        URL url = new URL(configReader.getUrl());
        driver = new AppiumDriver(url, capability);

        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        Thread.sleep(3000);
        System.out.println("App Launched");


    }

    @AfterTest
    public void close() {
        driver.quit();
    }

}
