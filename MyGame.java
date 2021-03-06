/*  
 * Author: Nathaniel Clay Arnold
 * Program 2 - MyGame
 * CSC230-02 Spring 2016
 */
package mygame;

import java.util.Scanner;

import java.util.InputMismatchException; 

public class MyGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        
        boolean Exception;
        
        String playAgain;
        
        boolean Again;

        do { // loop to play again 
            
            Again = false;
            
            C4 testGame = new C4();

            System.out.println("Let's Play " + testGame.getName() + "\n");

            do { // loop to continue game until someone wins or the board is full 
                
                testGame.printBoard();
                
                System.out.print("Player " + testGame.getTurn()
                        
                        + " choose a column: ");
                
                
                do { // loop for try catch blocks 
                    
                    try {
                        Exception = false;
                        
                        testGame.playPiece(kb.nextInt());
 
                    } 
                    
                    catch (ArrayIndexOutOfBoundsException ex) {
                        
                        Exception = true; // turn loop on 
                        
                        System.out.print("This column is out of bounds\n"
                                + "choose another column(0-6): ");
                    } 
                    
                    catch (ColFullException ex) {
                        
                        Exception = true; // turn loop on 
                        
                        System.out.print("This column is full\n"
                                + "choose another column: ");
                    }
                    
                    catch (InputMismatchException ex){
                        
                        Exception = true; // turn loop on 
                        
                        kb.nextLine(); // clear scanner buffer
                        
                        System.out.print("Invalid input\n"
                                + "choose a column number:");
                    }
                    

                } while (Exception == true);
                
                  if(testGame.isWinner() == false){
                      
                      testGame.nextturn();
                  }
                  
            } while(testGame.isWinner() == false && testGame.isFull() == false);

            testGame.printBoard(); // print final board after game ends  
            
            if(testGame.isFull() == true){
                
                System.out.println("the board is full.");
            }
            
            if(testGame.isWinner() == true){
               
               testGame.winner(); 
               
            }
            

            int validate; // variable to control loop 

            kb.nextLine(); // clear scanner buffer 
            
            do { // loop for new game initiation 
                
                System.out.print("Do you want to play again?(Y/N): ");

                playAgain = kb.nextLine();
                
                validate = 0;

                if (playAgain.equalsIgnoreCase("y")||playAgain.equalsIgnoreCase("yes")){
                    
                    Again = true;

                } else if (playAgain.equalsIgnoreCase("n")||playAgain.equalsIgnoreCase("no")){
                    
                    System.out.println("Thanks for playing " + testGame.getName()
                            + ", goodbye!");
                } 
                
                else {
                    
                    System.out.println("Invalid entry");
                    
                    validate = 1;  // turns loop on 
                }

            } while (validate == 1);

        } while (Again == true);
    }
}
