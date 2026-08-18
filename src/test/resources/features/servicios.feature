# language: es
Característica: Pago de servicios

  Antecedentes:
    Dado que Jaime está en la pantalla de login con el usuario "jaime"
    Y abre la pantalla de pago de servicios

  @servicios
  Escenario: Pago exitoso de un recibo de luz
    Cuando selecciona la empresa "Luz del Sur"
    Y consulta el suministro "12345678"
    Entonces debería ver el titular "Jaime Pretell"
    Y la deuda mostrada debería ser "S/ 89.50"
    Cuando paga el recibo y acepta la confirmación
    Entonces debería ver el mensaje "Pago realizado correctamente"