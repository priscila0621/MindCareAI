package ni.edu.uam.mindcareai.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PerfilScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Perfil de Usuario", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Análisis de Innovación (IA):", style = MaterialTheme.typography.titleMedium)
                Text("Basado en tus registros, tu estado emocional ha sido estable.")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { navController.navigate("pantalla_registro") }) {
            Text("Volver a Inicio")
        }
    }
}