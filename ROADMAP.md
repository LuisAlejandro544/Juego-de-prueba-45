# Hoja de Ruta (Roadmap) - Port Móvil OHOL Offline

Plan de desarrollo estratégico por fases para convertir el código base de PC en una aplicación Android fluida, offline y completamente táctil.

---

## Fase 1: Cimientos y Configuración Base (Actual)
- [x] Configuración del proyecto Android en modo horizontal fijo (`sensorLandscape`).
- [x] Pantalla base Hello World y temas Material 3 adaptados a panorámica.
- [x] GitHub Action para sincronizar fuentes oficiales (`OneLife`, `minorGems`, `OneLifeData7`) bajo demanda.
- [x] Definición de arquitectura técnica, estándares y documentación base.

---

## Fase 2: Ingesta de Datos y Parser de Assets
- [ ] Parser de definiciones de objetos (`OneLifeData7/objects/`).
- [ ] Parser de recetas y transiciones (`OneLifeData7/transitions/`).
- [ ] Decodificador de sprites y texturas dibujadas a mano para renderizado en Android.
- [ ] Parser de animaciones esqueletales (`OneLifeData7/animations/`).
- [ ] Base de datos local o almacenamiento binario en disco para acceso rápido a más de 2000+ objetos y recetas.

---

## Fase 3: Motor de Simulación Local (Offline Core)
- [ ] Desacoplamiento del bucle de red cliente/servidor para correr la lógica en un hilo local.
- [ ] Generación de mapa procedimental reducido y persistente en el dispositivo.
- [ ] Sistema de hambre, calor/temperatura corporal y envejecimiento (1 minuto = 1 año, hasta 60 años).
- [ ] Motor de interacciones (usar objeto A con objeto B, colocar en suelo, comer, craftear).

---

## Fase 4: Renderizado y Controles Táctiles (UI/UX Móvil)
- [ ] Renderizador visual adaptado a pantalla táctil (Canvas/OpenGL ES / Compose).
- [ ] Soporte de gestos táctiles:
  - Tocar para caminar / mover casilla.
  - Tocar objeto para recoger o interactuar.
  - Arrastrar hacia otro objeto para combinar/craftear.
  - Zona rápida para comer y alimentar.
- [ ] HUD y pantallas separadas:
  - Pantalla de juego principal.
  - Libro/árbol de recetas y crafteo offline.
  - Pantalla de ajustes y personalización de controles.
  - Gestión de partidas locales guardadas.

---

## Fase 5: Optimización de Rendimiento y Empaquetado
- [ ] Verificación en arquitecturas `arm64-v8a` y `armeabi-v7a`.
- [ ] Optimización de memoria de texturas y spritesheet atlasing.
- [ ] Empaquetado de APK listo para distribución directa (Uptodown, APK autónomo).
- [ ] Pruebas locales de estrés y jugabilidad continua de 60 minutos sin fugas de memoria.
