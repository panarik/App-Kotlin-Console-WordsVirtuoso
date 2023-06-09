package wordsvirtuoso.wordRunner

import wordsvirtuoso.dictionaryVerifications.verifications.DuplicateVerification
import wordsvirtuoso.dictionaryVerifications.verifications.EnglishVerification
import wordsvirtuoso.dictionaryVerifications.verifications.LengthVerification
import wordsvirtuoso.dictionaryVerifications.verifications.data.Request

/**
 * Run all possible verifications for Dictionary files.
 * @throws IllegalArgumentException if some verification fails.
 * Check message.
 */
class VerifyDictionaryRunner : VerifyRunner {

    override fun verify(word: String) {
        val request = Request(word) // Create verification request.

        // Create chain items.
        val initStep = LengthVerification()
        val englishStep = EnglishVerification()
        val duplicateStep = DuplicateVerification()

        // Create chain.
        initStep.nextChain(englishStep)
        englishStep.nextChain(duplicateStep)

        // Execute chain from init step.
        initStep.verify(request)
    }
}