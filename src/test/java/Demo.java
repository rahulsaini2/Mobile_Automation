/**
 * Write Message.
 */

import Base.BaseLib;
import PageObjectModel.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author rahul saini
 */
public class Demo extends BaseLib {

    @Test
    public void test1() {
        driver.findElement(By.id("android:id/text1")).click();

        String tx = driver.findElement(By.id("android:id/text1")).getText();
        Assert.assertEquals(tx, "Accessibility Node Provider");
//        androidDriver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));

//      appiumDriver.findElement(By.xpath("//tr[./th[.//*[text()=\"" + tx + "\"]]]/td//button[@name='picklist']"));

//        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(Text).instance(0))").click();

        HomePage homePage=new HomePage(driver);
        homePage.clickLogin();

        System.out.println(driver.findElement(By.name("Text")).getText());
    }

}
