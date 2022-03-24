package PageObjectModel;/**
 * Write Message.
 */

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utility.CommonMethod;

import java.util.List;

/**
 * @author rahul saini
 */
public class LoginPage extends CommonMethod {

    private AppiumDriver<AndroidElement> driver;

    @AndroidFindBy(id = "android:id/text1")
    private AndroidElement countryDropdown;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private AndroidElement yourNameTxtBx;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private AndroidElement letsShopBtn;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
    private List<AndroidElement> addToCartLink;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private AndroidElement appBarCardBtn;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private AndroidElement visitToWebsiteToCompletePurchaseBtn;

    public LoginPage(AppiumDriver<AndroidElement> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectCountry() {

        tap(countryDropdown);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tap(driver.findElement(By.xpath("//android.widget.TextView[@text='Afghanistan']")));
    }

    public void enterInYourName() {
        yourNameTxtBx.sendKeys("Testing");
    }

    public void tapOnLetsShop() {
        tap(letsShopBtn);
    }

    public void tapOnAddToCart() {
        tap(addToCartLink.get(0));
    }

    public void tapOnAppBarCardBtn() {
        tap(appBarCardBtn);
    }

    public void tapOnVisitToWebsiteToCompletePurchaseBtn() {
        tap(visitToWebsiteToCompletePurchaseBtn);
    }
}
