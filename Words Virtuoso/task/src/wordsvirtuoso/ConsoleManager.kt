package wordsvirtuoso

import wordsvirtuoso.dictionaryVerifications.wordsReader.Dictionary
import wordsvirtuoso.gameVerifications.data.GameData
import wordsvirtuoso.gameVerifications.GameStage
import kotlin.random.Random

class ConsoleManager {

    fun startGame(candidates: Dictionary, words: Dictionary) {
        val gameData = GameData(words, System.currentTimeMillis())
        gameData.secretWord = getRandomWord(candidates)
        runStages(gameData)
    }

    private fun runStages(gameData: GameData) {
        while (true) {
            println("\nInput a 5-letter word: (secret ${gameData.secretWord})")
            gameData.input = readln()
            try {
                println(GameStage(gameData).runStage())
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            } catch (e: InterruptedException) {
                println(e.message)
                break
            }
        }
    }

    private fun getRandomWord(dictionary: Dictionary): String =
        if (dictionary.value.size > 1)
            dictionary.value[Random.nextInt(0, dictionary.value.lastIndex + 1)].lowercase()
        else dictionary.value.first().lowercase()

}

