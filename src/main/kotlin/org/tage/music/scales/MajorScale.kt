package org.tage.music.scales

import org.tage.music.Note

object Step {
    const val WHOLE_AND_A_HALF = 3
    const val WHOLE: Int = 2
    const val HALF: Int = 1

}

open class MajorScale(key: Note, mode: MajorScaleMode = MajorScaleMode.IONIAN) : Scale(
    key,
    mode.steps
)

enum class MajorScaleMode(val steps: List<Int>, val musicalStyles: List<MusicalStyle>) {
    IONIAN(listOf(
        Step.WHOLE,
        Step.WHOLE,
        Step.HALF,
        Step.WHOLE,
        Step.WHOLE,
        Step.WHOLE,
        Step.HALF
    ), listOf(MusicalStyle.Rock, MusicalStyle.Country, MusicalStyle.Jazz, MusicalStyle.Fusion)),
    DORIAN(listOf(
        Step.WHOLE,
        Step.HALF,
        Step.WHOLE,
        Step.WHOLE,
        Step.WHOLE,
        Step.HALF,
        Step.WHOLE
    ), listOf(MusicalStyle.Jazz, MusicalStyle.Fusion, MusicalStyle.Blues, MusicalStyle.Rock)),
    PHRYGIAN(listOf(
        Step.HALF,
        Step.WHOLE,
        Step.WHOLE,
        Step.WHOLE,
        Step.HALF,
        Step.WHOLE,
        Step.WHOLE
    ), listOf(MusicalStyle.Flamenco, MusicalStyle.Fusion, MusicalStyle.Speed_Metal)),
    LYDIAN(listOf(
        Step.WHOLE,
        Step.WHOLE,
        Step.WHOLE,
        Step.HALF,
        Step.WHOLE,
        Step.WHOLE,
        Step.HALF
    ),listOf(MusicalStyle.Jazz,MusicalStyle.Fusion,MusicalStyle.Rock,MusicalStyle.Country)),
    MIXOLYDIAN(listOf(
        Step.WHOLE,
        Step.WHOLE,
        Step.HALF,
        Step.WHOLE,
        Step.WHOLE,
        Step.HALF,
        Step.WHOLE
    ), listOf(MusicalStyle.Blues,MusicalStyle.Country,MusicalStyle.Rockabilly, MusicalStyle.Rock)),
    AEOLIAN(listOf(
        Step.WHOLE,
        Step.HALF,
        Step.WHOLE,
        Step.WHOLE,
        Step.HALF,
        Step.WHOLE,
        Step.WHOLE
    ), listOf(MusicalStyle.Pop,MusicalStyle.Blues,MusicalStyle.Rock, MusicalStyle.Heavy_Metal, MusicalStyle.Country, MusicalStyle.Fusion)),
    LOCRIAN(listOf(
        Step.HALF,
        Step.WHOLE,
        Step.WHOLE,
        Step.HALF,
        Step.WHOLE,
        Step.WHOLE,
        Step.WHOLE
    ), listOf(MusicalStyle.Jazz, MusicalStyle.Fusion)),
}

enum class MusicalStyle {
    Jazz, Fusion, Blues, Rock,Flamenco, Speed_Metal, Country, Rockabilly, Pop, Heavy_Metal
}
