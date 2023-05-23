import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{   
    private int score = 0;
    Label scoreLabel = new Label(0, 50);
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        setBackground(new GreenfootImage("Savanna.jpg"));
        
        // Adds objects
        addObject(new Elephant(), 0, 300);
        placeApple();
        
        // Create a label
        addObject(scoreLabel, 50, 50);
        
    }
    
    public void gameOver(){
        Label endGame = new Label("Game Over", 100);
        addObject(endGame, 300, 200);
    }
    
    public void placeApple(){
        int x = Greenfoot.getRandomNumber(600);
        addObject(new Apple(), x, 0);
    }
    
    public void updateScore(){
        score++;
        scoreLabel.setValue(score);
    }
}
