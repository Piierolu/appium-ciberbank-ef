package edu.pe.cibertec.ciberbank.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ServiciosScreen {

    private static final String PAQUETE = "edu.pe.cibertec.ciberbank:id/";

    private ServiciosScreen() {
    }

    public static final Target SPINNER_EMPRESA =
            Target.the("desplegable de empreesa").located(By.id(PAQUETE + "spn_empresa"));

    public static final Target CAMPO_SUMINISTRO =
            Target.the("desplegable de empreesa").located(By.id(PAQUETE + "inp_suministro"));

    public static final Target BOTON_CONSULTAR =
            Target.the("desplegable de empreesa").located(By.id(PAQUETE + "btn_consultar"));

    public static final Target ERROR_SERVICIO =
            Target.the("mensaje de error del servicio").located(By.id(PAQUETE + "error_servicio"));

    public static final Target TITULAR =
            Target.the("titular del suministro").located(By.id(PAQUETE + "lbl_titular"));

    public static final Target DEUDA =
            Target.the("monto deuda").located(By.id(PAQUETE + "lbl_deuda"));

    public static final Target BOTON_PAGAR =
            Target.the("boton pagar").located(By.id(PAQUETE + "btn_pagar"));

    public static final Target BOTON_ACPETAR_DIALOGO =
            Target.the("boton aceptar del dialogo").located(By.id("android:id/button1"));

    public static final Target MENSAJE_PAGO_EXITOSO =
            Target.the("mensaje pago exitoso").located(By.id(PAQUETE+"lbl_pago_exitoso"));

    public static Target opcionDelDesplegable(String opcion) {
        return Target.the("opcion: " + opcion)
                .located(By.xpath("//android.widget.TextView[@resource-id='" + PAQUETE + "lbl_spinner_opcion' and @text='" + opcion + "']"));
    }
}
