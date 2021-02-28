package org.tage.music

import com.fasterxml.jackson.annotation.JsonValue

enum class Note(@JsonValue val display: String,
                val alternate: String = display,
                val halfNote: Boolean = false) {
  C("C"),
  CSharp("C#", "D♭", true),
  D("D"),
  DSharp("D#", "E♭", true),
  E("E"),
  F("F"),
  FSharp("F#", "G♭", true),
  G("G"),
  GSharp("G#", "A♭", true),
  A("A"),
  ASharp("A#", "B♭", true),
  B("B");

  operator fun minus(halfStep: Int): Note = values()[(this.ordinal - halfStep) % values().size]
  operator fun plus(halfStep: Int): Note = values()[(this.ordinal + halfStep) % values().size]
}
