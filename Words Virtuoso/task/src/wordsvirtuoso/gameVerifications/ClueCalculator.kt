package wordsvirtuoso.gameVerifications

import wordsvirtuoso.gameVerifications.data.Color
import wordsvirtuoso.gameVerifications.data.GameData
import wordsvirtuoso.gameVerifications.data.Letter
import wordsvirtuoso.gameVerifications.data.Word

class ClueCalculator(private val gameData: GameData) {

    fun calculateClue() {
        val secret = gameData.secretWord
        val input = gameData.input
        val clueLetters: MutableList<Letter> = buildList {
            repeat(5) { add(Letter('_', Color("Grey", 192, 192, 192))) }
        }.toMutableList()
        for (inputIndex in input.indices) {
            val inputChar = input[inputIndex]
            when {

                // is same position case.
                secret[inputIndex] == inputChar -> clueLetters[inputIndex] = putGreen(inputChar)

                // is not a same position case.
                secret.contains(inputChar) -> clueLetters[inputIndex] = putYellow(inputChar)

                // is completely missed letter.
                else -> {
                    clueLetters[inputIndex] = putGrey(inputChar)
                    gameData.wrongLetters.add(putAzure(inputChar))
                }
            }
        }
        gameData.clue = Word(clueLetters)
        gameData.getGuessedAttempts().add(Word(clueLetters))
    }

    /**
     * ANSI - \u001B[48:5:10m
     */
    private fun putGreen(char: Char): Letter =
        Letter(char, Color("Green", 0, 255, 0))

    /**
     * ANSI - \u001B[48:5:11m
     */
    private fun putYellow(char: Char): Letter =
        Letter(char, Color("Yellow", 255, 255, 0))

    /**
     * ANSI - \u001B[48:5:7m
     */
    private fun putGrey(char: Char): Letter =
        Letter(char, Color("Grey", 192, 192, 192))

    private fun putAzure(char: Char): Letter =
        Letter(char, Color("Azure", 192, 192, 192))
}