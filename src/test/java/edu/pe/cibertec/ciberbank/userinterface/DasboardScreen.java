package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class DasboardScreen {
    private static final String PAQUETE=  "edu.pe.cibertec.ciberbank:id/";

    private DasboardScreen (){}

    public static final Target SALUDO =
            Target.the("saludo bienvenida").locatedBy(PAQUETE+"lbl_bienvenida");

    public static final Target SALDO_PRINCIPAL =
            Target.the("saldo principal").locatedBy(PAQUETE+"lbl_saldo_principal");

    public static final Target CUENTA_PRINCIPAL =
            Target.the("cuenta principal").locatedBy(PAQUETE+"lbl_cuenta_principal");

    public static final Target BOTON_MENU =
            Target.the("boton_menu").locatedBy(PAQUETE+"btn_menu");


}
