package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.questions.ElementoVisible;
import edu.pe.cibertec.ciberbank.tasks.CerrarSesion;
import edu.pe.cibertec.ciberbank.tasks.PulsarAtras;
import edu.pe.cibertec.ciberbank.userinterface.DashboardScreen;
import edu.pe.cibertec.ciberbank.userinterface.LoginScreen;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PerfilStepDefinitions {

    @Before("@perfil")
    public void preparaEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After("@perfil")
    public void cierraEscenario() {
        OnStage.drawTheCurtain();
    }

    @Cuando("abre el perfil y cierra la sesión")
    public void abreElPerfilYCierraLaSesion() {
        theActorInTheSpotlight().attemptsTo(CerrarSesion.desdeElPerfil());
    }

    @Entonces("debería regresar a la pantalla de login")
    public void deberiaRegresarALaPantallaDeLogin() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(LoginScreen.CAMPO_USUARIO).isDisplayed()
        );
    }

    @Cuando("pulsa el botón atrás del sistema")
    public void pulsaElBotonAtrasDelSistema() {
        theActorInTheSpotlight().attemptsTo(PulsarAtras.delSistema());
    }

    @Entonces("no debería reingresar al dashboard")
    public void noDeberiaReingresarAlDashboard() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(ElementoVisible.el(DashboardScreen.SALDO_PRINCIPAL)).isFalse()
        );
    }
}
