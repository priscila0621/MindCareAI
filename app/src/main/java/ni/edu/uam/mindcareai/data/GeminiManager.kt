package ni.edu.uam.mindcareai.data

import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GeminiManager {
    // Configuración del modelo
    private val generativeModel = GenerativeModel(
        modelName = "gemini-1.5-flash",
        apiKey = "TU_API_KEY_AQUI"
    )

    // Función que se comunica con la IA
    suspend fun getAdvice(input: String): String = withContext(Dispatchers.IO) {
        val prompt = "Eres un psicólogo empático. El usuario dice: '$input'. Responde de forma breve, positiva y profesional."
        try {
            val response = generativeModel.generateContent(prompt)
            response.text ?: "No pude procesar tu mensaje en este momento."
        } catch (e: Exception) {
            "Error de conexión: Asegúrate de tener internet."
        }
    }
}