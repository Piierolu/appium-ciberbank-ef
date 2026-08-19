package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class PerfilScreen {

    private static final String PAQUETE = "edu.pe.cibertec.ciberbank:id/";

    private PerfilScreen() {
    }

    public static final Target NOMBRE =
            Target.the("nombre del perfil").located(By.id(PAQUETE + "lbl_perfil_nombre"));

    public static final Target CERRAR_SESION =
            Target.the("botón Cerrar sesión").located(By.id(PAQUETE + "btn_cerrar_sesion"));
}
