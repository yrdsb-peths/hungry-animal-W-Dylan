import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialScreen extends World
{
    int appleMade = 0;
    Label instructions = new Label("Use the arrow keys to move left and right", 25);
    Label skip = new Label("Press enter to skip", 15);
    boolean pressLeft = false;
    boolean pressRight = false;
    boolean beginningSequence = true;
    SimpleTimer timer = new SimpleTimer();
    /**
     * Constructor for objects of class TutorialScreen.
     */
    public TutorialScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        addObject(instructions, 300, 200);
        addObject(skip, 535, 15);
        addObject(new Elephant(), 0, 300);
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new MyWorld());
        }
        if(beginningSequence){
            if(Greenfoot.isKeyDown("right")){
                pressRight = true;
                }
            if(Greenfoot.isKeyDown("left")){
                timer.mark();
                pressLeft = true;
            }
            if(pressRight && pressLeft && (timer.millisElapsed() >= 500)){
                beginningSequence = false;
                removeObject(instructions);
                instructions = new Label("Touch the apple to eat it!", 25);
                addObject(instructions, 300, 200);
                Apple apple = new Apple();
                apple.classIn = "TutorialScreen";
                if(appleMade < 1){
                    addObject(apple, 300, 0);
                    appleMade++;
                }
            }
        }
    }
    
    public void ateApple(boolean isEaten){
        if(isEaten){
            removeObject(instructions);
            removeObject(skip);
            instructions = new Label("Press enter to play!", 25);
            addObject(instructions, 300, 200);
        }
        int x = Greenfoot.getRandomNumber(600);
        addObject(new Apple(), x, 0);
    }
}
