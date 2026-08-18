package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.ServiciosScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PagarElRecibo implements Task{

    public static PagarElRecibo aceptandoLaConfirmacion(){
        return new PagarElRecibo();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ServiciosScreen.BOTON_PAGAR),
                WaitUntil.the(ServiciosScreen.BOTON_ACPETAR_DIALOGO, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(ServiciosScreen.BOTON_ACPETAR_DIALOGO)
        );
    }
}
