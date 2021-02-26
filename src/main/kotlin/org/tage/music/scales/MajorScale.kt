package org.tage.music.scales

import org.tage.music.Note

object Step {
    val WHOLE: Int = 2
    val HALF: Int = 1
}

open class MajorScale(key: Note) : Scale(
    key,
    listOf(
        Step.WHOLE,
        Step.WHOLE,
        Step.HALF,
        Step.WHOLE,
        Step.WHOLE,
        Step.WHOLE,
        Step.HALF
    )
)

class CMajor() : MajorScale(Note.C)
class DMajor() : MajorScale(Note.D)
class EMajor() : MajorScale(Note.E)
