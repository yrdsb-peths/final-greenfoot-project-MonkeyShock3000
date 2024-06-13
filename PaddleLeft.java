import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PaddleLeft here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PaddleLeft extends Actor
{
    /**
     * Act - do whatever the PaddleLeft wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        
        if (Greenfoot.isKeyDown("w") && getY() > getImage().getHeight()/2)
        {
            setLocation(getX(), getY() - 2);
            // Add (score - 2)
        }
        
        if (Greenfoot.isKeyDown("s") && getY() < getWorld().getHeight() - getImage().getHeight()/2)
        {
            setLocation(getX(), getY() + 2);
            // Add (score + 2)
        }
    }
}
