/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.homepc.mibe.stracciacamicia;

import it.homepc.mibe.stracciacamicia.cards.Deck;
import it.homepc.mibe.stracciacamicia.cards.DeckDescriptor;
import it.homepc.mibe.stracciacamicia.cards.DeckType;
import it.homepc.mibe.stracciacamicia.cards.StandardDeckDescriptorFactory;
import it.homepc.mibe.stracciacamicia.cards.Seed;

/**
 *
 * @author mirco
 */
public class Sample {
    public static void main(String[] args) {
        Deck quaranta = new Deck(StandardDeckDescriptorFactory.getStandardDeckDescriptor(DeckType.CARDS_40));
        Deck test = new Deck(
                new DeckDescriptor(
                        new Seed[]{ Seed.SPADES, Seed.HEARTS, Seed.HEARTS},
                        new String[]{"1", "2", "3", "", "", "", "", "J", "Q", "K"},
                        new String[]{"", "", "", "4", "5", "6", "7"}
                )
        );
        System.out.println(quaranta);
        System.out.println("5 carte a caso: \n" + quaranta.getRandomCards(5));
        System.out.println(quaranta);
        
        System.out.println("shuffle...");
        quaranta.shuffle();
        System.out.println(quaranta);
    }
}
