package wordsvirtuoso

import wordsvirtuoso.dictionaryVerifications.wordsReader.Dictionary
import wordsvirtuoso.gameVerifications.data.GameData
import wordsvirtuoso.gameVerifications.GuessStringVerifications
import kotlin.random.Random

class ConsoleManager {

    fun startGame(candidates: Dictionary, words: Dictionary) {
        val gameData = GameData(words)
        gameData.secretWord = getRandomInput(candidates)
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

    private fun getRandomInput(dictionary: Dictionary): String =
        if (dictionary.value.size > 1)
            dictionary.value[Random.nextInt(0, dictionary.value.lastIndex)].lowercase()
        else dictionary.value.first().lowercase()

}

