package Base; /**
 * Write Message.
 */

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author rahul saini
 */
public class AppiumServerLib {

    public AppiumDriverLocalService service;

    public void startServer() {

        AppiumServiceBuilder builder;
        DesiredCapabilities cap;
//        AndroidDriver<AndroidElement> driver;

        cap = new DesiredCapabilities();
//        cap.setCapability("noReset", "false");

        builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(4720);
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error")
        .withAppiumJS(new File("C:\\Users\\rahul.saini2\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"));


        service = AppiumDriverLocalService.buildService(builder);
        // service.start();
        if (!checkIfServerIsRunnning(4720)){
            service.start();
            System.out.println("Appium server start");
            // service.stop();
        } else {
            System.out.println("Appium Server already running on Port");
        }


    }

    public boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public void stopServer() {
        service.stop();
        System.out.println("Appium is terminating");
    }

    @BeforeSuite
    public synchronized void setup() {
        startServer();
    }

    @AfterSuite
    public void cleanup() {
        stopServer();
    }

}
