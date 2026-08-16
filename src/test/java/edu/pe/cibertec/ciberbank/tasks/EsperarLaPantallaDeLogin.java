package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.LoginScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * El splash dura 2 segundos antes de dar paso al login. Se resuelve con una espera
 * explicita, nunca con una pausa fija.
 */
public class EsperarLaPantallaDeLogin implements Task {

    private static final int SEGUNDOS_MAXIMO = 20;

    public static EsperarLaPantallaDeLogin queSeMuestre() {
        return new EsperarLaPantallaDeLogin();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginScreen.CAMPO_USUARIO, isVisible())
                        .forNoMoreThan(SEGUNDOS_MAXIMO).seconds()
        );
    }
}
