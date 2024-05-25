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
        
        //Create the ball object 
        Ball ball = new Ball();
        addObject(ball, getWidth()/2, getHeight()/2);
        
        //Create Player 1 object
        Blue blue = new Blue();
        addObject(blue, 20, getHeight()/2);
        
        //Create Player 2 object
        Red red = new Red();
        addObject(red, getWidth() - 20, getHeight()/2);
    }
}
