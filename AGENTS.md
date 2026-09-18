# Instrucciones y Convenciones para Agentes de IA (AGENTS.md)

Este archivo contiene las directivas permanentes, reglas de comportamiento y restricciones estrictas que los agentes de IA que colaboren en este repositorio deben seguir en todo momento.

---

## 1. Reglas Operativas Principales

1. **Razonamiento Previo Obligatorio**:
   - Antes de realizar cualquier cambio, analiza y razona qué herramientas utilizarás, qué impacto tendrá y qué componentes se verán afectados. No apliques cambios apresurados ni tomes rutas fáciles que introduzcan errores.

2. **Entorno del Usuario**:
   - El usuario programa y opera desde un teléfono móvil (no tiene PC de escritorio). Por lo tanto, el código y las interfaces deben ser claros, concisos y fáciles de revisar en pantallas móviles.
   - Si la aplicación se distribuye, se subirá a tiendas alternativas de APK (como Uptodown) o instalación directa, no a Google Play.

3. **Arquitecturas y Compatibilidad**:
   - Mantén en mente el soporte para arquitecturas de **32 bits y 64 bits** (`armeabi-v7a`, `arm64-v8a`, `x86`, `x86_64`).
   - Respeta la versión mínima de Android configurada (`minSdk = 24`). Si una función requiere elevar la versión mínima, evalúa minuciosamente el beneficio antes de proponérselo al usuario.

4. **Integración de Lenguajes Nativos (C++, Rust, Python)**:
   - Si se requiere código C++ o NDK para portar el motor original de OHOL, debe configurarse formalmente en Gradle/CMake sin funciones de fallback simuladas o incompletas.

5. **Dependencias y Licencias**:
   - Se priorizan soluciones robustas y funcionales usando dependencias adecuadas. El peso final del APK no es un problema si la funcionalidad es 100% confiable.
   - **No** incorporar librerías o dependencias con licencias que obliguen al proyecto a volverse restrictivamente abierto o que comprometan la autonomía del usuario.
   - Evitar usar marcas registradas protegidas en nombres de archivos o paquetes que puedan poner en riesgo legal al usuario.

6. **Diseño y Estilo Visual**:
   - Evitar el minimalismo extremo: las pantallas deben ser atractivas, funcionales y expresivas.
   - No amontonar todo en una sola pantalla confusa: diseña pantallas separadas y navegables para cada funcionalidad (Menú, Juego, Libro de Crafteo, Opciones, etc.).
   - No cambiar el diseño ni iconos existentes a menos que el usuario lo solicite explícitamente.
   - Mantener siempre la orientación horizontal (`sensorLandscape`).

7. **Estabilidad y Código Limpio**:
   - No modificar lógica existente que ya funcione salvo que sea estrictamente necesario para el objetivo actual.
   - Todo archivo de código fuente debe incluir comentarios y explicaciones en español sobre el propósito y funcionamiento de su lógica.
   - Si existe un archivo `commit_message.txt`, la información debe redactarse en español y no modificarse sin petición expresa del usuario.
