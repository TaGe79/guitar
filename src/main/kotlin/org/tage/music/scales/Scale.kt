package org.tage.music.scales

import org.tage.music.Note

abstract class Scale(val key: Note, val steps: List<Int>) {
    val notes: List<Note> = arrayListOf(key) + steps.mapIndexed { idx, _ ->
        Note.values()[(key.ordinal + steps.subList(0, idx + 1).sum()) % Note.values().size]
    }

    operator fun get(idx: Int): Note = notes[idx % steps.size]

    override fun toString(): String =
        notes.joinToString { it.display.padStart(2,' ') }
}
