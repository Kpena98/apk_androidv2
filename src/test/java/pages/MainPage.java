package pages;

import android.AndroidBase;
import driver.DriverManager;
import exceptions.ElementoNoVisibleException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Helpers;
import utils.Logger;



public class MainPage extends AndroidBase {

    public MainPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    Helpers hp = new Helpers();

    public boolean comprobarLogin(){
        try {
            try {
                click("//*[@class='android.widget.TextView' and @text='" + hp.orders().get(0) + "']");
            }catch (org.openqa.selenium.TimeoutException ex){
                click("//*[@class='android.widget.TextView' and @text='" + hp.orders().get(1) + "']");
            }
            return false;
        }
        catch (org.openqa.selenium.TimeoutException ex){
            WebElement loginPage = findElement("//*[@class='android.widget.TextView' and @text='LOGIN']");
            return loginPage.isDisplayed();
        }

    }


    public void login(String user, String pass) {
        System.out.println("Login");
        try {
            typeId( "mail_input_text", user);
            typeId("password_input_text", pass);
            clickId("login_button_container");
            hp.sleep(30);
            for (int i = 0; i < 3; i++) {
                clickId("dialogAcceptButton");
            }
            try {
                click("//*[@class='android.widget.TextView' and @text='" + hp.orders().get(0) + "']");
            }catch (org.openqa.selenium.TimeoutException ex){
                click("//*[@class='android.widget.TextView' and @text='" + hp.orders().get(1) + "']");
            }
        }
        catch (org.openqa.selenium.TimeoutException ex){
           Logger.error("No se encontro el elemento mail_input_text");
        }

    }

    public void goToLogin(String user, String pass) {
        clickId("dialogAcceptButton");
        try {
            typeId( "mail_input_text", user);
            typeId("password_input_text", pass);
            clickId("login_button_container");
            hp.sleep(10);
            for (int i = 0; i < 3; i++) {
                clickId("dialogAcceptButton");
            }
        }
        catch (org.openqa.selenium.TimeoutException ex){
            Logger.error("No se encontro el elemento mail_input_text");
        }
    }

    public void goToPedidos() {
        try {
            click("//*[@class='android.widget.TextView' and @text='" + hp.orders().get(0) + "']");
        }catch (org.openqa.selenium.TimeoutException ex){
            click("//*[@class='android.widget.TextView' and @text='" + hp.orders().get(1) + "']");
        }
    }

    public void selectCountry(String string) throws ElementoNoVisibleException, InterruptedException {
        hp.sleep(10);
        try {
            click("//*[@class='android.widget.TextView' and @text='More']");
        }catch (org.openqa.selenium.TimeoutException ex){
            System.out.println("No se encontro el elemento More");
        }
        hp.sleep(2);
   //     click("//*[contains(@text, \"Rol\")]");
      /*  boolean foundConfig = scrollToTextAndClick(By.xpath("//*[@class='android.widget.TextView']"), "text", "Configuración");
        if (foundConfig) {
            click("//*[@class='android.widget.TextView' and @text='Configuración']");
            Logger.pass("Selecciono el pais " + "Configuración");
        }
        else {
            Logger.error("No se encontro Configuración");
        }*/
        clickId("img_country");
        try {
            click("//*[@class='android.widget.TextView' and @text='" + string + "']");
            Logger.pass("Selecciono el pais " + string);
        }
        catch (org.openqa.selenium.TimeoutException ex){
            boolean foundCountry = scrollToTextAndClick(By.xpath("//*[@class='android.widget.TextView']"), "text", string);
            if (foundCountry) {
                click("//*[@class='android.widget.TextView' and @text='" + string + "']");
                Logger.pass("Selecciono el pais " + string);
            }
            else {
                Logger.error("No se encontro el pais " + string);
            }
        }
    }

    public void comprobarPedidos() {
        try {
            clickId("dialogAcceptButton");
        }
        catch (org.openqa.selenium.TimeoutException ex){
            Logger.error("No se encontro el elemento mail_input_text");
        }
    }
}
