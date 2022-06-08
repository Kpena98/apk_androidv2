package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

public class DriverManager {

    private static ThreadLocal<AndroidDriver<AndroidElement>> driver = new ThreadLocal<>();

    private static String url = System.getenv("URLBS");



    public static final String URL = "https://" + BrowserStackHelper.USERNAME + ":"
            + BrowserStackHelper.AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";



    public void iniciarWebDriver(String testName) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", "Samsung Galaxy S22");
        caps.setCapability("os_version", "12.0");

        caps.setCapability("browser_version", "latest");
        caps.setCapability("browserstack.local", "false");
        caps.setCapability("browserstack.selenium_version", "4.1.2");
        caps.setCapability("browserstack.networkProfile", "4g-lte-advanced-good");
        caps.setCapability("app", url); // APP subida desde bitrise
       // caps.setCapability("app", "bs://91f18527d0cfea333e985d7e9ea5ef0163286333"); // Quality App
        // caps.setCapability("app", "bs://e95b7d6a9d11c370435908131d0694dc7d727abf"); // Prod App 3.9
       // caps.setCapability("app", "bs://11c7ef13c1db0a4293e3114f60954df8cea3fce8");

        caps.setCapability("browserstack.idleTimeout", "300");


        //Nombre de ejecucion en dashboard de browserstack
        caps.setCapability("project", "Android Demo ");
        caps.setCapability("name", testName);
        caps.setCapability("build", "Android Pruebas Completas Delivery & Pickup Bitrise");
       // caps.setCapability("build", "Android Pruebas Completas Delivery & Pickup");
        //Configuracion para visualizacion de los logs.
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("browserstack.console", "verbose");
        caps.setCapability("browserstack.networkLogs", "true");

        try {
            Thread.sleep(1000);
        } catch(Exception e) {
            System.out.println("error");
        }
        driver.set(new AndroidDriver<>(new URL(URL), caps));
    }

    public static AndroidDriver<AndroidElement> getDriver() {
        return driver.get();
    }

    public static void cerrarDriver() {
        driver.get().quit();
    }
}
