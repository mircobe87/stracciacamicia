/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.homepc.mibe.stracciacamicia.cards;

/**
 *
 * @author mirco
 */
public class StandardDeckDescriptorFactory {
    public static DeckDescriptor getStandardDeckDescriptor(DeckType type) {
        DeckDescriptor d = null;
        switch (type) {
            case CARDS_40 : {
                String[] cNames = {"1", "2", "3", "4", "5", "6", "7", "J", "Q", "K"};
                d = new DeckDescriptor(cNames);
            }break;
            case CARDS_52 : {
                String[] cNames = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
                d = new DeckDescriptor(cNames);
            }break;
        }
        return d;
    }
}
