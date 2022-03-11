package PageObjectModel;/**
 * Write Message.
 */

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utility.CommonMethod;

/**
 * @author rahul saini
 */
public class HomePage extends CommonMethod {

    private AppiumDriver<AndroidElement> driver;

    @AndroidFindBy(id = "android:id/text1")
    private AndroidElement accessibilityName;

    public HomePage(AppiumDriver<AndroidElement> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void tapOnAccessibility() {
        tap(accessibilityName);
    }


}
