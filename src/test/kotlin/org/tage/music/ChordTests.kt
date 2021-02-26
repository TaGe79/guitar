package org.tage.music

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

/**
 *
 */
class ChordTests {
    private val log = LoggerFactory.getLogger(javaClass)

    @Test
    fun verifyAMajorChord() {
        val aMajorChord = Chord(Note.A)
        Assertions.assertEquals(
            aMajorChord.notes.size,
            aMajorChord.notes.filter { listOf(Note.A, Note.CSharp, Note.E).contains(it) }.size
        )
    }
}
