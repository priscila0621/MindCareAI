package ni.edu.uam.mindcareai.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ni.edu.uam.mindcareai.data.ThoughtRepository
import ni.edu.uam.mindcareai.model.Thought

@Composable
fun HistorialScreen(navController: NavController) {
    val historial = ThoughtRepository.getHistory()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Mis Reflexiones", style = MaterialTheme.typography.headlineSmall)

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(historial) { item ->
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("Tú: ${item.originalText}", style = MaterialTheme.typography.bodySmall)
                        Text("IA: ${item.aiResponse}", color = MaterialTheme.colorScheme.primary)
                    }
                }
            }
        }

        Button(onClick = { navController.navigate("pantalla_perfil") }) {
            Text("Ver mi Perfil")
        }
    }
}