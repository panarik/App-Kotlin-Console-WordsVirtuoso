package wordsvirtuoso.dictionaryVerifications.verifications

import wordsvirtuoso.dictionaryVerifications.verifications.data.Request

class DuplicateVerification : VerificationsChain {

    private lateinit var nextChain: VerificationsChain

    override fun nextChain(chain: VerificationsChain) {
        this.nextChain = chain
    }

    override fun verify(request: Request) {
        val uniques = mutableListOf<Char>()
        request.word.forEach {
            if (uniques.contains(it)) throw IllegalArgumentException("The input has duplicate letters.")
            else uniques.add(it)
        }
        nextChain.verify(request)
    }
}