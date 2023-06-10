package wordsvirtuoso.gameVerifications

import wordsvirtuoso.dictionaryVerifications.CheckWord
import wordsvirtuoso.gameVerifications.data.GameData
import wordsvirtuoso.wordRunner.VerifyGuessStringRunner

/**
 * Stage with user input word verifications.
 */
class GameStage(private val gameData: GameData) {

    /**
     * If input hase some actions will throw InterruptedException.
     */
    fun runStage(): String {
        UserActionVerifications(gameData).verify() // InterruptedException
        GameStateVerifications(gameData).verify() // InterruptedException
        CheckWord(gameData.input, VerifyGuessStringRunner(gameData)).verify() // IllegalArgumentException
        ClueCalculator(gameData).calculateClue()
        return endStepMessage()
    }

    private fun endStepMessage(): String {
        val messageBuilder = StringBuilder()
        messageBuilder.append(getWrongGuessList())
        return messageBuilder.toString()
    }

    private fun getWrongGuessList(): String =
        gameData.wrongGuessList.joinToString("\n")
}