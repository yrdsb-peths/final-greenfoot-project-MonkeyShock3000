import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Blue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blue extends Actor
{
    //int yOne = Blue.getY();
    //int yTwo = Red.getY();
    //int xOne = Blue.getX();
    //int xTwo = Red.getX();
    
    /**
     * Act - do whatever the Blue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(x, yOne + 5);
        }
        
        else if(Greenfoot.isKeyDown("down"))
        {
            setLocation(x, yTwo + 5);
        }
    }
}
