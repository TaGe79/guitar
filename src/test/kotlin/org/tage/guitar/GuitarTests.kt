package org.tage.guitar

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.tage.music.Chord
import org.tage.music.ChordMode
import org.tage.music.ChordType
import org.tage.music.Note
import org.tage.music.scales.CMajor
import org.tage.music.scales.MinorScale

/**
 *
 */
class GuitarTests {
    private val log = LoggerFactory.getLogger(javaClass)

    @Test
    fun verify() {
        log.info("\n${standard}")
    }

    @Test
    fun displayAMajorChord() {
        log.info("\n${standard.displayChord(Chord(Note.A))}")
    }

    @Test
    fun displayAMinorChord() {
        val chord = Chord(Note.A, ChordType.Minor)
        log.info("See the ${chord.name} chord - ${chord.printNotes()}\n${standard.displayChord(chord)}")
    }

    @Test
    fun displayDMajorChord() {
        val chord = Chord(Note.D)
        log.info("See the ${chord.name} chord - ${chord.printNotes()}\n${standard.displayChord(chord)}")
    }

    @Test
    fun displayGMajorChord() {
        log.info("\n${standard.displayChord(Chord(Note.G))}")
    }

    @Test
    fun displayDSus4Chord() {
        val chord = Chord(Note.D,mode = ChordMode.Suspended4)
        log.info("See the ${chord.name} chord - ${chord.printNotes()}\n${standard.displayChord(chord)}")
    }

    @Test
    fun displayCMajorScale() {
        val scale = CMajor()
        log.info("See the C major scale: \n${standard.displayScale(scale)}")
    }

    @Test
    fun displayGMinorScale() {
        val scale = MinorScale(Note.G)
        log.info("See the G minor scale: \n${standard.displayScale(scale)}")
    }
}
