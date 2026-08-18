package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.ServiciosScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ConsultarSuministro implements Task {

    private final String suministro;

    public ConsultarSuministro(String suministro) {
        this.suministro = suministro;
    }

    public static ConsultarSuministro numero(String suministro) {
        return new ConsultarSuministro(suministro);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(ServiciosScreen.CAMPO_SUMINISTRO),
                Enter.theValue(suministro).into(ServiciosScreen.CAMPO_SUMINISTRO),
                OcultarTeclado.siEstaAbierto(),
                Click.on(ServiciosScreen.BOTON_CONSULTAR)
        );
    }
}
