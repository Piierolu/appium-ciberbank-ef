package edu.pe.cibertec.ciberbank.tasks;

import io.appium.java_client.HidesKeyboard;
import net.thucydides.core.webdriver.WebDriverFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

/**
 * Cierra el teclado virtual. Es necesario porque mientras el teclado esta abierto
 * el boton Ingresar queda fuera del arbol de vistas y Appium no puede localizarlo.
 */
public class OcultarTeclado implements Task {

    public static OcultarTeclado siEstaAbierto() {
        return new OcultarTeclado();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        if (driver instanceof WebDriverFacade) {
            driver = ((WebDriverFacade) driver).getProxiedDriver();
        }
        if (driver instanceof HidesKeyboard) {
            try {
                ((HidesKeyboard) driver).hideKeyboard();
            } catch (Exception elTecladoNoEstabaAbierto) {
                // Appium lanza excepcion si no hay teclado visible: no es un fallo de la prueba.
            }
        }
    }
}
