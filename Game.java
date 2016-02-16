package mygame;


public class Game {

    private String gameName;
    
    private int numPlayers;
    
    private int currPlayer;
    
    private int tries;

    public Game(String name, int players) {
        
        this.gameName = name;
        
        this.numPlayers = players;
        
        this.currPlayer = 1;
        
        this.tries = 0;
    }

    public String getName() {
        
        return this.gameName;
    }

    public int currentTurn() {
        
        return this.currPlayer;
    }

    public void next() {
        
        this.currPlayer = this.currPlayer == 1 ? 2 : 1;
        
        ++this.tries;
    }

    public void winner() {
        
        System.out.println("Player " + this.currPlayer + " has won " 
                
                + this.gameName + "!!!");
        
        System.out.println("The game took " + this.getTries() + " to finish.");
    }

    public int getTries() {
        
        return this.tries;
    }
}
