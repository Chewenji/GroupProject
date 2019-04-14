/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wenji
 */
public class CardTest {
    
    public CardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFace method, of class Card.
     */
     @Test
    public void testGetFaceGood() {
        System.out.println("getFaceGood");
        Card instance = new Card();
        String expResult = "2";
        String result = instance.getFace();
        assertEquals(expResult, result);
    }
    public void testGetFaceBad() {
        System.out.println("getFaceBad");
        Card instance = new Card();
        String expResult = "14";
        String result = instance.getFace();
        assertEquals(expResult, result);
    }
 public void testGetFaceBoundary() {
        System.out.println("getFace Boundary");
        Card instance = new Card();
        String expResult = "3";
        String result = instance.getFace();
        assertEquals(expResult, result);
 }
    /**
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuitGood() {
        System.out.println("getSuit");
        Card instance = new Card();
        String expResult = "Spade";
        String result = instance.getSuit();
        assertEquals(expResult, result);
    }
public void testGetSuitBad() {
        System.out.println("getSuit bad");
        Card instance = new Card();
        String expResult = "Square";
        String result = instance.getSuit();
        assertEquals(expResult, result);
    }
public void testGetSuitBoundary() {
        System.out.println("getSuit boundary");
        Card instance = new Card();
        String expResult = "Diamond";
        String result = instance.getSuit();
        assertEquals(expResult, result);
    }
    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToStringGood() {
        System.out.println("toString good");
        Card instance = new Card();
        String expResult = "Spade 2";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
     public void testToStringBad() {
        System.out.println("toString bad");
        Card instance = new Card();
        String expResult = " hear 14";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
      public void testToStringBoundary() {
        System.out.println("toString boundary");
        Card instance = new Card();
        String expResult = "Heart 5";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
