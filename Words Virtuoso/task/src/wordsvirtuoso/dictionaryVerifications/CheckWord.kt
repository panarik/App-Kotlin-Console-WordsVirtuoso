package wordsvirtuoso.dictionaryVerifications

import wordsvirtuoso.wordRunner.VerifyRunner

class CheckWord(private val word: String, val runner:VerifyRunner) {

    fun isValid(): Boolean {
        try {
            runner.verify(word)
        } catch (e: IllegalArgumentException) {
            return false
        } catch (e: UninitializedPropertyAccessException) {
            return true
        }
        return true
    }

}