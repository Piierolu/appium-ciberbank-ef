package edu.pe.cibertec.ciberbank.stepdefinitions;

import edu.pe.cibertec.ciberbank.questions.TextoDe;
import edu.pe.cibertec.ciberbank.tasks.*;
import edu.pe.cibertec.ciberbank.tasks.AbrirPagoDeServicio;
import edu.pe.cibertec.ciberbank.userinterface.ServiciosScreen;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class ServiciosStepDefinitions {

    private static final String CLAVE = "Cibertec123";

    @Dado("que {word} está en la pantalla de login con el usuario {string}")
    public void que_esta_en_la_pantalla_de_login_con_el_usuario(String actor, String usuario) {
        theActorCalled(actor).attemptsTo(
                EsperarLaPantallaDeLogin.queSeMuestre(),
                IniciarSesion.con(usuario, CLAVE)
        );
    }

    @Y("abre la pantalla de pago de servicios")
    public void abre_la_pantalla_de_pago_de_servicios() {
        theActorInTheSpotlight().attemptsTo(
                AbrirPagoDeServicio.desdeElDashboard()
        );
    }
    @Cuando("selecciona la empresa {string}")
    public void selecciona_la_empresa(String empresa) {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarEmpresa.llamada(empresa)
        );
    }

    @Y("consulta el suministro {string}")
    public void consulta_el_suministro(String suministro) {
        theActorInTheSpotlight().attemptsTo(
                ConsultarSuministro.numero(suministro)
        );
    }

    @Cuando("paga el recibo y acepta la confirmación")
    public void paga_el_recibo_y_acepta_la_confirmacion() {
        theActorInTheSpotlight().attemptsTo(
                PagarElRecibo.aceptandoLaConfirmacion()
        );
    }

    @Entonces("debería ver el titular {string}")
    public void deberia_ver_el_titular(String titular) {
        theActorInTheSpotlight().should(
                seeThat("el titular del suministro", TextoDe.el(ServiciosScreen.TITULAR), is(titular))
        );
    }

    @Y("la deuda mostrada debería ser {string}")
    public void la_deuda_mostrada_deberia_ser(String deuda) {
        theActorInTheSpotlight().should(
                seeThat("la deuda", TextoDe.el(ServiciosScreen.DEUDA), is(deuda))
        );
    }

    @Entonces("debería ver el mensaje {string}")
    public void deberia_ver_el_mensaje(String mensaje) {
        theActorInTheSpotlight().should(
                seeThat("el mensaje de pago", TextoDe.el(ServiciosScreen.MENSAJE_PAGO_EXITOSO), is(mensaje))
        );
    }
}