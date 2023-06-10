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
        CheckWord(gameData.input, VerifyGuessStringRunner(gameData)).verify() // IllegalArgumentException
        ClueCalculator(gameData).calculateClue()
        GameStateVerifications(gameData).verify() // InterruptedException
        return endStepMessage()
    }

    private fun endStepMessage(): String {
        val messageBuilder = StringBuilder()
        messageBuilder.append("${gameData.getGuessedAttempts()}\n")
        messageBuilder.append("\n")
        messageBuilder.append("${gameData.getUniqueWrongLetters()}\n")
        return messageBuilder.toString()
    }
}