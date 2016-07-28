/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.homepc.mibe.stracciacamicia.cards;

import it.homepc.mibe.stracciacamicia.cards.DeckDescriptor.DeckDescriptorEntry;
import it.homepc.mibe.stracciacamicia.exceptions.EmptyDeckException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author mirco
 */
public class Deck {
    private List<Card> deck;
    
    public Deck() {
        deck = new ArrayList<>();
    }
    
    public Deck(List<Card> cards) {
        if (cards == null || cards.isEmpty()) {
            throw new IllegalArgumentException("At least a Cards must be into the given list.");
        }
        deck = new ArrayList<>(cards);
    }
    
    public Deck(DeckDescriptor descriptor) {
        deck = new ArrayList<>();
        for (DeckDescriptorEntry<Seed, String[]> entry : descriptor) {
            Seed currentSuit = entry.getSeed();
            String[] names = entry.getCardNames();
            for (int i=0; i<names.length; i++) {
                try {
                    Card currentCard = new Card(i, names[i], currentSuit);
                    deck.add(currentCard);
                } catch (IllegalArgumentException e) {
                    // DO NOTHING
                }
            }
        }
        deck.sort(new Comparator<Card>() {

            @Override
            public int compare(Card o1, Card o2) {
                return o1.compareTo(o2);
            }
        
        });
    }
    
    public void shuffle() {
        Random r = new Random(
                new Date().getTime()
        );
        
        int cards = deck.size();
        for (int i=0; i<cards-1; i++) {
            int j = i + r.nextInt(cards - i);
            deck.add(i, deck.remove(j));
        }
    }
    
    public Card getFirstCard() {
        if (deck.isEmpty()) {
            throw new EmptyDeckException("This Deck is empty, it's no possible get the first card.");
        }
        Card c = deck.remove(0);
        return c;
    }
    
    public Card getLastCard() {
        if (deck.isEmpty()) {
            throw new EmptyDeckException("This Deck is empty, it's no possible get the last card.");
        }
        Card c = deck.remove(deck.size() - 1);
        return c;
    }
    
    public Card getRandomCard() {
        if (deck.isEmpty()) {
            throw new EmptyDeckException("This Deck is empty, it's no possible get a card.");
        }
        Random r = new Random(
                new Date().getTime()
        );
        
        Card c;
        c = deck.remove(r.nextInt(deck.size()));
        return c;
    }
    
    public Deck getFirstCards(int nCards) {
        if (deck.isEmpty()) {
            throw new EmptyDeckException("This Deck is empty, it's no possible get any number of cards from the top.");
        }
        if (nCards < 0) {
            throw new IllegalArgumentException("The numbers of requested cards must be a no-negative value.");
        }
        if (nCards >= deck.size()) {
            return this;
        }
        if (nCards == 0) {
            return new Deck();
        }
        
        List<Card> cards;
        cards = deck.subList(0, nCards);
        for (int i=0; i<nCards; i++) {
            deck.remove(i);
        }
        return new Deck(cards);
    }
    
    public Deck getLastCards(int nCards) {
        if (deck.isEmpty()) {
            throw new EmptyDeckException("This Deck is empty, it's no possible get any number of cards from the bottom.");
        }
        if (nCards < 0) {
            throw new IllegalArgumentException("The numbers of requested cards must be a no-negative value.");
        }
        if (nCards >= deck.size()) {
            return this;
        }
        if (nCards == 0) {
            return new Deck();
        }
        
        int stopIndex = deck.size();
        int startIndex = stopIndex - nCards;
        List<Card> cards = deck.subList(startIndex, stopIndex);
        
        for (int i=startIndex; i<stopIndex; i++) {
            deck.remove(i);
        }
        return new Deck(cards);
    }
    
    public Deck getRandomCards(int nCards) {
        if (deck.isEmpty()) {
            throw new EmptyDeckException("This Deck is empty, it's no possible get any number of cards.");
        }
        Random r = new Random(
                new Date().getTime()
        );
        
        List<Card> l = new ArrayList<>();
        for (int i=0, max=deck.size(); i<nCards; i++ ) {
            l.add(deck.remove(r.nextInt(max - i)));
        }
        return new Deck(l);
    }
    
    public void addCardOnTop(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("The Card you want to add on top of the Deck must exists.");
        }
        deck.add(0, card);
    }
    
    public void addCardOnBottom(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("The Card you want to add at bottom of the Deck must exists.");
        }
        deck.add(deck.size(), card);
    }
    
    public void addCardInside(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("The Card you want to add into the Deck must exists.");
        }
        Random r = new Random(
                new Date().getTime()
        );
        
        int index = r.nextInt(deck.size());
        
        deck.add(index, card);
    }
    
    public void addCardsOnTop(Deck cards) {
        if (cards == null) {
            throw new IllegalArgumentException("The Deck you want to add on top must exists.");
        }
        if (!cards.isEmpty()) {
            deck.addAll(0, cards.deck);
            cards.deck.clear();
        }
    }
    
    public void addCardsOnBottom(Deck cards) {
        if (cards == null) {
            throw new IllegalArgumentException("The Deck you want to add at bottom must exists.");
        }
        if (!cards.isEmpty()) {
            deck.addAll(deck.size(), cards.deck);
            cards.deck.clear();
        }
    }
    
    public void addCardsInside(Deck cards) {
        if (cards == null) {
            throw new IllegalArgumentException("The Deck you want to add must exists.");
        }
        if (!cards.isEmpty()) {
            Random r = new Random(
                    new Date().getTime()
            );

            int index = r.nextInt(deck.size());
            deck.addAll(index, cards.deck);
            cards.deck.clear();
        }
    }
    
    public int getSize() {
        return deck.size();
    }
    
    public boolean isEmpty() {
        return getSize() == 0;
    }
    
    @Override
    public String toString() {
        String s = "";
        for (Card c : this.deck) {
            s += c.toString() + "\n";
        }
        return s;
    }
}
