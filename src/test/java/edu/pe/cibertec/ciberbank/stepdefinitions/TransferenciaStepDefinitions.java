package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.questions.TextoDe;
import edu.pe.cibertec.ciberbank.tasks.ConfirmarTransferencia;
import edu.pe.cibertec.ciberbank.tasks.IniciarSesion;
import edu.pe.cibertec.ciberbank.tasks.Transferir;
import edu.pe.cibertec.ciberbank.userinterface.ConfirmacionScreen;
import edu.pe.cibertec.ciberbank.userinterface.TransferenciaScreen;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TransferenciaStepDefinitions {

    private static final String CLAVE = "Cibertec123";

    @Before("@transferencia")
    public void preparaEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After("@transferencia")
    public void cierraEscenario() {
        OnStage.drawTheCurtain();
    }

    @Dado("que Jaime inició sesión con el usuario {string}")
    public void jaimeInicioSesion(String usuario) {
        theActorInTheSpotlight().attemptsTo(IniciarSesion.con(usuario, CLAVE));
    }

    @Cuando("^transfiere ([0-9]+(?:\\.[0-9]+)?) al beneficiario \"([^\"]+)\"$")
    public void transfiereAlBeneficiario(String monto, String beneficiario) {
        realizaTransferencia(monto, beneficiario);
    }

    @Cuando("^intenta transferir ([0-9]+(?:\\.[0-9]+)?) al beneficiario \"([^\"]+)\"$")
    public void intentaTransferirAlBeneficiario(String monto, String beneficiario) {
        realizaTransferencia(monto, beneficiario);
    }

    @Y("acepta el diálogo de confirmación")
    public void aceptaElDialogoDeConfirmacion() {
        theActorInTheSpotlight().attemptsTo(ConfirmarTransferencia.aceptandoElDialogo());
    }

    @Entonces("debería ver un número de operación generado")
    public void deberiaVerUnNumeroDeOperacion() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(TextoDe.el(ConfirmacionScreen.NUMERO_OPERACION)).isNotEmpty()
        );
    }

    @Y("el saldo debería quedar en {string}")
    public void elSaldoDeberiaQuedarEn(String saldo) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(TextoDe.el(ConfirmacionScreen.SALDO_ACTUALIZADO)).isEqualTo(saldo)
        );
    }

    @Entonces("^debería ver el mensaje de error \"(Excede el límite de S/ 3,000\\.00 por operación|Saldo insuficiente)\"$")
    public void deberiaVerElMensajeDeTransferencia(String mensaje) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(TextoDe.el(TransferenciaScreen.ERROR)).isEqualTo(mensaje)
        );
    }

    private void realizaTransferencia(String monto, String beneficiario) {
        theActorInTheSpotlight().attemptsTo(
                Transferir.elMonto(monto, beneficiario)
        );
    }
}
