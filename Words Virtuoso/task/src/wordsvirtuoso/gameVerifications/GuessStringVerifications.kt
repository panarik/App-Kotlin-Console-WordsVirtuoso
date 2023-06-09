package wordsvirtuoso.gameVerifications

class GuessStringVerifications(private val gameData: GameData) {

    fun getClue(): String {
        return when {
            isExit(gameData.input) -> throw InterruptedException("The game is over.")
            isWon(gameData.input) -> throw InterruptedException("Correct!")
            isWrongLength(gameData.input) -> throw IllegalArgumentException("The input isn't a 5-letter word.")
//            isValidCharacters(gameData.input) -> throw IllegalArgumentException("One or more letters of the input aren't valid.")
            else -> ClueCalculator(gameData).calculateClue()
        }
    }

    private fun isWrongLength(input: String): Boolean = input.length != 5

    private fun isExit(input: String): Boolean = input == "exit"

    private fun isWon(input: String): Boolean = input == gameData.secretWord

}