package org.tage.music

enum class Note(val display: String, val alternate: String = display, val halfStep: Int = 1) {
    C("C"),
    CSharp("C#", "D♭"),
    D("D"),
    DSharp("D#", "E♭"),
    E("E"),
    F("F"),
    FSharp("F#", "G♭"),
    G("G"),
    GSharp("G#", "A♭"),
    A("A"),
    ASharp("A#", "B♭"),
    B("B")
}
