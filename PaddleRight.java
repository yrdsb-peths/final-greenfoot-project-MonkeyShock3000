import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents the right paddle and controls its movement and speed 
 * 
 * @author Aaran
 * @version June 2024
 */
public class PaddleRight extends Actor
{
    // Max speed, min speed, and the speed incerement constants
    private static final int BASE_SPEED = 4;
    private static final int MAX_SPEED = 7;
    private static final double SPEED_INCEREMENT = 0.25;
    
    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
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
            int scoreLeft = myWorld.getScoreLeft(); // Gets score for player one
            int speed = calcSpeed(scoreLeft); // calculates speed
            
            // Moves paddle up when down arrow is pressed and accounts for the speed
            if (Greenfoot.isKeyDown("up") && getY() > getImage().getHeight()/2 - 4)
            {
                setLocation(getX(), getY() - speed);
            }
            
            // Moves paddle down when down arrow is pressed and accounts for the speed 
            if (Greenfoot.isKeyDown("down") && getY() < getWorld().getHeight() - getImage().getHeight()/2 + 4)
            {
                setLocation(getX(), getY() + speed);
            }
        }
    }
    
    /**
     * Calculates current speed of paddle based on the opposite score
     * @param score The score of the left player, affects speed
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
}
