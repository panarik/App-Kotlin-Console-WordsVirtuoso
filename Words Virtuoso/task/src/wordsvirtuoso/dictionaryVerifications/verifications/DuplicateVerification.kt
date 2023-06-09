package wordsvirtuoso.dictionaryVerifications.verifications

import wordsvirtuoso.dictionaryVerifications.verifications.data.Request

class DuplicateVerification : VerificationsChain {

    private lateinit var nextChain: VerificationsChain
    private var errorMessage = "The input has duplicate letters."

    override fun setErrorMessage(message: String) {
        errorMessage = message
    }

    override fun nextChain(chain: VerificationsChain) {
        this.nextChain = chain
    }

    override fun verify(request: Request) {
        val uniques = mutableListOf<Char>()
        request.word.forEach {
            if (uniques.contains(it)) throw IllegalArgumentException(errorMessage)
            else uniques.add(it)
        }
        nextChain.verify(request)
    }
}