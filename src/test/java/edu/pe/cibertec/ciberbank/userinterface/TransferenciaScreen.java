package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class TransferenciaScreen {

    private static final String PAQUETE = "edu.pe.cibertec.ciberbank:id/";

    private TransferenciaScreen() {
    }

    public static final Target BENEFICIARIO =
            Target.the("beneficiario").located(By.id(PAQUETE + "spn_beneficiario"));

    public static final Target MONTO =
            Target.the("monto de la transferencia").located(By.id(PAQUETE + "inp_monto"));

    public static final Target CONTINUAR =
            Target.the("botón Continuar").located(By.id(PAQUETE + "btn_continuar"));

    public static final Target ERROR =
            Target.the("mensaje de error de transferencia").located(By.id(PAQUETE + "err_transferencia"));

    public static Target opcionBeneficiario(String nombre) {
        return Target.the("beneficiario " + nombre).located(By.xpath(
                "//*[@resource-id='" + PAQUETE + "lbl_spinner_opcion' and starts-with(@text,'" + nombre + "')]"
        ));
    }
}
