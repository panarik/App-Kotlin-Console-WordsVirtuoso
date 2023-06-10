package wordsvirtuoso.dictionaryVerifications.verifications

import wordsvirtuoso.dictionaryVerifications.verifications.data.Request
import wordsvirtuoso.gameVerifications.data.GameData

class ContainsVerification(val gameData: GameData) : VerificationsChain {

    private lateinit var nextChain: VerificationsChain
    private var errorMessage = "The input word isn't included in my words list."

    override fun setErrorMessage(message: String) {
        errorMessage = message
    }

    override fun nextChain(chain: VerificationsChain) {
        nextChain = chain
    }

    override fun verify(request: Request) {
        if (!gameData.words.value.contains(request.word)) throw IllegalArgumentException(errorMessage)
    }

}