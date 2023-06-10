package wordsvirtuoso.dictionaryVerifications

import wordsvirtuoso.wordRunner.VerifyRunner

class CheckWord(private val word: String, private val runner: VerifyRunner) {

    /**
     * Throws exception.
     */
    fun verify() {
        try {
            runner.verify(word)
        } catch (e: UninitializedPropertyAccessException) {
            return
        }
    }

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