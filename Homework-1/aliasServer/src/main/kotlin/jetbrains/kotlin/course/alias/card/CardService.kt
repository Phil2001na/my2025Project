package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.IdentifierFactory
import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.words
import org.springframework.stereotype.Service

@Service
class CardService {
    private val identifierFactory = IdentifierFactory()
    private val cards: List<Card> = generateCards()

    companion object {
        const val WORDS_IN_CARD = 4
        val cardsAmount = words.size / WORDS_IN_CARD
    }

    private fun generateCards(): List<Card> {
        // Shuffle the list of words
        val shuffledWords = words.shuffled()

        // Split the shuffled words into chunks of WORDS_IN_CARD size
        val chunks = shuffledWords.chunked(WORDS_IN_CARD)

        // Take only the first 'cardsAmount' chunks
        return chunks.take(cardsAmount).map { chunk ->
            // For each chunk, create a new Card object with a unique ID
            val cardId = identifierFactory.uniqueIdentifier()
            val wordList = chunk.toWords()
            Card(cardId, wordList)
        }
    }

    private fun List<String>.toWords(): List<Word> {
        return this.map { word -> Word(word) }
    }

    fun getCardByIndex(index: Int): Card {
        return cards.getOrNull(index) ?: throw IllegalArgumentException("Card not found!")

}
}