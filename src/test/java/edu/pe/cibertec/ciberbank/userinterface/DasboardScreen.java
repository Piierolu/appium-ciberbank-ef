package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DasboardScreen {
    private static final String PAQUETE=  "edu.pe.cibertec.ciberbank:id/";

    private DasboardScreen (){}

    public static final Target SALUDO =
            Target.the("saludo bienvenida").located(By.id(PAQUETE + "lbl_bienvenida"));

    public static final Target SALDO_PRINCIPAL =
            Target.the("saldo principal").located(By.id(PAQUETE + "lbl_saldo_principal"));

    public static final Target CUENTA_PRINCIPAL =
            Target.the("cuenta principal").located(By.id(PAQUETE + "lbl_cuenta_principal"));

    public static final Target BOTON_MENU =
            Target.the("boton_menu").located(By.id(PAQUETE + "btn_menu"));

    public static final Target BOTON_SERVICIOS =
            Target.the("acceso rapido servicios").located(By.id(PAQUETE + "btn_servicios"));
}
