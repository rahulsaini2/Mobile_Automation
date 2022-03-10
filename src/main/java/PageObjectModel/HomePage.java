package PageObjectModel;/**
 * Write Message.
 */

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

/**
 * @author rahul saini
 */
public class HomePage {

    private AppiumDriver<AndroidElement> driver;

    @AndroidFindBy(id = "login")
    private AndroidElement loginElement;

    public HomePage(AppiumDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickLogin() {
        loginElement.click();
    }


}
