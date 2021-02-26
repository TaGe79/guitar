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

class CMinor() : MinorScale(Note.C)
class DMinor() : MinorScale(Note.D)
class EMinor() : MinorScale(Note.E)

class NaturalMinor() : MinorScale(Note.A)
