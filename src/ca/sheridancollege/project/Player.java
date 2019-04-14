/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 * Liu Zexuan, Chen Wenjing, Sultani Yassin
 */
package ca.sheridancollege.project;

import java.util.List;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author dancye, 2018
 */
public class Player {
    
    private int winNumber;//Record the number of victories
    private int loseNumber;//Record number of failures
    private int cash;//player's cash
    private Hand hand;
    /** 
     * Initializes the player's parameters
     *number of victories：0
     *number of failures：0
     *number of card：0
     *account balance：10000
     */
    public Player() {
        winNumber=0;
        loseNumber=0;
        hand=new Hand();
        setCash(10000);
    }
    
    /**
     *get the WinNumber
     */
    public int getWin(){
        return winNumber;
    }
    
    /**
     *get the loseNumber
     */
    public int getLose(){
        return loseNumber;
    }
    
    /**
     *get the card in player's hand
     */
    public String getHandList(){
        return hand.toString();
    }
    
    /**
     *get the number of card in player's hand
     */
    public int getSize(){
        return hand.getSize();
    }
    
    /**
     *set hand
     */
    public void setHand(Card c){
        hand.setCard(c);
    }
    
    /**
     *
     *reture a list of card in player 's hand
     */
    public List getHand(){
        return hand.getCards();
    }
    /**
     *win!
     */
    public void youWin(){
        winNumber++;
    }
    
    /**
     *clear the card
     */
    public void playAgain(){
        hand.clear();
    }
    
    /**
     *lose
     */
    public void youLose(){
        loseNumber++;
    }
    
    /**
     *get cash!
     */
    public int getCash() {
        return cash;
    }
    
    /**
     *set the current cash
     */
    public void setCash(int cash) {
        this.cash = cash;
    }
}
