package wordsvirtuoso.dictionaryVerifications.verifications

import wordsvirtuoso.dictionaryVerifications.verifications.data.Request

/**
 * Verifies input word length.
 */
class LengthVerification : VerificationsChain {

    private lateinit var nextChain: VerificationsChain
    private var errorMessage = "The input isn't a 5-letter string."

    override fun setErrorMessage(message: String) {
        errorMessage = message
    }

    override fun nextChain(chain: VerificationsChain) {
        this.nextChain = chain
    }

    /**
     * Verify that input word must be 5 chars length.
     */
    override fun verify(request: Request) {
        if (request.word.length != 5) throw IllegalArgumentException(errorMessage)
        nextChain.verify(request)
    }

}