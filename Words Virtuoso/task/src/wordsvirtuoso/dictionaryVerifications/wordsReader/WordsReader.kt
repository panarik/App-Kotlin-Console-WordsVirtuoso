package wordsvirtuoso.dictionaryVerifications.wordsReader

interface WordsReader {

    fun readWords(): Dictionary

    fun readCandidates(): Dictionary

}