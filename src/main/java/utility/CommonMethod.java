package utility;/**
 * Write Message.
 */

import Base.BaseLib;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

/**
 * @author rahul saini
 */
public class CommonMethod {

    TouchAction action=null;
    private AppiumDriver<AndroidElement> driver;

    public CommonMethod(AppiumDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public void fluentWait(AndroidElement element) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(100))
                .pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void tap(AndroidElement element) {
        if (action == null) {
         action = new TouchAction(driver);
        }
        action.tap(new TapOptions().withElement(new ElementOption().withElement(element))).perform();


    }
}
