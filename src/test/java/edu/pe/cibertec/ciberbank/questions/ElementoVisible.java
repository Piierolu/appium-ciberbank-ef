package edu.pe.cibertec.ciberbank.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ElementoVisible implements Question<Boolean> {

    private final Target elemento;

    private ElementoVisible(Target elemento) {
        this.elemento = elemento;
    }

    public static ElementoVisible el(Target elemento) {
        return new ElementoVisible(elemento);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return elemento.resolveAllFor(actor).stream().anyMatch(elementoEncontrado -> elementoEncontrado.isVisible());
    }
}
