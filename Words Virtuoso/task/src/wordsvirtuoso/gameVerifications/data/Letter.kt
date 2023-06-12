package wordsvirtuoso.gameVerifications.data

data class Letter(val label: Char, val color: Color) {

    override fun hashCode(): Int {
        return label.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Letter

        return label == other.label
    }
}