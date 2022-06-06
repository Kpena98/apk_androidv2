package android;

import driver.DriverManager;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Helpers;

import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;
@SuppressWarnings("unchecked")
public class AndroidBase {
    AndroidDriver<AndroidElement> driver = DriverManager.getDriver();

    TouchAction touchAction = new TouchAction(driver);

    Helpers hp = new Helpers();

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public void click(String xpath) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        element.click();
    }

    public void clickId(String id) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        element.click();
    }
    public void tap(String xpath) {
        WebElement el = findElement(xpath);
        touchAction.tap((TapOptions) el).perform();
    }
    public WebElement findElement(String xpath) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void  type (String xpath, String text) {
       WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
       element.sendKeys(text);

    }

    public void  typeId (String id, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        element.sendKeys(text);
    }



    public void scroll(AndroidDriver driver, double startXd, double startYd, double endXd, double endYd) throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * startXd);
        int startY = (int) (size.height * startYd);
        int endX = (int) (size.width * endXd);
        int endY = (int) (size.height * endYd);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(waitOptions(ofMillis(1500)))
                .moveTo(PointOption.point(endX, endY)).release().perform();
        hp.sleep(2);

    }


    public boolean  scrollToTextAndClick(By by, String attribute, String text) throws InterruptedException {
        int i = 0;
        boolean flag = false;
        do {
            List<AndroidElement> elements = driver.findElements(by);
            for (AndroidElement element : elements) {
                hp.sleep(1);
                if (element.getAttribute(attribute).equals(text)) {
                    flag = true;
                    break;
                }
            }
            scroll(driver, 0.5, 0.5, 0.5, 0.25);
            i++;
        }
        while (i <= 8 && !flag);
        return flag;
    }
}
