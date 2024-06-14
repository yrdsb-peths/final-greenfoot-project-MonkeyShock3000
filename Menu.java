import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents the main menu screen
 * Gives instructions and contains some objects
 * 
 * @author Aaran
 * @version June
 */
public class Menu extends World
{
    // Creates title label
    Label titleLabel = new Label("Paper Pong\n(First To 10)", 60);
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(titleLabel, getWidth()/2, 82); // Adds label
        prepare(); // adds objects and labels to world
    }
    
    /**
     * The main world act loop: Changes world when space bar is pressed
     */
    public void act()
    {
        // Start the game if user presses the space bar
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld myWorld = new MyWorld(); // Creates new game world
            Greenfoot.setWorld(myWorld); // Sets world to myWorld
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        // Create paddle 1
        PaddleLeft paddleOne = new PaddleLeft();
        addObject(paddleOne, getWidth()/4, (getHeight()/2) - 15);
        
        // Create paddle 2
        PaddleRight paddleTwo = new PaddleRight();
        addObject(paddleTwo, (getWidth()/4) * 3,(getHeight()/2) - 15);
        
        // Label for starting game
        Label label = new Label("Press <SPACE> to Start", 30);
        addObject(label, getWidth()/2,(getHeight()/4) * 3 - 30);
        
        // Label for controls
        Label label2 = new Label("P1: Use \u2191 & \u2193 to Move\nP2: Use W & S to Move", 30);
        addObject(label2,getWidth()/2,(getHeight()/4) * 3 + 30);
    }
}
