package wordsvirtuoso.gameVerifications.data

import wordsvirtuoso.dictionaryVerifications.wordsReader.Dictionary

class GameData(val words: Dictionary, val startTime: Long) {

    lateinit var clue: Word
    var input: String = ""
    var secretWord: String = ""
    private val guessedAttempts = mutableListOf<Word>()
    val wrongLetters = mutableListOf<Letter>()

    fun getGuessedAttempts(): MutableList<Word> = guessedAttempts

    fun getUniqueWrongLetters(): List<Letter> =
        wrongLetters.toSet().toList().sortedBy { it.label }
}

