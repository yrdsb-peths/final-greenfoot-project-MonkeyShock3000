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
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        prepare();
    }
    
    private void prepare()
    {
        //Create the ball object 
        Ball ball = new Ball();
        addObject(ball, getWidth()/2, getHeight()/2);
        
        //Create Player 1 object
        Paddle blue = new Paddle();
        addObject(blue, 50, getHeight()/2);
        
        //Create Player 2 object
        Paddle red = new Paddle();
        addObject(red, getWidth() - 50, getHeight()/2);
        
    }
}
