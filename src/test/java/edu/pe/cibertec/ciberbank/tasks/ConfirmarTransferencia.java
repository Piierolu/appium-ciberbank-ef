package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.ConfirmacionScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConfirmarTransferencia implements Task {

    public static ConfirmarTransferencia aceptandoElDialogo() {
        return new ConfirmarTransferencia();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ConfirmacionScreen.CONFIRMAR, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(ConfirmacionScreen.CONFIRMAR),
                WaitUntil.the(ConfirmacionScreen.ACEPTAR_DIALOGO, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ConfirmacionScreen.ACEPTAR_DIALOGO),
                WaitUntil.the(ConfirmacionScreen.NUMERO_OPERACION, isVisible()).forNoMoreThan(20).seconds()
        );
    }
}
