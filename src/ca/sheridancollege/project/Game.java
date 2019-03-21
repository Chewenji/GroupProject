/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 * Liu Zexuan, Chen Wenjing, Sultani Yassin
 */
package ca.sheridancollege.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * The class that models your game. You should create a more specific
 * child of this class and instantiate the methods given.
 * @author dancye, 2018
 */
public class Game 
{
   private Player player,com;//player and computer
    private GroupOfCards deck;//Cards
    BufferedReader br;
   
    public Game() {
        //Initialize player and card
        player=new Player();
        com=new Player();
        deck=new GroupOfCards();
        String str = null;
        br=new BufferedReader(new InputStreamReader(System.in));
        
        //print the menu
        while(true){
            player.playAgain();
            com.playAgain();
            System.out.println("BlackJack");
            System.out.println("Group member:Liu Zexuan, Chen Wenjing, Sultani Yassin ");
            System.out.println("1.Start to play");
            System.out.println("2.Check the Score");
            System.out.println("3.Exit the game");
            System.out.println("Please choose one of the number");
            try {
                str=br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch(Integer.parseInt(str)){
                case 1:
                    start();
                    break;
                case 2:
                    checkScore();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("The input is incorrect, please re-enter");
                    break;
                   
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       new Game();
    }
    
    
    private void start() {
        //The initial amount is 20 dollars
        int money=20;
        int yourChoice;
        System.out.println("Please select the amount you wish to bet (minimum 20 dollars):");
        //The user enters the bet amount
        try {
            money=Integer.parseInt(br.readLine());
            if(money<20){
                money=20;
            }
        } catch (Exception e) {
            money=20;
            System.out.println("Your input is incorrect, the System will automatically set your bet amount as 20 dollars");
        }
        
            System.out.println("the game start...");
            player.setHand(deck.getCard());
            com.setHand(deck.getCard());
        do{
            System.out.println("You get the card is："+player.getHandList());
            do{
                System.out.println("Your choice: 1.Double you bet amount 2. Pass 3. Ask for another Card. 4. Open card 5. Return to the previous menu");
                try {
                    yourChoice=Integer.parseInt(br.readLine());
                    break;
                } catch (NumberFormatException ex) {
                    System.out.println("The input is incorrect, please re-enter");
                } catch (IOException ex) {
                    System.out.println("The input is incorrect, please re-enter");
                }
            }while(true);
        
            switch(yourChoice){
                case 1://Double
                    yourDouble(money);
                    break;
                case 2://PASS
                    yourPass(money);
                    break;
                case 3://Ask for another Card
                    getCardAgain(money);
                    break;
                case 4://Open Card
                    winOrLose(money);
                    yourChoice=5;
                    break;
                case 5://Return to the previous menu
                    break;
                default:
                    System.out.println("The input is incorrect，Please choose a number between 1 to 5");
            }
        }while(yourChoice!=5);
    }
    
    //Check the Score
    private void checkScore() {
        System.out.println("You won "+player.getWin()+" times");
        System.out.println("You lost "+player.getLose()+" times");
        System.out.println("You account balance is "+player.getCash()+" Dollars");
    }
    
    //player double bet
    private void yourDouble(int money) {
        money*=2;//bet double
        
        //check win or lose
        this.winOrLose(money);
    }
    
    //point check
    private int computePoint(Player player){
        int playerPoint=0;//player point
        int numberOfA=0;//Number of CARDS at point A
        
       
        for(int i=0;i<player.getHand().size();i++){
            Card c=(Card)player.getHand().get(i);
            if(c.getFace().charAt(0)>='2'&&c.getFace().charAt(0)<='9'){
                playerPoint+=Integer.parseInt(c.getFace());//adds up the value between 2 and 9
            }else if(c.getFace().equals("J") ||
                    c.getFace().equals("Q")||
                    c.getFace().equals("K")||c.getFace().equals("10")){
                playerPoint+=10;//adds up value between J Q K (J Q K as 10)
            }else if(c.getFace().charAt(0)=='A'){
                numberOfA++;
            }
        }
        
        //add up the value of A
        if(numberOfA==0){
            
        }else{
            if(playerPoint+(11*numberOfA)>21){
                playerPoint+=numberOfA;
            }else{
                playerPoint+=11;
            }
        }
        
        if(playerPoint<=21){
            return playerPoint;
        }else{
            return 0;//over 21(lose)
        }
    }
    private void yourPass(int money) {//PASS
        //check win or lose
        this.winOrLose(money);
    }

    private void getCardAgain(int money) {//get card again
        player.setHand(deck.getCard());
    }

    private void winOrLose(int money) {//check win or lose
        int playerPoint=this.computePoint(player);//get player's point
        int comPoint=comPlayer();//get computer's point
        
        if(comPoint==0){//Computer Bust
            System.out.println("Bust！You win!");
            player.setCash(player.getCash()+money);
            player.youWin();
        }else if(playerPoint==0){//Player Bust
            System.out.println("Bust!You lose");
            player.setCash(player.getCash()-money);
            player.youLose();
        }else if(comPoint<playerPoint||player.getSize()==5||playerPoint==21){
            System.out.println("Computer:"+comPoint+"  Your:"+playerPoint+"  you win!");
            player.setCash(player.getCash()+money);
            player.youWin();
        }else{
            System.out.println("Computer:"+comPoint+"  Your:"+playerPoint+"  you lose!");
            player.setCash(player.getCash()-money);
            player.youLose();
        }
    }

    private int comPlayer() {
        int comPoint=this.computePoint(com);
        System.out.println("Computer start："+com.getHandList());
        while(comPoint!=0&&comPoint<=18 && com.getSize()<5){//computer will keep ask for card if the score lower than 18
            com.setHand(deck.getCard());//get computer another card
            
            System.out.println("get another card, Computer："+com.getHandList());
            comPoint=this.computePoint(com);//check the point again
        }
        return comPoint;       
    }
    
}
