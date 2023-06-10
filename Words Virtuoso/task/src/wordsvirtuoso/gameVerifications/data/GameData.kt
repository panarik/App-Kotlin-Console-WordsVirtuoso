package wordsvirtuoso.gameVerifications.data

import wordsvirtuoso.dictionaryVerifications.wordsReader.Dictionary

class GameData(val words: Dictionary) {

    var clue: String = "_____"
    var input: String = ""
    var secretWord: String = ""
}

