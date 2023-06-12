package wordsvirtuoso.gameVerifications

import wordsvirtuoso.ConsoleColorPrinter
import wordsvirtuoso.gameVerifications.data.GameData

class GameStateVerifications(private val gameData: GameData) {

    fun createStageMessage(): String {
        return if (isWon(gameData.input)) throw InterruptedException(endGameMessage())
        else endStepMessage()
    }

    private fun isWon(input: String): Boolean = input == gameData.secretWord

    private fun endStepMessage(): String {
        val message = StringBuilder(guessedAttemptsMessage())
        gameData.getUniqueWrongLetters().forEach { message.append(ConsoleColorPrinter().print(it)) }
        return message.toString()
    }

    private fun endGameMessage(): String {
        val message = StringBuilder(guessedAttemptsMessage())
        message.append("Correct!\n")
        if (gameData.getGuessedAttempts().size < 2) {
            message.append("Amazing luck! The solution was found at once.")
        } else {
            message.append(
                "The solution was found after ${gameData.getGuessedAttempts().size} tries in ${
                    (System.currentTimeMillis() - gameData.startTime) / 1000
                } seconds."
            )
        }
        return message.toString()
    }

    private fun guessedAttemptsMessage(): String {
        val message = StringBuilder()
        gameData.getGuessedAttempts().forEach { message.append("${ConsoleColorPrinter().print(it)}\n") }
        message.append("\n")
        return message.toString()
    }

}