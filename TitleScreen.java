import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Hungry Elephant", 50);
    Label subLabel = new Label("Press \"Enter\" to start", 25);
    Label tutorial = new Label("Press \"Space\" for the tutorial", 25);
    /**
     * Constructor for objects of class TitleScreen.
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        // Adds a bunch of labels
        addObject(titleLabel, 300, 180);
        addObject(subLabel, 300, 230);
        addObject(tutorial, 300, 260);
    }
    
    /**
     * Directs user to main game
     * or tutorial based on which
     * key they press
     */
    public void act(){
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new MyWorld());
        }
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new TutorialScreen());
        }
    }
}
