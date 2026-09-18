# Port Móvil: One Hour One Life (Offline Edition)

Adaptación y port nativo a dispositivos móviles Android del juego de supervivencia y civilización *One Hour One Life* (originalmente creado por Jason Rohrer en Dominio Público).

## Descripción del Proyecto

El objetivo de este proyecto es portar la experiencia completa del juego a teléfonos y tabletas Android en orientación horizontal (Landscape), eliminando la dependencia de servidores externos para permitir partidas locales y offline en cualquier lugar, con controles táctiles ergonómicos e intuitivos.

## Características Principales

- **Modo Horizontal (Landscape)**: Optimizado para pantallas táctiles panorámicas de smartphones.
- **Motor Offline Embebido**: Simulación local de crafteos, transiciones, mapa y ciclo de vida de 60 minutos sin requerir servidores externos ni conexión a Internet.
- **Soporte de Arquitecturas**: Compatibilidad con arquitecturas modernas de 64 bits (`arm64-v8a`, `x86_64`) y 32 bits (`armeabi-v7a`, `x86`).
- **Control Táctil Adaptado**: Reemplazo ergonómico de controles de teclado/ratón por zonas táctiles, inventario interactivo y gestos simples para mover, craftear y alimentar.
- **Compatibilidad con Tiendas y APKs**: Diseñado para funcionar de manera independiente, listo para distribuirse directamente en APK o plataformas como Uptodown.

## Requisitos de Entorno y Versiones

- **Android OS**: Android 7.0 (API 24) o superior.
- **Gradle**: 8.13+ con Android Gradle Plugin moderno.
- **Kotlin**: 2.1.10+ con Jetpack Compose y Material Design 3.
- **NDK / CMake**: Para la integración de la lógica nativa C++ proveniente del motor original.

## Instalación y Ejecución Rápida

1. Clonar el repositorio:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd <NOMBRE_DEL_REPOSITORIO>
   ```
2. Descargar las fuentes del juego base (ejecutando el workflow manual en GitHub Actions o ejecutando el script de sincronización).
3. Compilar e instalar en un dispositivo o emulador:
   ```bash
   gradle assembleDebug
   ```

## Estructura de Directorios

- `app/`: Módulo principal de la aplicación Android (Kotlin, Compose, temas y vistas).
- `.github/workflows/`: Flujos de automatización para descarga de repositorios y compilación.
- `ohol_sources/`: Código fuente sincronizado de OneLife (`gameSource`, `server`), `minorGems` y datos (`OneLifeData7`).
- Documentación técnica: `README.md`, `ROADMAP.md`, `STRUCTURE.md`, `AI_CONTEXT.md` y `AGENTS.md`.

## Licencia

El juego original *One Hour One Life*, así como el motor *minorGems* y el contenido *OneLifeData7*, fueron liberados en el **Dominio Público** por Jason Rohrer.
