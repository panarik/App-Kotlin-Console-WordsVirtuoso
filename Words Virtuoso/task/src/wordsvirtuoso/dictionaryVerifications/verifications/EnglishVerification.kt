package wordsvirtuoso.dictionaryVerifications.verifications

import wordsvirtuoso.dictionaryVerifications.verifications.data.Request
import java.lang.IllegalStateException

class EnglishVerification : VerificationsChain {

    private lateinit var nextChain: VerificationsChain
    private var errorMessage = "The input has invalid characters."

    override fun setErrorMessage(message: String) {
        errorMessage = message
    }

    override fun nextChain(chain: VerificationsChain) {
        this.nextChain = chain
    }

    override fun verify(request: Request) {
        if (request.word.contains(Regex("[^A-Za-z]"))) throw IllegalArgumentException("The input has invalid characters.")
        nextChain.verify(request)
    }
}