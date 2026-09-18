# Contexto para Inteligencia Artificial (AI_CONTEXT.md)

Este archivo proporciona todo el contexto técnico, antecedentes y decisiones clave de diseño para que cualquier asistente o modelo de IA entienda el objetivo del proyecto antes de generar o refactorizar código.

## 1. Propósito Central
Estamos construyendo un **port a móvil para Android** del galardonado juego de PC **One Hour One Life (OHOL)** de Jason Rohrer. 
- La versión original depende de servidores remotos autoritativos en C++ y de un cliente desktop con ratón y teclado.
- Nuestra misión es **eliminar la necesidad de servidores externos**, convirtiéndolo en una experiencia **100% jugable offline** en dispositivos móviles con pantalla táctil en **modo horizontal**.

## 2. Tecnologías y Herramientas en Uso
- **Plataforma Objetivo**: Android (SDK mínimo 24, Android 7.0+).
- **Lenguaje Principal de la App**: Kotlin con Jetpack Compose y Material Design 3.
- **Lógica Nativa y Fuentes Base**: C++ proveniente de `OneLife/gameSource`, `OneLife/server` y `minorGems`.
- **Formato de Recursos del Juego**:
  - `objects/`: Archivos de texto con formato ID, nombre, comida, sprites y propiedades físicas.
  - `transitions/`: Archivos con recetas tipo: `actor + target = newActor + newTarget + decay`.
  - `sprites/`: Archivos TGA o PNG con partes del cuerpo y objetos.
  - `animations/`: Parámetros de interpolación esqueletal.

## 3. Desafíos Técnicos Principales
1. **Desacoplamiento Servidor -> Local**:
   - El servidor original corre en bucle de sockets UDP. Para jugar offline, ese flujo se reemplaza por una cola de eventos en memoria directa entre la simulación y la interfaz del usuario.
2. **Ergonomía Táctil en Móvil**:
   - En PC se usa clic izquierdo para interactuar y clic derecho para soltar/usar secundario. En móvil, se implementará interacción por toque simple, pulsación prolongada y arrastre intuitivo hacia casillas o inventario.
3. **Manejo de Rendimiento y Memoria**:
   - Hay miles de sprites y animaciones. Es indispensable cargar texturas mediante caché inteligente y atlasses para no saturar la memoria RAM de teléfonos de gama media/baja.
4. **Soporte de Arquitecturas**:
   - Compilación nativa para `arm64-v8a` y `armeabi-v7a`.

## 4. Filosofía de Código para la IA
- **No inventar reglas sin justificación**: Las recetas y mecánicas deben apegarse fielmente al juego original.
- **Modularidad estricta**: Separar la vista visual del bucle de simulación lógica.
- **Respetar la orientación horizontal**: Todas las pantallas deben diseñarse horizontalmente (`sensorLandscape`).
- **No romper el Hello World base**: La aplicación debe mantenerse compilable en cada iteración.
