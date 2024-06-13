import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The right paddle 
 * 
 * @author Aaran
 * @version June 2024
 */
public class PaddleRight extends Actor
{
    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.isKeyDown("up") && getY() > getImage().getHeight()/2)
        {
            setLocation(getX(), getY() - 2);
            // Add (score - 2)
        }
        
        if (Greenfoot.isKeyDown("down") && getY() < getWorld().getHeight() - getImage().getHeight()/2)
        {
            setLocation(getX(), getY() + 2);
            // Add (score + 2)
        }
    }
}
