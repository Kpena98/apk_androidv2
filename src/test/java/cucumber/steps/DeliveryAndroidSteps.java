package cucumber.steps;

import exceptions.ElementoNoVisibleException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CountrySelectionPage;
import pages.MainPage;
import pages.OrdersPage;
import pages.PaymentPage;
import utils.Logger;

public class DeliveryAndroidSteps {

    private final CountrySelectionPage cs = new CountrySelectionPage();
    private final MainPage mp = new MainPage();
    private final OrdersPage op = new OrdersPage();
    private final PaymentPage pp = new PaymentPage();

    @Given("Seleccionar {string}")
    public void seleccionar(String string) throws ElementoNoVisibleException, InterruptedException {
        cs.selectCountry(string);
    }

    @And("Presionar boton Next luego de elegir {string}")
    public void presionarBotonNextLuegoDeElegir(String string) {
        cs.clickNext(string);
    }

    @When("Dentro del mercado de {string} acceder a pedidos y hacer login con {string} y {string} registrada")
    public void dentroDelMercadoDeAccederAPedidosYHacerLoginConYRegistrada(String pais, String user, String pass) throws ElementoNoVisibleException, InterruptedException {
        boolean loginAvaible = mp.comprobarLogin();
        if (loginAvaible) {
            mp.login(user, pass);
        }
        else {
            mp.goToLogin(user, pass);
        }
        mp.comprobarPolicy();

    }

    @Then("Iniciar orden tipo delivery indicar {string} y seleccionar {string}")
    public void iniciarOrdenTipoDeliveryYSeleccionar(String direccion, String producto) {
        op.comprobarBadLogin();
        op.typeOrder("McDelivery");
        op.initOrder(direccion);
        op.selectOrder(producto);
        pp.paymentData(direccion);
        pp.pay(producto);
        Logger.pass("Se selecciona el producto " + producto);
    }

    @Then("Iniciar orden tipo pickup indicar {string} y seleccionar {string}")
    public void iniciarOrdenTipoPickupYSeleccionar(String direccion, String producto) {
        op.comprobarBadLogin();
        op.typeOrder("Pickup");
        op.initOrderPickup(direccion);
        op.selectOrder(producto);
        pp.paymentData(direccion);
        pp.pay(producto);
        Logger.pass("Se selecciona el producto " + producto);
    }

}
