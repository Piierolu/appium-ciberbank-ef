# language: es
@perfil
Característica: Cierre seguro de sesión

  Escenario: El botón atrás no recupera una sesión cerrada
    Dado que Jaime está en la pantalla de login
    Y que Jaime inició sesión con el usuario "jaime"
    Cuando abre el perfil y cierra la sesión
    Entonces debería regresar a la pantalla de login
    Cuando pulsa el botón atrás del sistema
    Entonces no debería reingresar al dashboard
