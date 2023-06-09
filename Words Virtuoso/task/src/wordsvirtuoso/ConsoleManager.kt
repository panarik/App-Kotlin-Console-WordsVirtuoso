package wordsvirtuoso

import wordsvirtuoso.dictionaryVerifications.wordsReader.Dictionary
import wordsvirtuoso.gameVerifications.GameData
import wordsvirtuoso.gameVerifications.GuessStringVerifications
import kotlin.random.Random

class ConsoleManager {

    fun startGame(candidates: Dictionary) {
        val gameData = GameData()
        gameData.secretWord = candidates.value[Random.nextInt(0, candidates.value.lastIndex)].lowercase()
        runStages(gameData)
    }

    private fun runStages(gameData: GameData) {
        while (true) {
            println("\nInput a 5-letter word:")
            gameData.input = readln()
            try {
                gameData.clue = GuessStringVerifications(gameData).getClue()
                println(gameData.clue)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            } catch (e: InterruptedException) {
                println(e.message)
                break
            }
        }
    }
}

