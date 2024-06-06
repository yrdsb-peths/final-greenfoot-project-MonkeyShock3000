import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Paddle 
 * 
 * @author Aaran
 * @version June 2024
 */
public class Paddle extends Actor
{
    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - 3);
        }
        
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + 3);
        }
    }
}
