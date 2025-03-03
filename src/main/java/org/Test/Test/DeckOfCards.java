package org.Test.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DeckOfCards_DecksTest {

    private DeckOfCards_Decks deckOfCards;
    private String deckId;

    @BeforeEach
    void setUp() {
        deckOfCards = new DeckOfCards_Decks();
        deckId = deckOfCards.getNewDeck(1, "false");
    }

    @Test
    void testShuffleDeck() {
        assertTrue(deckOfCards.shuffleDeck(deckId));
    }

    @Test
    void testDrawCards() {
        List<String> drawnCards = deckOfCards.drawCards(deckId, 5);
        assertEquals(5, drawnCards.size());
    }

    @Test
    void testAddToDiscardPile() {
        List<String> drawnCards = deckOfCards.drawCards(deckId, 3);
        assertTrue(deckOfCards.addToDiscardPile(deckId, drawnCards));
        List<String> discardPile = deckOfCards.getDiscardPile(deckId);
        assertEquals(drawnCards, discardPile);
    }

    @Test
    void testGetDiscardPile_Empty() {
        List<String> discardPile = deckOfCards.getDiscardPile(deckId);
        assertTrue(discardPile == null || discardPile.isEmpty());
    }

    @Test
    void testGetDiscardPile_NotEmpty() {
        List<String> drawnCards = deckOfCards.drawCards(deckId, 3);
        deckOfCards.addToDiscardPile(deckId, drawnCards);
        List<String> discardPile = deckOfCards.getDiscardPile(deckId);
        assertEquals(drawnCards, discardPile);
    }

    @Test
    void testReturnCardsToDeck() {
        List<String> drawnCards = deckOfCards.drawCards(deckId, 3);
        deckOfCards.addToDiscardPile(deckId, drawnCards);
        assertTrue(deckOfCards.returnCardsToDeck(deckId, drawnCards));
        assertTrue(deckOfCards.getDiscardPile(deckId).isEmpty());
        assertEquals(52, deckOfCards.getRemainingCardsInDeck(deckId));
    }

    @Test
    void testGetRemainingCardsInDeck_Initial() {
        assertEquals(52, deckOfCards.getRemainingCardsInDeck(deckId));
    }

    @Test
    void testGetRemainingCardsInDeck_AfterDraw() {
        deckOfCards.drawCards(deckId, 5);
        assertEquals(47, deckOfCards.getRemainingCardsInDeck(deckId));
    }

    @Test
    void testGetRemainingCardsInDeck_AfterDiscardAndReturn() {
        List<String> drawnCards = deckOfCards.drawCards(deckId, 5);
        deckOfCards.addToDiscardPile(deckId, drawnCards);
        deckOfCards.returnCardsToDeck(deckId, drawnCards);
        assertEquals(52, deckOfCards.getRemainingCardsInDeck(deckId));
    }

    @Test
    void testCreateDeckWithJokers() {
        String deckIdWithJokers = deckOfCards.getNewDeck(1, "true");
        int remainingCards = deckOfCards.getRemainingCardsInDeck(deckIdWithJokers);
        assertEquals(54, remainingCards);
    }

    @Test
    void testCreateTwoDecksNoJokers() {
        String deckIdTwoDecks = deckOfCards.getNewDeck(2, "false");
        int remainingCards = deckOfCards.getRemainingCardsInDeck(deckIdTwoDecks);
        assertEquals(104, remainingCards);
    }

    @Test
    void testCreateTwoDecksWithJokers() {
        String deckIdTwoDecksWithJokers = deckOfCards.getNewDeck(2, "true");
        int remainingCards = deckOfCards.getRemainingCardsInDeck(deckIdTwoDecksWithJokers);
        assertEquals(108, remainingCards);
    }

    @Test
    void testDrawTenCardsFromTwoDecks(){
        String twoDeckId = deckOfCards.getNewDeck(2, "false");
        List<String> drawnCards = deckOfCards.drawCards(twoDeckId, 10);
        assertEquals(10, drawnCards.size());
    }

    @Test
    void testDiscardAndReturnTenCardsWithJokers(){
        String jokerDeckId = deckOfCards.getNewDeck(1, "true");
        List<String> drawnCards = deckOfCards.drawCards(jokerDeckId, 10);
        deckOfCards.addToDiscardPile(jokerDeckId, drawnCards);
        deckOfCards.returnCardsToDeck(jokerDeckId, drawnCards);
        assertTrue(deckOfCards.getDiscardPile(jokerDeckId).isEmpty());
    }
}