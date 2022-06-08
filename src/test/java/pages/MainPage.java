package pages;

import android.AndroidBase;
import driver.DriverManager;
import exceptions.ElementoNoVisibleException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
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

    public void comprobarPolicy(){
        try {
            if(findElement("//*[@class='android.widget.TextView' and @text='New privacy policy']").isDisplayed()){
                clickId("dialog_rate_skip_button");
            }
        }
        catch (org.openqa.selenium.TimeoutException ex){

        }
    }


    public void login(String user, String pass) {
        System.out.println("Login");
        try {
            typeId( "mail_input_text", user);
            typeId("password_input_text", pass);
            clickId("login_button_container");
            hp.sleep(30);
            if (comprobarFav()){
                chooseYourFav();
            }
            for (int i = 0; i < 3; i++) {
                clickId("dialogAcceptButton");
            }
            goToPedidos();
        }
        catch (org.openqa.selenium.TimeoutException ex){
           Logger.error("No se encontro el elemento mail_input_text");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void goToLogin(String user, String pass) {
        clickId("dialogAcceptButton");
        try {
            typeId( "mail_input_text", user);
            typeId("password_input_text", pass);
            clickId("login_button_container");
            hp.sleep(10);
            if (comprobarFav()){
                chooseYourFav();
                goToPedidos();
            }
            for (int i = 0; i < 3; i++) {
                clickId("dialogAcceptButton");
            }
            goToPedidos();
        }
        catch (org.openqa.selenium.TimeoutException ex){
            Logger.error("No se encontro el elemento mail_input_text");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean comprobarFav(){
        try {
            click("//*[@class='android.widget.TextView' and @text='Choose your favorites']");
            return true;
        }
        catch (org.openqa.selenium.TimeoutException ex){
            return false;
        }
    }

    public void chooseYourFav () throws InterruptedException {
        hp.sleep(2);
        try {
            for (int i = 0; i < 3; i++) {
                boolean foundFav = scrollAndFind(By.xpath("//*[@class='android.widget.TextView']"), "text", hp.favs().get(i));
                if (foundFav) {
                    click("//*[contains(@text, '" + hp.favs().get(i) + "')]");
                } else {
                    Logger.error("No se encontro el fav" + hp.favs().get(i));
                }
            }
            hp.sleep(2);
            clickId("btn_accept");
        } catch (TimeoutException ex){
            Logger.error("No se encontro el elemento");
        }
    }

    public void goToPedidos() {
        try {
            click("//*[@class='android.widget.TextView' and @text='" + hp.orders().get(0) + "']");
        }catch (TimeoutException ex){
            click("//*[@class='android.widget.TextView' and @text='" + hp.orders().get(1) + "']");
        }
    }

    public void selectCountry(String string) throws ElementoNoVisibleException, InterruptedException {
        hp.sleep(10);
        try {
            click("//*[@class='android.widget.TextView' and @text='More']");
        }catch (TimeoutException ex){
            System.out.println("No se encontro el elemento More");
        }
        hp.sleep(2);
        boolean foundConfig = scrollAndFind(By.xpath("//*[@class='android.widget.TextView']"), "text", "Conf");
        if (foundConfig) {
            click("//*[contains(@text, \"Config\")]");
            Logger.pass("Selecciono el pais " + "Configuración");
        }
        else {
            Logger.error("No se encontro Configuración");
        }
        clickId("img_country");
        try {
            click("//*[@class='android.widget.TextView' and @text='" + string + "']");
            Logger.pass("Selecciono el pais " + string);
        }
        catch (TimeoutException ex){
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

    public void clickNext(String string)  {
        try {
            click("//*[@class='android.widget.TextView' and @text='NEXT']");
            Logger.pass("Entrando al mercado de " + string);
        } catch (NoSuchElementException ex) {
            Logger.error("No se pudo presionar el botón Next ");
        }
    }

    public void comprobarPedidos() {
        try {
            clickId("dialogAcceptButton");
        }
        catch (TimeoutException ex){
            Logger.error("No se encontro el elemento mail_input_text");
        }
    }
}
