package wordsvirtuoso.dictionaryVerifications.wordsReader

import wordsvirtuoso.config.Config
import java.io.File
import java.nio.file.FileSystemNotFoundException

class WordsFileReader(private val config: Config) : WordsReader {

    override fun readWords(): Dictionary {
        val wordsFile = File(config.getWordsPath())
        if (wordsFile.exists()) return Dictionary(config.getWordsPath(), wordsFile.readLines())
        else throw FileSystemNotFoundException("Error: The words file ${config.getWordsPath()} doesn't exist.")
    }

    override fun readCandidates(): Dictionary {
        val candidatesFile = File(config.getCandidatesPath())
        if (candidatesFile.exists()) return Dictionary(config.getCandidatesPath(), candidatesFile.readLines())
        else throw FileSystemNotFoundException("Error: The candidate words file ${config.getCandidatesPath()} doesn't exist.")
    }

}