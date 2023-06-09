package wordsvirtuoso.config

class ArgumentsConfig(params: Array<String>) : Config {

    private var allWordsPath = ""
    private var candidatesPath = ""

    init {
        if (params.size != 2) throw IllegalArgumentException("Error: Wrong number of arguments.")
        for (param in params) {
            allWordsPath = Regex(".*?words.+").matchEntire(param)?.value ?: params[0]
            candidatesPath = Regex(".*?candidates.+").matchEntire(param)?.value ?: params[1]
            if (allWordsPath.isEmpty() || candidatesPath.isEmpty()) throw IllegalStateException("Cant parse parameters.")
        }
    }

    override fun getWordsPath(): String = allWordsPath

    override fun getCandidatesPath(): String = candidatesPath
}