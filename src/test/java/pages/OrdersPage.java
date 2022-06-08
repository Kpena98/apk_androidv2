package pages;

import android.AndroidBase;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Helpers;
import utils.Logger;

public class OrdersPage extends AndroidBase {
    public OrdersPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    Helpers hp = new Helpers();

    public void comprobarBadLogin() {
        try {
            WebElement BadLogin = findElement("//*[@class='android.widget.TextView' and @text='McDonald's Q']");
            if (BadLogin.isDisplayed()) {
               click("//*[@class='android.widget.TextView' and @text='OK']");
            }
        }
        catch (org.openqa.selenium.TimeoutException ex){

        }
    }

    public void typeOrder(String string) {
        try {
            click("//*[@class='android.widget.TextView' and @text='" + string + "']");
        }
        catch (org.openqa.selenium.TimeoutException ex){
            Logger.error("No se encontro el elemento Pedidos");
        }
    }

    public void initOrder(String direccion) {
        hp.sleep(5);
        try {
            click("//*[@class='android.widget.Button' and @text='Start order']");
            try {
                if (findElement("//*[contains(@text, \"Where do we\")]").isDisplayed()) {
                    clickId("btn_accept_delivery");
                    clickId("dialogAcceptButton");
                }
            }
            catch (org.openqa.selenium.TimeoutException ex){

            }
            typeId("etx_search", direccion);
            click("//*[@class='android.widget.TextView' and @text='" + direccion + "']");
            clickId("btn_confirm_address");
        }
        catch (org.openqa.selenium.TimeoutException ex){
            Logger.error("No se encontro el pedido ");
        }
    }

    public void initOrderPickup(String direccion) {
        hp.sleep(5);
        try {
            click("//*[@class='android.widget.Button' and @text='Start order']");
            try {
                if (findElement("//*[contains(@text, \"Find your\")]").isDisplayed()) {
                clickId("btn_accept_delivery");
            }   }
            catch (org.openqa.selenium.TimeoutException ex){

            }
            try {
                if (findElement("//*[contains(@text, \"Get the most\")]").isDisplayed()) {
                    clickId("tvSkip");
                }
            }
            catch (org.openqa.selenium.TimeoutException ex){

            }
            clickId("dialogAcceptButton");
            hp.sleep(2);
            typeId("etx_search", direccion);
            clickId("cl_home_item_profile");
            clickId("btnAccept");
        }
        catch (org.openqa.selenium.TimeoutException ex){
            Logger.error("No se encontro el pedido ");
        }
    }

    public void selectOrder(String producto) {
        hp.sleep(10);
        try {
            boolean foundProd = scrollAndFind(By.xpath("//*[@class='android.widget.TextView']"), "text", producto);
            if (foundProd) {
                click("//*[contains(@text, '" + producto + "')]");
                Logger.pass("Selecciono el pais " + "Configuración");
            }
            else {
                Logger.error("No se encontro Configuración");
            }
            clickId("btAddProduct");
            clickId("btnCart");
            clickId("btPayMethod");
        } catch (org.openqa.selenium.TimeoutException ex) {
            Logger.error("No se encontro el elemento Pedidos");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
