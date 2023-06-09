package wordsvirtuoso.dictionaryVerifications

import wordsvirtuoso.dictionaryVerifications.verifications.VerifyRunner

class CheckWord(private val word: String) {

    fun isValid(): Boolean {
        try {
            VerifyRunner().verify(word)
        } catch (e: IllegalArgumentException) {
            return false
        } catch (e: UninitializedPropertyAccessException) {
            return true
        }
        return true
    }

}