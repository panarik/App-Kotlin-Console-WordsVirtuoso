package wordsvirtuoso.dictionaryVerifications

import wordsvirtuoso.config.ArgumentsConfig
import wordsvirtuoso.dictionaryVerifications.wordsReader.Dictionary
import wordsvirtuoso.dictionaryVerifications.wordsReader.WordsFileReader
import java.lang.RuntimeException
import kotlin.system.exitProcess

class GameBuilder(args: Array<String>) {

    private val words: Dictionary
    private val candidates: Dictionary

    init {
        try {
            val reader = WordsFileReader(ArgumentsConfig(args))
            words = reader.readWords()
            candidates = reader.readCandidates()
            checkInitData()
        } catch (e: RuntimeException) {
            println(e.message)
            exitProcess(-1)
        }
    }

    fun getWordsList(): Dictionary = words

    fun getCandidatesList(): Dictionary = candidates

    private fun checkInitData() {
        try {
            val wordsPassed = CheckDictionary().checkList(words)
            val candidatesPassed = CheckDictionary().checkList(candidates)
            val candidatesValid = CheckDictionary().checkWordsContain(candidates, words)
            if (wordsPassed && candidatesPassed && candidatesValid) println("Words Virtuoso")
            else println("Unknown error. Check game data.")
        } catch (e: RuntimeException) {
            println(e.message)
            exitProcess(-1)
        }

    }

}