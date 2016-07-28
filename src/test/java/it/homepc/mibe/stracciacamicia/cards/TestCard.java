/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.homepc.mibe.stracciacamicia.cards;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mircobe87
 */
public class TestCard {
    
    private Card testCard = null;
    private static Card lowCard = null;
    private static Card highCard = null;
    
    @BeforeClass
    public static void initClass() {
        lowCard = new Card(
                8,
                "gobbo",
                Seed.HEARTS
        );
        highCard = new Card(
                2,
                "due",
                Seed.CLUBS
        );
    }
    
    @AfterClass
    public static void clearClass() {
        lowCard = null;
        highCard = null;
    }
    
    @After
    public void tearDown() {
        this.testCard = null;
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testCardCostructorAllNull() {
        this.testCard = new Card(0, null, null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testCardCostructorNullSeed() {
        this.testCard = new Card(0, "K", null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testCardCostructorNullName() {
        this.testCard = new Card(0, null, Seed.CLUBS);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testCardCostructorNoName() {
        this.testCard = new Card(0, null, Seed.CLUBS);
    }
    
    @Test
    public void testCardCostructior() {
        this.testCard = new Card(0, "k", Seed.CLUBS);
        Assert.assertNotNull(this.testCard);
        Assert.assertTrue(0 == this.testCard.getValue());
        Assert.assertTrue("k".equals(this.testCard.getName()));
        Assert.assertTrue(Seed.CLUBS.equals(this.testCard.getSeed()));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCompareToNull() {
        lowCard.compareTo(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCompareToNotCard() {
        lowCard.compareTo("this is a string");
    }
    
    @Test
    public void testCompareToSameCard() {
        Assert.assertTrue(lowCard.compareTo(lowCard) == 0 );
    }
    
    @Test
    public void testCompareToHighCard() {
        Assert.assertTrue(lowCard.compareTo(highCard) < 0 );
    }
    
    @Test
    public void testCompareToLowCard() {
        Assert.assertTrue(highCard.compareTo(lowCard) > 0 );
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCompareSeedToNull() {
        lowCard.compareSeedTo(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCompareSeedToNotCard() {
        lowCard.compareSeedTo("this is a string");
    }
    
    @Test
    public void testCompareSeedToSameCard() {
        Assert.assertTrue(lowCard.compareSeedTo(lowCard) == 0 );
    }
    
    @Test
    public void testCompareSeedToHighCard() {
        Assert.assertTrue(lowCard.compareSeedTo(highCard) < 0 );
    }
    
    @Test
    public void testCompareSeedToLowCard() {
        Assert.assertTrue(highCard.compareSeedTo(lowCard) > 0 );
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCompareValueToNull() {
        lowCard.compareValueTo(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCompareValueToNotCard() {
        lowCard.compareValueTo("this is a string");
    }
    
    @Test
    public void testCompareValueToSameCard() {
        Assert.assertTrue(lowCard.compareValueTo(lowCard) == 0 );
    }
    
    @Test
    public void testCompareValueToHighCard() {
        /*
            lowCard -> 8
            highCard -> 2
        */
        Assert.assertTrue(lowCard.compareValueTo(highCard) > 0 );
    }
    
    @Test
    public void testCompareValueToLowCard() {
        /*
            lowCard -> 8
            highCard -> 2
        */
        Assert.assertTrue(highCard.compareValueTo(lowCard) < 0 );
    }

}
