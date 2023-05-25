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
    GreenfootImage[] elephantIdleRight = new GreenfootImage[8];
    GreenfootImage[] elephantIdleLeft = new GreenfootImage[8];
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    String facing = "right";
        
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
        for(int i = 0; i < elephantIdleRight.length; i++){
            elephantIdleRight[i] = new GreenfootImage("elephant_idle/idle" + i + ".png");
            elephantIdleRight[i].scale(100, 100);
        }
        setImage(elephantIdleRight[0]);
        
        for(int i = 0; i < elephantIdleRight.length; i++){
            elephantIdleLeft[i] = new GreenfootImage("elephant_idle/idle" + i + ".png");
            elephantIdleLeft[i].scale(100, 100);
            elephantIdleLeft[i].mirrorVertically();
        }
    }
    
    int animationIndex = 0;
    public void animateElephant(){
        if(facing.equals("right")){
            setImage(elephantIdleRight[animationIndex]);
            animationIndex = (animationIndex + 1) % elephantIdleRight.length;
        }
        else{
            setImage(elephantIdleLeft[animationIndex]);
            animationIndex = (animationIndex + 1) % elephantIdleLeft.length;
        }
    }
    
    public void moveRight(){
        facing = "right";
        setRotation(0);
        move(4);
    }
    
    public void moveLeft(){
        facing = "left";
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
