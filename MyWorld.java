import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main game world, manages game logic 
 * 
 * @author Aaran 
 * @version May
 */
public class MyWorld extends World
{

    // Scores for each player
    public int scoreLeft = 0;
    public int scoreRight = 0;
    
    // Scoreboard
    public Counter left;
    public Counter right;
    
    /**
     * Checks when to end the game
     */
    public void act()
    {
        endGame();
    }
    
    /**
     * Constructor for objects of class MyWorld.
     * Initializes world and sets up background, scores and objects
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        //Create scores
        drawBackground();
        
        // Prepares objects
        prepare();
        
    }
    
    /**
     * Draws scores
     */
    public void drawBackground()
    {
        if (left == null)
        {
            //Create left scores
            left = new Counter("Score P1: ");
            addObject(left, 100, 30);
        }
        
        else
        {
            left.setLocation(100, 30); // Verifies location
        }
        
        if (right == null)
        {
            //Create right scores
            right = new Counter("Score P2: ");
            addObject(right, getWidth() - 100, 30); 
        }
    }
    
    /**
     * Creates and draws the ball and the paddles
     */
    public void prepare()
    {
        //Create the ball object 
        Ball ball = new Ball();
        addObject(ball, getWidth()/2, getHeight()/2);
        ball.checkCollisions();
        
        //Create Player 1 object
        PaddleLeft paddleOne = new PaddleLeft();
        addObject(paddleOne, 50, getHeight()/2);
        
        //Create Player 2 object
        PaddleRight paddleTwo = new PaddleRight();
        addObject(paddleTwo, getWidth() - 50, getHeight()/2);
    
    }
    
    /**
     * Updates current score for the left player
     */
    public void updateScoreForLeft() 
    {
        if (left != null)
        {
            scoreRight++;
            right.setValue(scoreRight);
        }
    }
    
    /**
     * updates current score for the right player
     */
    public void updateScoreForRight() 
    {
        if (right != null)
        {
            scoreLeft++;
            left.setValue(scoreLeft);
        }
    }
    
    /**
     * returns current score for the left player
     */
    public int getScoreLeft()
    {
        return scoreLeft;
    }
    
    /**
     * returns current score for the right player
     */
    public int getScoreRight()
    {
        return scoreRight;
    }
    
    /**
     * Changes world to the end screen
     */
    public void endGame()
    {
        if (scoreLeft == 10 || scoreRight == 10)
        {
            End endScreen = new End(scoreLeft, scoreRight);
            Greenfoot.setWorld(endScreen); // Changes to end screen
        }
    }
}
