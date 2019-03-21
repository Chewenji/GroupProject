/*
Liu Zexuan, Chen Wenjing, Sultani Yassin
*/
package ca.sheridancollege.project;


import java.util.ArrayList;


class Hand {
    private ArrayList cards;
  
    public Hand() {
        cards=new ArrayList();
    }
    
    
    public void setCard(Object c){
        cards.add(c);
    }
    /**
     *Clear the Cards from the player's hand
     */
    public void clear(){
        cards.clear();
    }
    /**
     *Returns the number of Cards in the player's hand
     */
    public int getSize(){
        return cards.size();
    }
    //Display the Cards in the player's hand
    public String toString(){
        //int i = 0;
        String hand = "";
        
        //while (!cards.isEmpty()){
        hand=cards.toString();
            //i++;
        //}
        return hand;
    }
    
    public ArrayList getCards(){
        return cards;
    }
}


