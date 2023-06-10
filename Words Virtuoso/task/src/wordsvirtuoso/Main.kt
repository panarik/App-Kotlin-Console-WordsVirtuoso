package wordsvirtuoso

import wordsvirtuoso.dictionaryVerifications.GameBuilder

fun main(args: Array<String>) {

    val gameBuilder = GameBuilder(args)
    val words = gameBuilder.getWordsList()
    val candidates = gameBuilder.getCandidatesList()

    ConsoleManager().startGame(candidates, words)
}



