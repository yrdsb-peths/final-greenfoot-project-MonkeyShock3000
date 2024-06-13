import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world.
 * 
 * @author Aaran 
 * @version May
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public int scoreLeft = 0;
    public int scoreRight = 0;
    public Counter left;
    public Counter right;
    
    public void act()
    {
        
    }
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        //Create scores
        drawBackground();
        
        prepare();
        
    }
    
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
            left.setLocation(100, 30);
        }
        
        if (right == null)
        {
            //Create right scores
            right = new Counter("Score P2: ");
            addObject(right, getWidth() - 100, 30); 
        }
    }
    
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
    
    public void updateScoreForLeft() 
    {
        if (left != null)
        {
            scoreRight++;
            right.setValue(scoreRight);
        }
    }
    
    public void updateScoreForRight() 
    {
        if (right != null)
        {
            scoreLeft++;
            left.setValue(scoreLeft);
        }
    }
}
