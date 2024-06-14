import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represents the ball object and deals with collisions
 * 
 * @author Aaran
 * @version June
 */
public class Ball extends Actor
{
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // Sounds
    GreenfootSound paddleHitNoise = new GreenfootSound("paddleHitNoise.mp3");
    GreenfootSound wallHitNoise = new GreenfootSound("wallHitNoise.mp3");
    GreenfootSound pointNoise = new GreenfootSound("pointNoise.mp3");
    
    // Speeds
    public int deltaX = 2;
    public int deltaY = 2;
    
    /**
     * Handles the movement and checks for collisions
     */
    public void act()
    {
        // Add your action code here.
               
        move();
        checkCollisions();
    }
    
    /**
     * Moves the ball 
     */
    private void move()
    {
       setLocation(getX() + deltaX, getY() +  deltaY); 
    }
    
    /**
     * Checks for and handles collisions with objects and boundries, and plays sounds.
     * Also, managing points.
     */
    public void checkCollisions()
    {
        World myWorld = getWorld(); // Gets current world
        if (myWorld == null) // If no world is present, exit the method
        {
            return;
        }
        
        // Check right boundary 
        if (getX() >= (getWorld().getWidth() - getImage().getWidth()/2))
        {
            // Increase score
            ((MyWorld) getWorld()).updateScoreForRight();
            pointNoise.play(); //Plays sound
            setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2); // Reset ball 
            
        }
        
        // Check left boundary
        if (getX() <= getImage().getWidth()/2)
        {
            // Increase score
            ((MyWorld) getWorld()).updateScoreForLeft(); //Updates score
            pointNoise.play(); // Plays sound
            setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2); // Reset ball
        }
        
        // Check bottom boundary 
        if (getY() >= (getWorld().getHeight()) - getImage().getHeight()/2)
        {
            wallHitNoise.play(); //Plays wall hit sound
            deltaY = -deltaY; // Switches the y-direction of the ball
        }
        
        // Check top boundary 
        if (getY() <= getImage().getHeight()/2)
        {
            wallHitNoise.play(); //Plays wall hit sound
            deltaY = -deltaY; // Switches the y-direction of the ball
        }
        
        // Checks for collisions with either paddle
        Actor PaddleRight = getOneIntersectingObject(PaddleRight.class);
        Actor PaddleLeft = getOneIntersectingObject(PaddleLeft.class);
        
        if (PaddleRight != null || PaddleLeft != null)
        {
            paddleHitNoise.play(); // Plays paddle hit noise
            deltaX = -deltaX; // Switches ball x-direction
        }
    }
}
