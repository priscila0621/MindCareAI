package ni.edu.uam.mindcareai.model

data class Thought(
    val id: Int,
    val originalText: String,
    val aiResponse: String,
    val date: String
)