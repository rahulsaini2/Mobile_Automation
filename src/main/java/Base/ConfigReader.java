package Base; /**
 * Write Message.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author rahul saini
 */
public class ConfigReader {
    Properties pro;

    public ConfigReader() {

        File src = new File("./config/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getAutomationName() {
        String Aname = pro.getProperty("Automation_name");
        return Aname;
    }

    public String getPlateformName() {
        String pname = pro.getProperty("Platform_name");
        return pname;
    }

    public String getPlateformVersion() {
        String pversion = pro.getProperty("Plateform_version");
        return pversion;
    }

    public String getDeviceName() {
        String dname = pro.getProperty("Device_name");
        return dname;
    }

    public String getApp() {
        String app = pro.getProperty("app");
        return app;
    }

    public String getUrl() {
        String url = pro.getProperty("url");
        return url;
    }
}
