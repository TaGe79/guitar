package org.tage.music.scales

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.tage.music.Note

/**
 *
 */
class MajorScales {
    private val log = LoggerFactory.getLogger(javaClass)

    @Test
    fun verifyCMajorScale() {
        val cMajor = CMajor()
        val dMajor = DMajor()
        listOf(
            Note.C,
            Note.D,
            Note.E,
            Note.F,
            Note.G,
            Note.A,
            Note.B
        ).forEachIndexed { idx, note -> Assertions.assertEquals(note, cMajor[idx]) }
        listOf(
            Note.D,
            Note.E,
            Note.FSharp,
            Note.G,
            Note.A,
            Note.B,
            Note.CSharp
        ).forEachIndexed { idx, note -> Assertions.assertEquals(note, dMajor[idx]) }

        log.info("\n"+
            Note.values().map { MajorScale(it) }
                .joinToString("\n") { "${it.key}-major scale:".padEnd(30,' ')+"$it" })
    }
}
