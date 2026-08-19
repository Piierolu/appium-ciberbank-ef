package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.questions.TextoDe;
import edu.pe.cibertec.ciberbank.tasks.AbrirMovimientos;
import edu.pe.cibertec.ciberbank.tasks.DesplazarLista;
import edu.pe.cibertec.ciberbank.userinterface.MovimientosScreen;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class MovimientosStepDefinitions {

    @Before("@movimientos")
    public void preparaEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After("@movimientos")
    public void cierraEscenario() {
        OnStage.drawTheCurtain();
    }

    @Cuando("abre la pantalla de movimientos")
    public void abreLaPantallaDeMovimientos() {
        theActorInTheSpotlight().attemptsTo(AbrirMovimientos.desdeElDashboard());
    }

    @Entonces("debería ver el contador {string}")
    public void deberiaVerElContador(String contador) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(TextoDe.el(MovimientosScreen.CONTADOR)).isEqualTo(contador)
        );
    }

    @Cuando("desplaza la lista hasta el final")
    public void desplazaLaListaHastaElFinal() {
        theActorInTheSpotlight().attemptsTo(DesplazarLista.hastaElFinal());
    }
}
