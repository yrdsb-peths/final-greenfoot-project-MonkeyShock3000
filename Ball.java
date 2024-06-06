import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int deltaX = 2;
    private int deltaY = 2;
    
    public void act()
    {
        // Add your action code here.
        move();
        checkCollisions();
    }
    
    private void move()
    {
       setLocation(getX() + deltaX, getY() +  deltaY); 
    }
    
    private void checkCollisions()
    {
        if (getX() <= 0 || getX() >= getWorld().getWidth())
        {
            deltaX = -deltaX;
        }
        
        if (getY() <= 0 || getY() >= getWorld().getHeight())
        {
            deltaY = -deltaY;
        }
        
        Actor paddle = getOneIntersectingObject(Paddle.class);
        
        if (paddle != null)
        {
            deltaY = -deltaY;
        }
    }
}
