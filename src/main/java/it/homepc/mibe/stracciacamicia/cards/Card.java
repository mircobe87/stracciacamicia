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
public class Card implements Comparable {
    private int value;
    private Seed suit;
    private String name;
    
    public Card(int v, String n, Seed s) throws IllegalArgumentException {
        if (n.length() == 0) throw new IllegalArgumentException();
        value = v;
        suit = s;
        name = n;
    }
    
    public Seed getSuit() {
        return suit;
    }
    
    public int getValue() {
        return value;
    }
    
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        if (! (o instanceof Card)) throw new IllegalArgumentException();
        Card param = (Card)o;
        if (this.getSuit().compareTo(param.getSuit()) == 0) {
            return this.getValue() - param.getValue();
        } else {
            return this.getSuit().compareTo(param.getSuit());
        }
    }
    
    public int compareSuiteTo(Object o) {
        if (! (o instanceof Card)) throw new IllegalArgumentException();
        Card param = (Card)o;
        return this.getSuit().compareTo(param.getSuit());
    }

    public int compareValueTo(Object o) {
        if (! (o instanceof Card)) throw new IllegalArgumentException();
        Card param = (Card)o;
        return this.getValue() - param.getValue();
    }
    
    @Override
    public String toString() {
        return this.getName() + ":" + this.getSuit() + "[" + this.getValue() + "]";
    }
    
}
