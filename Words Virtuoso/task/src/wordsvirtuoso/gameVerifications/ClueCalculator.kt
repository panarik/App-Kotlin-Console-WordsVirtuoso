package wordsvirtuoso.gameVerifications

import wordsvirtuoso.gameVerifications.data.GameData

class ClueCalculator(private val gameData: GameData) {

    fun calculateClue() {
        val secret = gameData.secretWord
        val input = gameData.input
        val clue = "_____".toMutableList()
        for (inputIndex in input.indices) {
            when {

                // Same position case.
                secret[inputIndex] == input[inputIndex] -> {
                    clue[inputIndex] = input[inputIndex].uppercaseChar()
                }

                // Not a same position case.
                secret.contains(input[inputIndex]) -> {
                    clue[inputIndex] = input[inputIndex].lowercaseChar()
                }
            }
        }
        gameData.clue = clue.joinToString("")
        gameData.wrongGuessList.add(gameData.clue)
    }

}