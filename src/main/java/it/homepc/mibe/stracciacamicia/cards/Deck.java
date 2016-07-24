/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.homepc.mibe.stracciacamicia.cards;

import it.homepc.mibe.stracciacamicia.cards.DeckDescriptor.DeckDescriptorEntry;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author mirco
 */
public class Deck {
    private ArrayList<Card> deck;
    
    public Deck(DeckDescriptor descriptor) {
        deck = new ArrayList<>();
        for (DeckDescriptorEntry<Suit, String[]> entry : descriptor) {
            Suit currentSuit = entry.getSuit();
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
    
    @Override
    public String toString() {
        String s = "";
        for (Card c : this.deck) {
            s += c.toString() + "\n";
        }
        return s;
    }
}
