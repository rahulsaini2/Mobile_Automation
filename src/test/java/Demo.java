/**
 * Write Message.
 */

import Base.BaseLib;
import PageObjectModel.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * @author rahul saini
 */
public class Demo extends BaseLib {

    @Test
    public void test1() {

        LoginPage homePage = new LoginPage(driver);
        homePage.selectCountry();
        homePage.enterInYourName();
        homePage.tapOnLetsShop();
        homePage.tapOnAddToCart();
        homePage.tapOnAppBarCardBtn();
        homePage.tapOnVisitToWebsiteToCompletePurchaseBtn();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> contexts = driver.getContextHandles();
        for (String contextName : contexts) {
            System.out.println(contextName);
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Hello");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);

    }

}
