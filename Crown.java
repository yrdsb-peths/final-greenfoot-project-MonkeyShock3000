import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents crown object 
 * Handles initialization and scaling of the image
 * 
 * @author Aaran
 * @version June
 */
public class Crown extends Actor
{
    /** 
     * Constructor for the Crown class
     */
    public Crown()
    {
        GreenfootImage crown = new GreenfootImage("Crown.png"); // initializes the image
        crown.scale(100, 100); // Scales image
        setImage(crown); // Sets the scaled image
    }
}
