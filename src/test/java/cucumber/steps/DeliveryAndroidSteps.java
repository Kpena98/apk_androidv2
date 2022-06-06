package cucumber.steps;

import exceptions.ElementoNoVisibleException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CountrySelectionPage;
import pages.MainPage;
import pages.OrdersPage;

public class DeliveryAndroidSteps {

    private final CountrySelectionPage cs = new CountrySelectionPage();
    private final MainPage mp = new MainPage();
    private final OrdersPage op = new OrdersPage();

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
    /* mp.selectCountry(pais);
        mp.goToPedidos();
        mp.comprobarPedidos();*/
    }

    @Then("Iniciar orden tipo delivery y seleccionar {string}")
    public void iniciarOrdenTipoDeliveryYSeleccionar(String string) {
        op.initOrder();
    }

}
