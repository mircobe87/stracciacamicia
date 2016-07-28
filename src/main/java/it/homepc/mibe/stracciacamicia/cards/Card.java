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
    private Seed seed;
    private String name;
    
    public Card(int v, String n, Seed s) throws IllegalArgumentException {
        if (n == null || n.length() == 0) throw new IllegalArgumentException("A Card must have a name.");
        if (s == null) throw new IllegalArgumentException("A Card must have a Seed.");
        value = v;
        seed = s;
        name = n;
    }
    
    public Seed getSeed() {
        return seed;
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
        if (this.getSeed().compareTo(param.getSeed()) == 0) {
            return this.getValue() - param.getValue();
        } else {
            return this.getSeed().compareTo(param.getSeed());
        }
    }
    
    public int compareSeedTo(Object o) {
        if (! (o instanceof Card)) throw new IllegalArgumentException();
        Card param = (Card)o;
        return this.getSeed().compareTo(param.getSeed());
    }

    public int compareValueTo(Object o) {
        if (! (o instanceof Card)) throw new IllegalArgumentException();
        Card param = (Card)o;
        return this.getValue() - param.getValue();
    }
    
    @Override
    public String toString() {
        return this.getName() + ":" + this.getSeed() + "[" + this.getValue() + "]";
    }
    
}
