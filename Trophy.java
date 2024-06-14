import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The trophy at the end of the game (end screen).
 * 
 * @author Aaran 
 * @version June
 */
public class Trophy extends Actor
{
    GreenfootImage[] trophy = new GreenfootImage[6]; // Array containing trophy images for the animation
    
    int imageIndex = 0; // index tracking the current image
    
    private int delayCount = 0; // the delay between frames
    private final int DELAY_LEN = 50; // Delay length 
    
    /**
     * Constructor for objects 
     * Initializes the trophy images and set the initial image
     */
    public Trophy()
    {
        for(int i = 1; i < trophy.length; i++)
        {
            // Loads and scales each image 
            trophy[i] = new GreenfootImage("images/trophy/Trophy" + i + ".png");   
            trophy[i].scale(100, 100);
             
        }
        
        setImage(trophy[0]); // Sets initial image 
    }
    
    /**
     * Animates the array of images
     */
    public void animateTrophy()
    {
        imageIndex = (imageIndex + 1) % trophy.length; // Increments each image
        setImage(trophy[imageIndex]); //Sets each image
    }
    
    /**
     * Delays the animation to make it slower
     */
    private void delayAnimation()
    {
        // Runs the delay counter
        delayCount++; 
        if (delayCount < DELAY_LEN)
        {
            delayCount++;
        }
        
        else
        {
            //animates the trophy and resets counter
            animateTrophy();
            delayCount = 0;
        }
    }
    
    /**
     * Act - do whatever the Trophy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        delayAnimation(); // controls the animation
    }
}
