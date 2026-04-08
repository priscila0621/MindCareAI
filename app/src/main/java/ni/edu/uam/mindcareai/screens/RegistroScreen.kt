package ni.edu.uam.mindcareai.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import ni.edu.uam.mindcareai.data.GeminiManager
import ni.edu.uam.mindcareai.data.ThoughtRepository
import ni.edu.uam.mindcareai.model.Thought

@Composable
fun RegistroScreen(navController: NavController) {
    var texto by remember { mutableStateOf("") }
    var respuestaIA by remember { mutableStateOf("") }
    var cargando by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val gemini = GeminiManager()

    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        Text("¿Cómo te sientes hoy?", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = texto,
            onValueChange = { texto = it },
            label = { Text("Desahógate aquí...") },
            modifier = Modifier.fillMaxWidth().height(150.dp)
        )

        Button(
            onClick = {
                if (texto.isNotBlank()) {
                    scope.launch {
                        cargando = true
                        val respuesta = gemini.getAdvice(texto)
                        respuestaIA = respuesta
                        // Guardamos el pensamiento en el repositorio
                        ThoughtRepository.addThought(Thought(0, texto, respuesta, "08 Abr"))
                        cargando = false
                    }
                }
            },
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
            enabled = !cargando
        ) {
            Text(if (cargando) "Analizando..." else "Obtener Consejo de IA")
        }

        if (respuestaIA.isNotEmpty()) {
            Card(
                modifier = Modifier.padding(top = 20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
            ) {
                Text(respuestaIA, modifier = Modifier.padding(16.dp))
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = { navController.navigate("pantalla_historial") }) {
            Text("Ver historial →")
        }
    }
}