package wordsvirtuoso.gameVerifications

import wordsvirtuoso.dictionaryVerifications.CheckWord
import wordsvirtuoso.wordRunner.VerifyGuessStringRunner

class GuessStringVerifications(private val gameData: GameData) {

    fun getClue(): String =
        when {
            isExit(gameData.input) -> throw InterruptedException("The game is over.")
            isWon(gameData.input) -> throw InterruptedException("Correct!")
            else -> {
                isHaveErrors(gameData.input) ?: ClueCalculator(gameData).calculateClue()
            }
        }


    private fun isExit(input: String): Boolean = input == "exit"

    private fun isWon(input: String): Boolean = input == gameData.secretWord

    private fun isHaveErrors(input: String): String? =
        CheckWord(input, VerifyGuessStringRunner()).verify()

}