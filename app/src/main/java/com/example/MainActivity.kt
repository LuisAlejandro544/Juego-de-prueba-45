package com.example

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Landscape
import androidx.compose.material.icons.rounded.Public
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.MyApplicationTheme

/**
 * MainActivity: Actividad principal configurada para ejecutarse en modo horizontal (Landscape).
 * Esta pantalla sirve como base inicial (Hello World) solicitada por el usuario antes de
 * proceder a la planificación detallada de la aplicación.
 */
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // Forzar orientación horizontal con sensor (Landscape / Reverse Landscape)
    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE

    // Habilitar soporte de pantalla completa (Edge-to-Edge)
    enableEdgeToEdge()

    setContent {
      MyApplicationTheme {
        Scaffold(
          modifier = Modifier.fillMaxSize(),
          contentWindowInsets = WindowInsets.safeDrawing
        ) { innerPadding ->
          HelloWorldHorizontalScreen(
            modifier = Modifier
              .fillMaxSize()
              .padding(innerPadding)
          )
        }
      }
    }
  }
}

/**
 * HelloWorldHorizontalScreen:
 * Contenedor visual adaptado ergonómicamente a la orientación horizontal (aprovechando
 * la amplitud horizontal de la pantalla sin saturación ni minimalismo extremo).
 */
@Composable
fun HelloWorldHorizontalScreen(modifier: Modifier = Modifier) {
  Box(
    modifier = modifier
      .fillMaxSize()
      .testTag("hello_world_container"),
    contentAlignment = Alignment.Center
  ) {
    // Tarjeta principal con elevación y estética cuidada
    Card(
      modifier = Modifier
        .padding(16.dp)
        .testTag("hello_world_card"),
      shape = RoundedCornerShape(24.dp),
      colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
      ),
      elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
      Row(
        modifier = Modifier
          .padding(horizontal = 32.dp, vertical = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(24.dp)
      ) {
        // Contenedor visual del icono representativo
        Box(
          modifier = Modifier
            .size(72.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer),
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = Icons.Rounded.Public,
            contentDescription = "Ícono de Mundo",
            modifier = Modifier.size(40.dp),
            tint = MaterialTheme.colorScheme.onPrimaryContainer
          )
        }

        // Bloque de texto descriptivo y etiquetas de estado
        Column(
          verticalArrangement = Arrangement.Center
        ) {
          Text(
            text = "¡Hola, Mundo!",
            style = MaterialTheme.typography.headlineMedium.copy(
              fontWeight = FontWeight.Bold,
              letterSpacing = 0.5.sp
            ),
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.testTag("hello_world_text")
          )

          Spacer(modifier = Modifier.height(4.dp))

          Text(
            text = "Modo horizontal activo • Listo para planificar",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )

          Spacer(modifier = Modifier.height(12.dp))

          // Chip indicativo de estado
          AssistChip(
            onClick = { /* Acción informativa */ },
            label = { Text("Pantalla inicial preparada") },
            leadingIcon = {
              Icon(
                imageVector = Icons.Rounded.Landscape,
                contentDescription = "Modo horizontal",
                modifier = Modifier.size(18.dp)
              )
            },
            colors = AssistChipDefaults.assistChipColors(
              containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
              labelColor = MaterialTheme.colorScheme.primary
            )
          )
        }
      }
    }
  }
}

/**
 * Función Greeting conservada para compatibilidad con pruebas unitarias y de captura.
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  HelloWorldHorizontalScreen(modifier = modifier)
}

@Preview(
  showBackground = true,
  device = "spec:parent=pixel_5,orientation=landscape"
)
@Composable
fun HelloWorldHorizontalPreview() {
  MyApplicationTheme {
    Surface {
      HelloWorldHorizontalScreen()
    }
  }
}
