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
    GreenfootImage[] elephantIdle = new GreenfootImage[8];
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
        
    public void act(){ 
        if(Greenfoot.isKeyDown("right")){
            moveRight();
        }
        else if(Greenfoot.isKeyDown("left")){
            moveLeft();
        }
        
        if(isTouching(Apple.class)){
            eat();
            elephantSound.play();
        }
        animateElephant();
    }
    
    // Constructor
    public Elephant(){
        for(int i = 0; i < elephantIdle.length; i++){
            elephantIdle[i] = new GreenfootImage("elephant_idle/idle" + i + ".png");
        }
        setImage(elephantIdle[0]);

    }
    
    int animationIndex = 0;
    public void animateElephant(){
        setImage(elephantIdle[animationIndex]);
        animationIndex = (animationIndex + 1) % elephantIdle.length;
    }
    
    public void moveRight(){
        setRotation(0);
        move(4);
    }
    
    public void moveLeft(){
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
