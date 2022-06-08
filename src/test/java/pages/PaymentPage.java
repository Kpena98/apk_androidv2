package pages;

import android.AndroidBase;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Helpers;
import utils.Logger;

public class PaymentPage extends AndroidBase {
    public PaymentPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    Helpers hp = new Helpers();

    public void paymentData(String direccion) {
        hp.sleep(5);
        try {
            typeId("firstNameText", "Prueba");
            typeId("lastNameText", "Prueba");
           // typeId("suffixText", "9 213 123 1234");
            typeId("suffixText", "9 2131 2124");
            // typeId("documentText", "981544670");
            typeId("documentText", "27321231-0");
            clickId("btConfirm");
        }
        catch (org.openqa.selenium.TimeoutException ex){
            Logger.error("No se encontro el pedido ");
        }
    }

    public void pay(String producto) {
        hp.sleep(10);
        click("//*[@class='android.widget.TextView' and @text='card']");
        clickId("btPay");
        try {
            if (findElement("//*[contains(@text, \"Get the most\")]").isDisplayed()) {
                clickId("tvSkip");
            }
            hp.sleep(15);
            toFrame("zWebView");
            type("//input[contains(@text, 'mero')]", "4111111111111111");
        }
        catch (org.openqa.selenium.TimeoutException ex){
        }

    }

}
