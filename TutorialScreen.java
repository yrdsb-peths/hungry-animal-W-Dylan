import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialScreen extends World
{
    Label instructions = new Label("Use the arrow keys to move left and right", 25);
    boolean pressLeft = false;
    boolean pressRight = false;
    SimpleTimer timer = new SimpleTimer();
    /**
     * Constructor for objects of class TutorialScreen.
     */
    public TutorialScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(instructions, 300, 200);
        addObject(new Elephant(), 0, 300);
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("right")){
            pressRight = true;
            }
        if(Greenfoot.isKeyDown("left")){
            timer.mark();
            pressLeft = true;
        }
        if(pressRight && pressLeft && (timer.millisElapsed() >= 1000)){
            Greenfoot.setWorld(new SecondTutorial()); 
        }
    }
}
