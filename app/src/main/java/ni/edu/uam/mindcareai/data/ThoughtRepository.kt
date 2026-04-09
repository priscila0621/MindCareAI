package ni.edu.uam.mindcareai.data

import ni.edu.uam.mindcareai.model.Thought

object ThoughtRepository {
    private val history = mutableListOf<Thought>()

    fun addThought(thought: Thought) {
        history.add(0, thought)
    }

    fun getHistory(): List<Thought> = history
}