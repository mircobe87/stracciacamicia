/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.homepc.mibe.stracciacamicia.cards;

import it.homepc.mibe.stracciacamicia.cards.DeckDescriptor.DeckDescriptorEntry;
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
        deck = new ArrayList<>(cards);
    }
    
    public Deck(DeckDescriptor descriptor) {
        deck = new ArrayList<>();
        for (DeckDescriptorEntry<Seed, String[]> entry : descriptor) {
            Seed currentSuit = entry.getSuit();
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
        Random r = new Random();
        r.setSeed(new Date().getTime());
        
        int cards = deck.size();
        for (int i=0; i<cards-1; i++) {
            int j = i + r.nextInt(cards - i);
            deck.add(i, deck.remove(j));
        }
    }
    
    public Card getFirstCard() {
        Card c = deck.remove(0);
        return c;
    }
    
    public Card getLastCard() {
        Card c = deck.remove(deck.size() - 1);
        return c;
    }
    
    public Card getRandomCard() {
        Random r = new Random();
        r.setSeed(new Date().getTime());
        
        Card c = deck.remove(r.nextInt(deck.size()));
        return c;
    }
    
    public Deck getFirstCards(int nCards) {
        List<Card> cards = deck.subList(0, nCards);
        for (int i=0; i<nCards; i++) {
            deck.remove(i);
        }
        return new Deck(cards);
    }
    
    public Deck getLastCards(int nCards) {
        int stopIndex = deck.size();
        int startIndex = stopIndex - nCards;
        List<Card> cards = deck.subList(startIndex, stopIndex);
        
        for (int i=startIndex; i<stopIndex; i++) {
            deck.remove(i);
        }
        return new Deck(cards);
    }
    
    public Deck getRandomCards(int nCards) {
        Random r = new Random();
        r.setSeed(new Date().getTime());
        
        List<Card> l = new ArrayList<>();
        for (int i=0, max=deck.size(); i<nCards; i++ ) {
            l.add(deck.remove(r.nextInt(max - i)));
        }
        return new Deck(l);
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
