package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.ServiciosScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarEmpresa implements Task {
    private String empresa;

    public SeleccionarEmpresa(String empresa) {
        this.empresa = empresa;
    }
    public static SeleccionarEmpresa llamada(String empresa ) {
        return new SeleccionarEmpresa(empresa);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ServiciosScreen.SPINNER_EMPRESA),
                WaitUntil.the(ServiciosScreen.opcionDelDesplegable(empresa), isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(ServiciosScreen.opcionDelDesplegable(empresa))
        );
    }
}
