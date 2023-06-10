package wordsvirtuoso.gameVerifications

import wordsvirtuoso.gameVerifications.data.GameData

class GameStateVerifications(private val gameData: GameData) {

    fun verify() {
        if (isWon(gameData.input)) throw InterruptedException(endGameMessage())
    }

    private fun isWon(input: String): Boolean = input == gameData.secretWord

    private fun endGameMessage(): String {
        val message = StringBuilder()
        message.append("\n${gameData.getGuessedAttempts()}")
        message.append("\n\nCorrect!\n")
        if (gameData.guessedAttempts.size < 2) {
            message.append("Amazing luck! The solution was found at once.")
        } else {
            message.append(
                "The solution was found after ${gameData.guessedAttempts.size} tries in ${
                    (System.currentTimeMillis() - gameData.startTime) / 1000
                } seconds."
            )
        }
        return message.toString()
    }
}