package wordsvirtuoso.dictionaryVerifications.verifications

import wordsvirtuoso.dictionaryVerifications.verifications.data.Request

interface VerificationsChain {

    fun setErrorMessage(message:String)

    fun nextChain(chain: VerificationsChain)

    fun verify(request: Request)

}