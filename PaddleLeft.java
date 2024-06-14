import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents the left paddle and controls its movement and speed 
 * 
 * @author Aaran 
 * @version June
 */
public class PaddleLeft extends Actor
{
    // Max speed, min speed, and the speed incerement constants
    private static final int BASE_SPEED = 4;
    private static final int MAX_SPEED = 7;
    private static final double SPEED_INCEREMENT = 0.25;
    
    /**
     * Act - do whatever the PaddleLeft wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * Checks if there was any keyboard input and either moves up or down while adjusting the paddle's speed
     */
    public void act()
    {
        // Add your action code here.
        World world = getWorld(); //gets current world
        if (world instanceof MyWorld)
        {
            MyWorld myWorld = (MyWorld) world; // Casts world to my world
            
            int scoreRight = myWorld.getScoreRight(); // Gets score for player two
            int movementSpeed = calcSpeed(scoreRight); // calculates speed
            
            handleMove(movementSpeed); // Handles movement such as keyboard input
            
        }
    }
    /**
     * Calculates current speed of paddle based on the opposite score
     * @param score The score of the right player, affects speed
     * @return the speed
     */ 
    private int calcSpeed(int score)
    {
        int speed = (int) (BASE_SPEED + SPEED_INCEREMENT * score); // Calculates speed
        
        // Caps speed from exceeding the max speed
        if (speed > MAX_SPEED)
        {
            speed = MAX_SPEED;
        }
        
        return speed;
    }
    
    /**
     * Handles movement of paddles
     * @param speed the speed that the paddle should move at, accounts for the score too
     */
    private void handleMove(int speed)
    {
        // Moves paddle up when the w key is pressed and accounts for the speed
        if (Greenfoot.isKeyDown("w") && getY() > getImage().getHeight()/2)
            {
                setLocation(getX(), getY() - speed);
            }
        
        // Moves paddle down when the s key is pressed and accounts for the speed     
        if (Greenfoot.isKeyDown("s") && getY() < getWorld().getHeight() - getImage().getHeight()/2)
            {
                setLocation(getX(), getY() + speed);
            }
    }
}
