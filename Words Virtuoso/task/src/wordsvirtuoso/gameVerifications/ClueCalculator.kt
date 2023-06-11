package wordsvirtuoso.gameVerifications

import wordsvirtuoso.gameVerifications.data.GameData
import wordsvirtuoso.gameVerifications.data.Letter
import wordsvirtuoso.gameVerifications.data.Word

class ClueCalculator(private val gameData: GameData) {

    fun calculateClue() {
        val secret = gameData.secretWord
        val input = gameData.input
        val clueLetters: MutableList<Letter> = buildList {
            repeat(5) { add(Letter('_', "")) }
        }.toMutableList()
        for (inputIndex in input.indices) {
            val inputChar = input[inputIndex]
            when {

                // is same position case.
                secret[inputIndex] == inputChar -> clueLetters[inputIndex] = putGreen(inputChar)

                // is not a same position case.
                secret.contains(inputChar) -> clueLetters[inputIndex] = putYellow(inputChar)

                // is completely missed letter.
                else -> gameData.wrongLetters.add(putGrey(inputChar))
            }
        }
        gameData.clue = Word(clueLetters)
        gameData.guessedAttempts.add(Word(clueLetters))
    }

    private fun putGreen(char: Char): Letter =
        Letter(char, "\u001B[48:5:10m${char.uppercase()}\u001B[0m")

    private fun putYellow(char: Char): Letter =
        Letter(char, "\u001B[48:5:11m${char.uppercase()}\u001B[0m")

    private fun putGrey(char: Char): Letter =
        Letter(char, "\u001B[48:5:7m${char.uppercase()}\u001B[0m")
}