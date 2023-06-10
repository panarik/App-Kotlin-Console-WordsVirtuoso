package wordsvirtuoso.gameVerifications.data

import wordsvirtuoso.dictionaryVerifications.wordsReader.Dictionary

class GameData(val words: Dictionary, val startTime: Long) {

    var clue: String = "_____"
    var input: String = ""
    var secretWord: String = ""
    val guessedAttempts = mutableListOf<String>()
    val wrongLetters = mutableListOf<Char>()

    fun getGuessedAttempts(): String =
        guessedAttempts.joinToString("\n")

    fun getUniqueWrongLetters(): String =
        wrongLetters.toSet().toList().sorted().joinToString("")
}

