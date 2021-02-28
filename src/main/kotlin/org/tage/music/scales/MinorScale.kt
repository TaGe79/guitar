package org.tage.music.scales

import org.tage.music.Note

/**
 *
 */
open class MinorScale(key: Note) : Scale(
    key,
    listOf(
        Step.WHOLE,
        Step.HALF,
        Step.WHOLE,
        Step.WHOLE,
        Step.HALF,
        Step.WHOLE,
        Step.WHOLE
    )
)

class NaturalMinor() : MinorScale(Note.A)

class MinorPentatonic(key: Note) : Scale(
    key,
    listOf(
        Step.WHOLE_AND_A_HALF,
        Step.WHOLE,
        Step.WHOLE,
        Step.WHOLE_AND_A_HALF,
        Step.WHOLE
    )
)
