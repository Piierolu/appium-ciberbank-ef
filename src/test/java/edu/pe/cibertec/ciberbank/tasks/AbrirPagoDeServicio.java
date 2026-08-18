package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.DasboardScreen;
import edu.pe.cibertec.ciberbank.userinterface.ServiciosScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AbrirPagoDeServicio implements Task {

    public static AbrirPagoDeServicio desdeElDashboard() {
        return new AbrirPagoDeServicio();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DasboardScreen.BOTON_SERVICIOS),
                WaitUntil.the(ServiciosScreen.BOTON_CONSULTAR, isVisible()).forNoMoreThan(30).seconds()
        );
    }
}
