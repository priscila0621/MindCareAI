package ni.edu.uam.mindcareai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.*
import ni.edu.uam.mindcareai.screens.HistorialScreen
import ni.edu.uam.mindcareai.screens.PerfilScreen
import ni.edu.uam.mindcareai.screens.RegistroScreen
import ni.edu.uam.mindcareai.ui.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "pantalla_registro") {
                composable("pantalla_registro") { RegistroScreen(navController) }
                composable("pantalla_historial") { HistorialScreen(navController) }
                composable("pantalla_perfil") { PerfilScreen(navController) }
            }
        }
    }
}