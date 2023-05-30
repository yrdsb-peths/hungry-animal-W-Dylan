import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An object which the player wants their sprite to 'eat'
 * 
 * @author Dylan Windsor 
 * @version May 29th
 */
public class Apple extends Actor
{
    // Variable to change the behaviour based on which world it's in
    public static String classIn;
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // Assigns an image to this object
    GreenfootImage apple = new GreenfootImage("apple.png");
    public void act()
    {
        move(2);
        
        /*
         * Creates a copy of MyWorld and ends the game if the position 
         * of the apple is below it
         */
        if(classIn.equals("MyWorld")){
            MyWorld world = (MyWorld) getWorld();
            if(getY() >= world.getHeight()){
                world.gameOver();
                world.removeObject(this);
            }
        }
        else if(classIn.equals("TutorialScreen")){
            TutorialScreen world = (TutorialScreen) getWorld();
            if(getY() >= world.getHeight()){
                world.removeObject(this);
                world.ateApple(false);
            }
        }
    }
    
    /**
     * Constructor for Apple class
     */
    public Apple(){
        apple.scale(40, 40);
        apple.rotate(-90);
        setImage(apple);
        setRotation(90);
    }
}
