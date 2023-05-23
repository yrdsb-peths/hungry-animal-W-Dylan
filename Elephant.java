import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage elephantRight = new GreenfootImage("elephant_idle.png");
    GreenfootImage elephantLeft = new GreenfootImage("elephant_idle.png");
        
    public void act(){
        if(Greenfoot.isKeyDown("right")){
            moveRight();
        }
        else if(Greenfoot.isKeyDown("left")){
            moveLeft();
        }
        
        if(isTouching(Apple.class)){
            eat();
        }
    }
    
    // Constructor
    public Elephant(){
        setImage(elephantRight);
        elephantLeft.mirrorVertically();
    }
    
    public void moveRight(){
        setImage(elephantRight);
        setRotation(0);
        move(4);
    }
    
    public void moveLeft(){
        setImage(elephantLeft);
        setRotation(180);
        move(4);
    }
    
    public void eat(){
        removeTouching(Apple.class);
        MyWorld world = (MyWorld) getWorld();
        world.placeApple();
        world.updateScore();
    }
}
