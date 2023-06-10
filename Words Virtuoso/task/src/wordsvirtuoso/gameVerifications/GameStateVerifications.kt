package wordsvirtuoso.gameVerifications

import wordsvirtuoso.gameVerifications.data.GameData

class GameStateVerifications(val gameData: GameData) {

    fun verify() {
        if (isWon(gameData.input)) throw InterruptedException(endGameMessage())
    }

    private fun isWon(input: String): Boolean = input == gameData.secretWord

    private fun endGameMessage(): String {
        val message = StringBuilder()
        message.append("Correct!\n")
        if (gameData.wrongGuessList.size == 0) {
            message.append("Amazing luck! The solution was found at once.")
        } else {
            message.append(
                "The solution was found after ${gameData.wrongGuessList.size} tries in ${
                    (System.currentTimeMillis() - gameData.startTime) / 1000
                } seconds."
            )
        }
        return message.toString()
    }
}