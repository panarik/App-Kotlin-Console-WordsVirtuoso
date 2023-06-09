package wordsvirtuoso.dictionaryVerifications

import wordsvirtuoso.wordRunner.VerifyRunner

class CheckWord(private val word: String, private val runner: VerifyRunner) {

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

    /**
     * Returns error message if error was cached. Otherwise, returns null.
     */
    fun verify(): String? {
        try {
            runner.verify(word)
        } catch (e: IllegalArgumentException) {
            return e.message
        } catch (e: UninitializedPropertyAccessException) {
            return null
        }
        return null
    }

}