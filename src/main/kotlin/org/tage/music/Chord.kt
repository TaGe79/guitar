package org.tage.music

import org.tage.music.scales.MajorScale

/**
 *
 */
data class Chord(val base: Note, val type: ChordType = ChordType.Major, val mode: ChordMode = ChordMode.Normal) {
    private val pattern: List<Int> = when (mode) {
        ChordMode.Normal -> listOf(0, 2, 4)
        ChordMode.Suspended4 -> listOf(0, 3, 4)
        ChordMode.Suspended2 -> listOf(0, 1, 4)
        ChordMode.Augmented -> listOf(0, 2, 4)
        ChordMode.Diminished -> listOf(0, 2, 4)
    }
    val notes: List<Note> =
        MajorScale(base).notes.filterIndexed { idx, _ -> pattern.contains(idx) }.mapIndexed { idx, note ->
            if (idx == 1)
                if ((type == ChordType.Minor && mode == ChordMode.Normal) || mode == ChordMode.Diminished) Note.values()[(note.ordinal - 1) % Note.values().size] else note
            else if (idx == 2)
                if (mode == ChordMode.Diminished) Note.values()[(note.ordinal - 1) % Note.values().size]
                else if (mode == ChordMode.Augmented) Note.values()[(note.ordinal + 1) % Note.values().size]
                else note
            else note
        }

    val name = "${base.display}${mode.display}${when (type) {
        ChordType.Major -> ""
        ChordType.Minor -> "#"
    }
    }"

    fun printNotes(): String = notes.joinToString{ it.display }
}

enum class ChordType {
    Major,
    Minor
}

enum class ChordMode(val display: String) {
    Normal(""),
    Suspended4("sus4"),
    Suspended2("sus2"),
    Augmented("aug"),
    Diminished("dim")
}
