package wordsvirtuoso.gameVerifications

import wordsvirtuoso.gameVerifications.data.GameData

class ClueCalculator(private val gameData: GameData) {

    fun calculateClue() {
        val secret = gameData.secretWord
        val input = gameData.input
        val clue = "_____".toMutableList()
        for (inputIndex in input.indices) {
            val inputChar = input[inputIndex]
            when {

                // is same position case.
                secret[inputIndex] == inputChar -> {
                    clue[inputIndex] = inputChar.uppercaseChar()
                }

                // is not a same position case.
                secret.contains(inputChar) -> {
                    val currentLetter = inputChar.lowercaseChar()
                    clue[inputIndex] = currentLetter
                }

                // is completely missed letter.
                else -> gameData.wrongLetters.add(inputChar.uppercaseChar())
            }
        }
        gameData.clue = clue.joinToString("")
        gameData.guessedAttempts.add(gameData.clue)
    }

}