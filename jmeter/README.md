# Prueba de rendimiento

El plan `ciberbank-api-performance.jmx` ejecuta 10 usuarios virtuales, 5
iteraciones por usuario y dos solicitudes GET por iteracion (`/posts` y
`/users`). Incluye los listeners View Results Tree y Summary Report.

Ejecucion no grafica:

```bash
jmeter -n -t jmeter/ciberbank-api-performance.jmx \
  -l jmeter/results/results.jtl \
  -e -o jmeter/results/html-report
```

Resultado obtenido el 18-08-2026:

- 100 muestras: 50 para `/posts` y 50 para `/users`.
- 0 errores (0.00%).
- Tiempo promedio total: 92 ms.
- Evidencia: `results/captura-resultados.png`.
