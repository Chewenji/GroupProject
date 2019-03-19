/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 * Liu Zexuan, Chen Wenjing, Sultani Yassin
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 *
 * @author Administrator
 */
public class GroupOfCards {
    //max 52 cards
    public static final int MAX_SIZE=52;
   
    protected Stack cards;
    
    //the list of drawn Cards
    protected List drawnCards;
    
    
    protected Random random;
    
    
    public GroupOfCards() {
        
        cards=new Stack();
        
        for (int i=1;i<=MAX_SIZE;i++) {
            cards.push(new Card(i));
        }
        
        
        drawnCards=new ArrayList();
        random=new Random();
        
        shuffle();
    }
    
    /**
     * Returns the number of CARDS remaining
     */
    public int getSize(){
        return cards.size()+drawnCards.size();
    } 
    
    //Random shuffle
    private void shuffle() {
     
        while (!cards.isEmpty()){
                drawnCards.add(cards.pop());
        }
        
        //Put the Cards back randomly into the stack
        Object card=null;
        while (!drawnCards.isEmpty()){
            card=drawnCards.remove(Math.abs(random.nextInt()%drawnCards.size()));
            cards.push(card);
        }
    }
    
    /**
     * getCard
     */
    public Card getCard(){
        if(getSize()==0){
            
            
            for (int i=1;i<=MAX_SIZE;i++) {
            cards.push(new Card(i));
            }
            
            // shuffle again
            shuffle();
        }
        
        return (Card)cards.pop();
    }
    
}

