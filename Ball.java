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
    
    public int deltaX = 2;
    public int deltaY = 2;
    
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
    
    public void checkCollisions()
    {
        World myWorld = getWorld();
        if (myWorld == null)
        {
            return;
        }
        
        // Check right boundary 
        if (getX() >= (getWorld().getWidth() - getImage().getWidth()/2))
        {
            // Increase score
            ((MyWorld) getWorld()).updateScoreForRight();
            
            setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2); // Reset ball 
            
        }
        
        // Check left boundary
        if (getX() <= getImage().getWidth()/2)
        {
            // Increase score
            ((MyWorld) getWorld()).updateScoreForLeft();
            
            setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2); // Reset ball
        }
        
        // Check bottom boundary 
        if (getY() >= (getWorld().getHeight()) - getImage().getHeight()/2)
        {
            deltaY = -deltaY;
        }
        
        // Check top boundary 
        if (getY() <= getImage().getHeight()/2)
        {
            deltaY = -deltaY;
        }
        
        Actor PaddleRight = getOneIntersectingObject(PaddleRight.class);
        Actor PaddleLeft = getOneIntersectingObject(PaddleLeft.class);
        
        if (PaddleRight != null || PaddleLeft != null)
        {
            deltaX = -deltaX;
        }
    }
}
