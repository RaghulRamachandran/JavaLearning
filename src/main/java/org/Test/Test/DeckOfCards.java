package org.Test.Test;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DeckOfCards_DecksTest {

    @Test
    void testGetRemainingCardsInDeck_Initial() {
        DeckOfCards_Decks deck = new DeckOfCards_Decks(1, "false");
        assertEquals(52, deck.getRemainingCardsInDeck(), "Initial deck should have 52 cards.");
    }

    @Test
    void testShuffleDeck() {
        DeckOfCards_Decks deck = new DeckOfCards_Decks(1, "false");
        assertTrue(deck.shuffleDeck(), "Deck should shuffle successfully.");
    }

    @Test
    void testDrawCards() {
        DeckOfCards_Decks deck = new DeckOfCards_Decks(1, "false");
        List<String> drawnCards = deck.drawCards(5);
        assertEquals(5, drawnCards.size(), "Number of drawn cards should be 5.");
    }

    @Test
    void testAddToDiscardPile() {
        DeckOfCards_Decks deck = new DeckOfCards_Decks(1, "false");
        List<String> drawnCards = deck.drawCards(3);
        assertTrue(deck.addToDiscardPile(drawnCards), "Adding to discard pile should be successful.");
    }

    @Test
    void testGetDiscardPile_NotEmpty() {
        DeckOfCards_Decks deck = new DeckOfCards_Decks(1, "false");
        List<String> drawnCards = deck.drawCards(3);
        deck.addToDiscardPile(drawnCards);
        assertEquals(drawnCards, deck.getDiscardPile(), "Discard pile should contain the drawn cards.");
    }

    @Test
    void testReturnCardsToDeck() {
        DeckOfCards_Decks deck = new DeckOfCards_Decks(1, "false");
        List<String> drawnCards = deck.drawCards(3);
        deck.addToDiscardPile(drawnCards);
        assertTrue(deck.returnCardsToDeck(drawnCards), "Returning cards to the deck should be successful.");
        assertTrue(deck.getDiscardPile().isEmpty(), "Discard pile should be empty after returning cards.");
    }

    @Test
    void testGetRemainingCardsInDeck_AfterDraw() {
        DeckOfCards_Decks deck = new DeckOfCards_Decks(1, "false");
        deck.drawCards(5);
        assertEquals(47, deck.getRemainingCardsInDeck(), "Deck should have 47 cards after drawing 5.");
    }

    @Test
    void testGetRemainingCardsInDeck_AfterDiscardAndReturn() {
        DeckOfCards_Decks deck = new DeckOfCards_Decks(1, "false");
        List<String> drawnCards = deck.drawCards(5);
        deck.addToDiscardPile(drawnCards);
        deck.returnCardsToDeck(drawnCards);
        assertEquals(52, deck.getRemainingCardsInDeck(), "Deck should be back to 52 cards after returning cards.");
    }

    @Test
    void testGetDiscardPile_Empty() {
        DeckOfCards_Decks deck = new DeckOfCards_Decks(1, "false");
        List<String> drawnCards = deck.drawCards(5);
        deck.addToDiscardPile(drawnCards);
        deck.returnCardsToDeck(drawnCards);
        assertTrue(deck.getDiscardPile().isEmpty(), "Discard pile should be empty.");
    }

    @Test
    void testCreateDeckWithJokers() {
        DeckOfCards_Decks deck = new DeckOfCards_Decks(1, "true");
        assertEquals(54, deck.getRemainingCardsInDeck(), "Deck with jokers should have 54 cards.");
    }

    @Test
    void testCreateTwoDecksNoJokers() {
        DeckOfCards_Decks deck = new DeckOfCards_Decks(2, "false");
        assertEquals(104, deck.getRemainingCardsInDeck(), "Two decks without jokers should have 104 cards.");
    }

    @Test
    void testCreateTwoDecksWithJokers() {
        DeckOfCards_Decks deck = new DeckOfCards_Decks(2, "true");
        assertEquals(108, deck.getRemainingCardsInDeck(), "Two decks with jokers should have 108 cards.");
    }

    @Test
    void testDrawTenCardsFromTwoDecks() {
        DeckOfCards_Decks deck = new DeckOfCards_Decks(2, "false");
        List<String> drawnCards = deck.drawCards(10);
        assertEquals(10, drawnCards.size(), "Number of drawn cards should be 10.");
    }

    @Test
    void testDiscardAndReturnTenCardsWithJokers() {
        DeckOfCards_Decks deck = new DeckOfCards_Decks(1, "true");
        List<String> drawnCards = deck.drawCards(10);
        deck.addToDiscardPile(drawnCards);
        deck.returnCardsToDeck(drawnCards);
        assertTrue(deck.getDiscardPile().isEmpty(), "Discard pile should be empty after returning cards.");
    }
}
