package wordsvirtuoso

import wordsvirtuoso.gameVerifications.data.Color
import wordsvirtuoso.gameVerifications.data.Letter
import wordsvirtuoso.gameVerifications.data.Word

class ConsoleColorPrinter {

    private val ansiMap = mapOf(
        Color("Green", 0, 255, 0) to "\u001B[48:5:10m",
        Color("Yellow", 255, 255, 0) to "\u001B[48:5:11m",
        Color("Grey", 192, 192, 192) to "\u001B[48:5:7m",
        Color("Azure", 192, 192, 192) to "\u001B[48:5:14m"
    )

    fun print(word: Word): String {
        val result = StringBuilder()
        word.letters.forEach { result.append(print(it)) }
        return result.toString()
    }

    fun print(letter: Letter): String =
        "${getANSIColor(letter.color)}${letter.label.uppercase()}\u001B[0m"

    private fun getANSIColor(color: Color): String =
        ansiMap[color] ?: throw InterruptedException("Cant map $color color.")

}