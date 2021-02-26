/**
 *
 */
package org.tage.guitar

import org.tage.music.Chord
import org.tage.music.Note
import org.tage.music.scales.Scale

/**
 *
 */
class Guitar(val openStringNotes: Array<Note>, val fretCount: Int = 15) {
    val separator = "\n       ${IntRange(0, fretCount).map { "│         " }.joinToString("") { it }}\n"
    val strings: List<GuitarString> =
        openStringNotes.mapIndexed { idx, note -> GuitarString(openStringNotes.size - idx, note, fretCount) }

    fun displayChord(chord: Chord): String {
        val notes = chord.notes
        val identifiedNotes = mutableMapOf<Int, Set<Note>>()


        return strings.reversed().mapIndexed { idx, string ->
            (if (string.open == chord.base && identifiedNotes.values.none { foundNotes -> foundNotes.contains(string.open) }) string.highlight()
            else if (string.open != chord.base && identifiedNotes.values.any { foundNotes -> foundNotes.contains(string.open) }) string.ignore()
            else if (notes.contains(string.open)) string.highlight()
            else if (!string.frets.map { it.note }.any { notes.contains(it) }) string.ignore()
            else string.normal()) + string.frets.map {
                if (notes.contains(it.note) && identifiedNotes.get(it.num)?.contains(it.note) != true) {
                    identifiedNotes.compute(
                        it.num
                    ) { _, notes ->
                        if (notes == null) mutableSetOf(it.note) else {
                            (notes as MutableSet<Note>).add(it.note); notes
                        }
                    }
                    it.highlight()
                } else it.hide()
            }.joinToString("").let(prettifyGuitarBorders(idx))
        }.joinToString(separator)
    }

    private fun prettifyGuitarBorders(idx: Int): (String) -> String {
        return {
            if (idx == 0) it.replace("┼", "╤").replace("─", "═") + "╕" else
                if (idx == strings.size - 1)
                    it.replace("┼", "╧").replace("─", "═") + "╛"
                else
                    "$it┤"
        }
    }

    fun displayScale(scale: Scale): String = strings.reversed().mapIndexed { idx, it ->
        (if (scale.notes.contains(it.open)) it.highlight() else it.normal()) +
                it.frets.map {
                    if (scale.notes.contains(it.note))
                        if (scale.key == it.note) it.highlightRootNote() else it.highlight()
                    else it.hide()
                }.joinToString("").let(prettifyGuitarBorders(idx))
    }.joinToString(separator)

    override fun toString(): String {
        return strings.reversed().map{ "$it" }.mapIndexed{ idx, it -> it.let(prettifyGuitarBorders(idx)) }.joinToString(separator)
    }
}

val standard = Guitar(arrayOf(Note.E, Note.A, Note.D, Note.G, Note.B, Note.E))

data class GuitarString(val num: Int, val open: Note, val fretCount: Int) {
    val frets: List<Fret> =
        IntRange(1, fretCount).map { Fret(it, Note.values()[(open.ordinal + it) % Note.values().size]) }

    fun highlight(): String = open.display.padStart(4) + " o─"
    fun ignore(): String = open.display.padStart(4, ' ') + " ╳─"
    fun normal(): String = open.display.padStart(4, ' ') + "   "

    override fun toString(): String = normal() + frets.joinToString("")
}

data class Fret(val num: Int, val note: Note) {
    fun highlight(): String = "┼──${("[" + note.display + "]").padStart(4, '─')}───"
    fun highlightRootNote(): String = "┼──${("(" + note.display + ")").padStart(4, '─')}───"
    override fun toString(): String = "┼───${note.display.padStart(2, '─')}────"
    fun hide(): String = "┼─────────"
}

