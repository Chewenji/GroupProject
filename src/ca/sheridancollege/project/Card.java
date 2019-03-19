/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 * Liu Zexuan, Chen Wenjing, Sultani Yassin
 */
package ca.sheridancollege.project;


class Card {
    //show the value of card
    public static final String[] FACES={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    
    //show the suit of card
    public static final String[] SUITS={"Spade","Club","Diamond","Heart"};
    
    //Max cards
    public static final int MAX_CARDS=FACES.length*SUITS.length;
    
    
    protected int value;
    
    //default card
    public Card(){
        value=0;
    }
    
    //illegal value will cause the program to terminate.
    public Card(int n){
        if(n<0 || n>MAX_CARDS){
            System.out.println("Error: illegal card index, program exit");
            System.exit(0);            
        }else{
            value=n;
        }
    }
    
    //return Faces value
    public String getFace(){
        return FACES[value%FACES.length];
    }
    
    //return suit value
    public String getSuit(){
        return SUITS[value%SUITS.length];
    }
    
    public String toString(){
        return getSuit()+" "+getFace();
    }
}