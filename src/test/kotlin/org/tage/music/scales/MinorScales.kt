package org.tage.music.scales

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

/**
 *
 */
class MinorScales {
    private val log = LoggerFactory.getLogger(javaClass)

    @Test
    fun verifyCMinorScale() {
        log.info("See the C Minor scale:\n${CMinor()}")
    }

    @Test
    fun verifyNaturalMinorScale() {
        log.info("See the natural minor scale:\n ${NaturalMinor()}")
    }
}
