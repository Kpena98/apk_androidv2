package pages;

import android.AndroidBase;
import driver.DriverManager;
import org.openqa.selenium.support.PageFactory;
import utils.Helpers;
import utils.Logger;

public class OrdersPage extends AndroidBase {
    public OrdersPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    Helpers hp = new Helpers();

    public void initOrder() {
        hp.sleep(5);
        try {
            click("//*[@class='android.widget.Button' and @text='Start order']");
        }
        catch (org.openqa.selenium.TimeoutException ex){
            Logger.error("No se encontro el pedido ");
        }
    }

}
