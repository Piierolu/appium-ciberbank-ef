package edu.pe.cibertec.ciberbank.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Devuelve el texto visible de un elemento. Una sola Question sirve para el saludo,
 * el saldo y los mensajes de error, en lugar de escribir una clase por cada rotulo.
 */
public class TextoDe implements Question<String> {

    private final Target elemento;

    public TextoDe(Target elemento) {
        this.elemento = elemento;
    }

    public static TextoDe el(Target elemento) {
        return new TextoDe(elemento);
    }

    @Override
    public String answeredBy(Actor actor) {
        return elemento.resolveFor(actor).getText();
    }
}
