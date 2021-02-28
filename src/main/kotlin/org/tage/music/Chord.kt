package org.tage.music

import org.tage.music.scales.MajorScale

/**
 *
 */
data class Chord(val base: Note, val type: ChordType = ChordType.Major, val mode: ChordMode = ChordMode.Normal) {
  private val pattern: List<Int> = when (mode) {
    ChordMode.Normal -> listOf(1, 3, 5)
    ChordMode.Suspended4 -> listOf(1, 4, 5)
    ChordMode.Suspended2 -> listOf(1, 2, 5)
    ChordMode.Augmented -> listOf(1, 3, 5)
    ChordMode.Diminished -> listOf(1, 3, 5)
    ChordMode.Eleventh -> listOf(1, 3, 11)
    ChordMode.Seventh -> listOf(1, 3, 5, 7)
    ChordMode.DominantSeventh -> listOf(1, 3, 5, 7)
  }

  val notes: List<Note> =
      MajorScale(base).notes.filterIndexed { idx, _ -> pattern.contains(idx + 1) }.mapIndexed { idx, note ->
          when (idx) {
            1 -> when {
                type == ChordType.Minor && mode == ChordMode.Normal || mode == ChordMode.Diminished -> Note.values()[(note.ordinal - 1) % Note.values().size]
                else -> note
            }
            2 -> when (mode) {
                ChordMode.Diminished -> Note.values()[(note.ordinal - 1) % Note.values().size]
                ChordMode.Augmented -> Note.values()[(note.ordinal + 1) % Note.values().size]
                else -> note
            }
            3 -> when (mode) {
                ChordMode.DominantSeventh -> Note.values()[(note.ordinal - 1) % Note.values().size]
                else -> note
            }
            else -> note
          }
      }

  val name = "${base.display}${mode.display}${when (type) {
    ChordType.Major -> ""
    ChordType.Minor -> "#"
  }
  }"

  fun printNotes(): String = notes.joinToString { it.display }
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
  Diminished("dim"),
  Eleventh("11"),
  Seventh("maj7"),
  DominantSeventh("7")
}
