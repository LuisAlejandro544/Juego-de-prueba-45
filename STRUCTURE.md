# Estructura del Proyecto (Structure)

Este documento detalla la organización de archivos, módulos y responsabilidades del port móvil de One Hour One Life.

```
.
├── .github/
│   └── workflows/
│       └── sync_onelife_sources.yml    # Workflow manual para descargar código y assets originales
│
├── app/                                # Módulo principal de la aplicación Android
│   ├── build.gradle.kts                # Configuración de compilación, SDK, dependencias y firmas
│   ├── src/
│   │   ├── main/
│   │   │   ├── AndroidManifest.xml     # Declaración de actividades, orientación landscape y hardware
│   │   │   ├── java/com/example/
│   │   │   │   ├── MainActivity.kt     # Actividad principal, enrutamiento y contenedor
│   │   │   │   └── ui/theme/           # Sistema de diseño, paleta de colores, tipografía y formas
│   │   │   └── res/                    # Iconos adaptativos, drawables, strings y recursos
│   │   └── test/                       # Pruebas unitarias locales con Robolectric y Roborazzi
│
├── ohol_sources/                       # Fuentes originales de OneLife (poblado por workflow)
│   ├── OneLife/
│   │   ├── gameSource/                 # Lógica original del cliente C++
│   │   └── server/                     # Lógica de servidor y simulación de mundo
│   ├── minorGems/                      # Motor base C++ (gráficos, matemáticas, audio, I/O)
│   └── OneLifeData7/                   # Definiciones de objetos, recetas, sprites y animaciones
│
├── AGENTS.md                           # Directivas, reglas operativas y convenciones para agentes de IA
├── AI_CONTEXT.md                       # Contexto técnico, arquitectura y limitaciones del proyecto
├── README.md                           # Descripción general e instrucciones de inicio
├── ROADMAP.md                          # Hoja de ruta por fases y metas
└── STRUCTURE.md                        # Este documento explicativo de la estructura
```

## Arquitectura de Módulos Prevista

1. **Capa UI (Kotlin + Jetpack Compose)**:
   - Manejo de navegación entre pantallas dedicadas (Juego, Crafteo, Opciones, Partidas).
   - HUD adaptable para orientación horizontal: barra de comida, temperatura, año de vida y ranuras de inventario.
   - Controles y detección de toques táctiles.

2. **Capa de Dominio / Motor Offline**:
   - `SimulationEngine`: Coordina el tiempo de vida (ticks), regeneración de hambre y estados del jugador.
   - `CraftingEngine`: Consulta de transiciones directas e inversas.
   - `WorldGrid`: Mapa de casillas con objetos en el suelo y biomas.

3. **Capa de Datos**:
   - `ObjectRepository`: Acceso a propiedades y atributos de objetos.
   - `SpriteManager`: Carga bajo demanda y caché de texturas.
   - `SaveGameManager`: Persistencia de partidas locales en base de datos Room o binario local.
