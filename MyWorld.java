import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main world in which the game shall be played in
 * 
 * @author Dylan Windsor 
 * @version May 29th
 */
public class MyWorld extends World
{   
    // Scoring variablea=s
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
    
    /*
     * Method to end the game
     */
    public void gameOver(){
        Label endGame = new Label("Game Over", 100);
        addObject(endGame, 300, 200);
        Greenfoot.stop();
    }
    
    /**
     * Method that places apple randomly around the world
     */
    public void placeApple(){
        int x = Greenfoot.getRandomNumber(600);
        Apple apple = new Apple();
        apple.classIn = "MyWorld";
        addObject(apple, x, 0);
    }
    
    /*
     * Method that increases score label by 1
     */
    public void updateScore(){
        score++;
        scoreLabel.setValue(score);
    }
}
