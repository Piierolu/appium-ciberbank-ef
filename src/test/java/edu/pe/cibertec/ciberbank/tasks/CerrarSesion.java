package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.DashboardScreen;
import edu.pe.cibertec.ciberbank.userinterface.LoginScreen;
import edu.pe.cibertec.ciberbank.userinterface.PerfilScreen;
import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CerrarSesion implements Task {

    private static final String ID_CERRAR_SESION =
            "edu.pe.cibertec.ciberbank:id/btn_cerrar_sesion";

    public static CerrarSesion desdeElPerfil() {
        return new CerrarSesion();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DashboardScreen.BOTON_MENU),
                WaitUntil.the(DashboardScreen.OPCION_PERFIL, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(DashboardScreen.OPCION_PERFIL),
                WaitUntil.the(PerfilScreen.NOMBRE, isVisible()).forNoMoreThan(20).seconds()
        );

        BrowseTheWeb.as(actor).getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
                        "new UiSelector().resourceId(\"" + ID_CERRAR_SESION + "\"))"
        )).click();

        actor.attemptsTo(
                WaitUntil.the(LoginScreen.CAMPO_USUARIO, isVisible()).forNoMoreThan(20).seconds()
        );
    }
}
