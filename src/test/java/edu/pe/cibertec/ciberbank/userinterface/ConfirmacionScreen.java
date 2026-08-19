package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class ConfirmacionScreen {

    private static final String PAQUETE = "edu.pe.cibertec.ciberbank:id/";

    private ConfirmacionScreen() {
    }

    public static final Target CONFIRMAR =
            Target.the("botón Confirmar").located(By.id(PAQUETE + "btn_confirmar"));

    public static final Target ACEPTAR_DIALOGO =
            Target.the("botón Aceptar del diálogo").located(By.id("android:id/button1"));

    public static final Target CANCELAR_DIALOGO =
            Target.the("botón Cancelar del diálogo").located(By.id("android:id/button2"));

    public static final Target NUMERO_OPERACION =
            Target.the("número de operación").located(By.id(PAQUETE + "lbl_numero_operacion"));

    public static final Target SALDO_ACTUALIZADO =
            Target.the("saldo actualizado").located(By.id(PAQUETE + "lbl_saldo_actualizado"));
}
