import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents the end game screen and displays the game results
 * 
 * @author Aaran
 * @version June
 */
public class End extends World
{
    private int scoreLeft; // Player 1 score 
    private int scoreRight; // Player 2 score
    
    // Displays "WINNER" on the screen
    Label winnerLabel = new Label("WINNER", 60);
    /**
     * Constructor for objects of class End.
     * End word with game winner
     * 
     * @param scoreLeft Player 1 score 
     * @param scoreRight Player 2 score
     */
    public End(int scoreLeft, int scoreRight)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.scoreLeft = scoreLeft; // stores player one's score 
        this.scoreRight = scoreRight; // stores player two's score
        prepare(); // adds objects
        
        addObject(winnerLabel, getWidth()/2, 82); // Adds label
    }
    /**
     * Shows and determines winner
     */
    public void act()
    {
        winner();
    }
    /**
     * Prepares the objects in the world
     */
    public void prepare()
    {
        //Create the throphy object 
        Trophy trophy = new Trophy();
        addObject(trophy, getWidth()/2, getHeight()/2);
        
        //Create Player 1 object
        PaddleLeft paddleOne = new PaddleLeft();
        addObject(paddleOne, 50, getHeight()/2);
        
        //Create Player 2 object
        PaddleRight paddleTwo = new PaddleRight();
        addObject(paddleTwo, getWidth() - 50, getHeight()/2);
        
        //Create crown object
        Crown crown = new Crown();
        addObject(crown, getWidth()/2, (getHeight()/4) * 3);
        
    }
    
    /**
     * Determines the winner and moves the crown onto the winner
     */
    public void winner()
    {
        Actor crown = getObjects(Crown.class).get(0); // Gets crown object
        
        // Moves crown to who scored higher
        if (scoreLeft >= 10)
        {
            crown.setLocation(50, getHeight()/2 - 60); // Position for left 
        }
        
        else if (scoreRight >= 10)
        {
            crown.setLocation(getWidth() - 50, getHeight()/2 - 60); // Position for right
        }
    }
    
}
