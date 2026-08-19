package edu.pe.cibertec.ciberbank.tasks;

import edu.pe.cibertec.ciberbank.userinterface.MovimientosScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Interactive;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;

public class DesplazarLista implements Task {

    public static DesplazarLista hastaElFinal() {
        return new DesplazarLista();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Rectangle lista = MovimientosScreen.LISTA.resolveFor(actor).getRect();
        int x = lista.x + lista.width / 2;
        int inicioY = lista.y + (int) (lista.height * 0.9);
        int finY = lista.y + (int) (lista.height * 0.1);

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        for (int intento = 0; intento < 2; intento++) {
            PointerInput dedo = new PointerInput(PointerInput.Kind.TOUCH, "dedo-" + intento);
            Sequence swipe = new Sequence(dedo, intento + 1);
            swipe.addAction(dedo.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, inicioY));
            swipe.addAction(dedo.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(new Pause(dedo, Duration.ofMillis(200)));
            swipe.addAction(dedo.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), x, finY));
            swipe.addAction(dedo.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            ((Interactive) driver).perform(List.of(swipe));
        }

        actor.attemptsTo(
                WaitUntil.the(MovimientosScreen.CONTADOR, containsText("Mostrando 30 de 32 movimientos"))
                        .forNoMoreThan(20).seconds()
        );
    }
}
