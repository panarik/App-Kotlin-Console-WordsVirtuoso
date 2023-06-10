package wordsvirtuoso.wordRunner

import wordsvirtuoso.dictionaryVerifications.verifications.ContainsVerification
import wordsvirtuoso.dictionaryVerifications.verifications.DuplicateVerification
import wordsvirtuoso.dictionaryVerifications.verifications.EnglishVerification
import wordsvirtuoso.dictionaryVerifications.verifications.LengthVerification
import wordsvirtuoso.dictionaryVerifications.verifications.data.Request
import wordsvirtuoso.gameVerifications.data.GameData

/**
 * Run all possible verifications for game input words.
 * @throws IllegalArgumentException if some verification fails.
 */
class VerifyGuessStringRunner(val gameData: GameData) : VerifyRunner {

    override fun verify(word: String) {

        // Create chain items.
        val initStep = LengthVerification()
        initStep.setErrorMessage("The input isn't a 5-letter word.")

        val englishStep = EnglishVerification()
        englishStep.setErrorMessage("One or more letters of the input aren't valid.")

        val duplicateStep = DuplicateVerification()
        val notContainsInDictionaryStep = ContainsVerification(gameData)

        // Create chain.
        initStep.nextChain(englishStep)
        englishStep.nextChain(duplicateStep)
        duplicateStep.nextChain(notContainsInDictionaryStep)

        // Execute chain from init step.
        initStep.verify(Request(word))
    }

}