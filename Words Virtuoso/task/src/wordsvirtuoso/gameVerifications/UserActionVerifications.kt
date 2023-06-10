package wordsvirtuoso.gameVerifications

import wordsvirtuoso.gameVerifications.data.GameData

class UserActionVerifications(private val gameData: GameData) {

    fun verify() {
        if (isExit(gameData.input)) throw InterruptedException("The game is over.")

    }

    private fun isExit(input: String): Boolean = input == "exit"

}