package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.DashboardScreen;
import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Transferir implements Task {

    private final String monto;
    private final String beneficiario;

    private Transferir(String monto, String beneficiario) {
        this.monto = monto;
        this.beneficiario = beneficiario;
    }

    public static Transferir elMonto(String monto, String beneficiario) {
        return new Transferir(monto, beneficiario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DashboardScreen.BOTON_TRANSFERIR),
                WaitUntil.the(TransferenciaScreen.BENEFICIARIO, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(TransferenciaScreen.BENEFICIARIO),
                WaitUntil.the(TransferenciaScreen.opcionBeneficiario(beneficiario), isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(TransferenciaScreen.opcionBeneficiario(beneficiario)),
                Enter.theValue(monto).into(TransferenciaScreen.MONTO),
                OcultarTeclado.siEstaAbierto(),
                Click.on(TransferenciaScreen.CONTINUAR)
        );
    }
}
