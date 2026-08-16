# CiberBankgit ad Automatización móvil con Appium

Proyecto de pruebas automatizadas sobre la app Android **CiberBank**, usando Appium 2/3, Serenity BDD y el patrón ScreenPlay.

## Requisitos

- JDK 21
- Android SDK con un emulador creado
- Node.js con Appium y el driver UiAutomator2:

```bash
npm install -g appium
appium driver install uiautomator2
```

## Configuración

**1. Clonar el repositorio**

```bash
git clone https://github.com/cibertec-courses/appium-ciberbank.git
cd appium-ciberbank
```

**2. Levantar el emulador y verificar que adb lo reconoce**

```bash
adb devices
```

Debe aparecer algo como `emulator-5554   device`. Si tu emulador tiene otro nombre, ajusta `deviceName` en `src/test/resources/serenity.conf`.

**3. Instalar el APK incluido en el repositorio**

```bash
adb install -r app/ciberbank-debug.apk
```

**4. Iniciar el servidor de Appium** (dejar esta terminal abierta)

```bash
appium --address 127.0.0.1 --port 4723
```

**5. Ejecutar las pruebas** (en otra terminal)

```bash
mvn clean verify
```

El reporte se genera en `target/site/serenity/index.html`.

## Appium Inspector

Remote Host `127.0.0.1` · Port `4723` · Path `/`

```json
{
  "platformName": "Android",
  "appium:automationName": "UiAutomator2",
  "appium:deviceName": "emulator-5554",
  "appium:appPackage": "edu.pe.cibertec.ciberbank",
  "appium:appActivity": ".ui.SplashActivity",
  "appium:autoGrantPermissions": true,
  "appium:noReset": false
}
```

## Usuarios de prueba

| Usuario | Contraseña | Estado |
|---|---|---|
| `jaime` | `Cibertec123` | Activo — saldo S/ 4,850.00 |
| `bloqueado` | `Cibertec123` | Bloqueado |
| `sinsaldo` | `Cibertec123` | Activo — saldo S/ 0.00 |

Los datos se reinician solos en cada escenario. Para reiniciarlos a mano, usa el enlace **Reiniciar datos de prueba** en la pantalla de login, o:

```bash
adb shell pm clear edu.pe.cibertec.ciberbank
```
