package wordsvirtuoso.dictionaryVerifications

import wordsvirtuoso.dictionaryVerifications.wordsReader.Dictionary
import java.lang.IllegalStateException

class CheckDictionary {

    fun checkWordsContain(candidates: Dictionary, allWords: Dictionary): Boolean {
        var errorsScore = 0
        val wordsL = allWords.value.stream().map { it.lowercase() }.toList()
        val candidatesL = candidates.value.stream().map { it.lowercase() }
        candidatesL.forEach { if (!wordsL.contains(it)) errorsScore++ }
        return if (errorsScore == 0) true
        else throw IllegalStateException("Error: $errorsScore candidate words are not included in the ${allWords.name} file.")
    }

    fun checkList(dictionary: Dictionary): Boolean {
        var errorsScore = 0
        dictionary.value.forEach { if (!CheckWord(it).isValid()) errorsScore++ }
        return if (errorsScore == 0) true
        else throw IllegalStateException("Error: $errorsScore invalid words were found in the ${dictionary.name} file.")
    }

}