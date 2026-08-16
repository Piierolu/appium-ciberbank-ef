package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.LoginScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

/** Completa el formulario de login y pulsa Ingresar. */
public class IniciarSesion implements Task {

    private final String usuario;
    private final String clave;

    public IniciarSesion(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public static IniciarSesion con(String usuario, String clave) {
        return new IniciarSesion(usuario, clave);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(LoginScreen.CAMPO_USUARIO),
                Enter.theValue(clave).into(LoginScreen.CAMPO_CLAVE),
                OcultarTeclado.siEstaAbierto(),
                Click.on(LoginScreen.BOTON_INGRESAR)
        );
    }
}
