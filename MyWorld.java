import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{   
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(new Elephant(), 0, 300);
        placeApple();
        
        // Create a label
        Label scoreLabel = new Label(0, 50);
        addObject(scoreLabel, 50, 50);
        
    }
    
    public void placeApple(){
        int x = Greenfoot.getRandomNumber(600);
        addObject(new Apple(), x, 0);
    }
}
