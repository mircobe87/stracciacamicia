/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.homepc.mibe.stracciacamicia.cards;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author mirco
 */
public class DeckDescriptor implements Iterable<DeckDescriptor.DeckDescriptorEntry<Seed, String[]>>{
    private ArrayList<DeckDescriptorEntry<Seed, String[]>> descriptor;
    
    public DeckDescriptor (String[] cardNames) {
        descriptor = new ArrayList<>();
        for (Seed s : Seed.class.getEnumConstants()) {
            descriptor.add(new DeckDescriptorEntry<>(s, cardNames));
        }
    }
    
    public DeckDescriptor (Seed[] cardSuits, String[]... cardNames ) {
        descriptor = new ArrayList<>();
        int totSuits = cardSuits.length;
        int totCardNames = cardNames.length;
        
        int s = 0, n = 0;
        boolean stop = false;
        while (!stop) {
            Seed currentSuit = cardSuits[s];
            String[] currentCardNames = cardNames[n];
            descriptor.add(new DeckDescriptorEntry<>(currentSuit, currentCardNames));
            
            stop = (s == totSuits - 1 && n == totCardNames - 1);
            if (s < totSuits - 1) s++;
            if (n < totCardNames - 1) n++;
        }
    }

    @Override
    public Iterator<DeckDescriptorEntry<Seed, String[]>> iterator() {
        return descriptor.iterator();
    }
        
    public class DeckDescriptorEntry<K, V> {
        
        private K k;
        private V v;
        
        public DeckDescriptorEntry(K suit, V cardNames) {
            k = suit;
            v = cardNames;
        }
        
        public K getSuit() {
            return k;
        }

        public V getCardNames() {
            return v;
        }

        public V setCardNames(V cardNames) {
            V oldValue = v;
            v = cardNames;
            return oldValue;
        }
        
    }
}
