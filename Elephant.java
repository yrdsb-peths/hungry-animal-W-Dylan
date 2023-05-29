import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The sprite with which the player shall be controlling
 * 
 * @author Dylan Windsor
 * @version May 29th
 */
public class Elephant extends Actor{
    // Empty arrays to store the images of the elephant
    GreenfootImage[] elephantIdleRight = new GreenfootImage[8];
    GreenfootImage[] elephantIdleLeft = new GreenfootImage[8];
    
    // Elephant sound
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    
    // Direction elephant faces
    String facing = "right";
    
    // Timer to control the animation speed
    SimpleTimer animationTimer = new SimpleTimer();
        
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){ 
        // Moves elephant based on user input
        if(Greenfoot.isKeyDown("right")){
            moveRight();
        }
        else if(Greenfoot.isKeyDown("left")){
            moveLeft();
        }
        
        // Checks if the elephant is touching the apple & then removes it
        if(isTouching(Apple.class)){
            eat();
            elephantSound.play();
        }
        
        // Calling of method that animates the elephant
        animateElephant();
    }
    
    /**
     * Constructor for elephant
     */ 
    public Elephant(){   
        // Assigns images to the previous empty array
        for(int i = 0; i < elephantIdleRight.length; i++){
            elephantIdleRight[i] = new GreenfootImage("elephant_idle/idle" + i + ".png");
            elephantIdleRight[i].scale(100, 100);
        }
        setImage(elephantIdleRight[0]);
        
        // Same thing as above but for when the elephant is facing left
        for(int i = 0; i < elephantIdleLeft.length; i++){
            elephantIdleLeft[i] = new GreenfootImage("elephant_idle/idle" + i + ".png");
            elephantIdleLeft[i].mirrorHorizontally();
            elephantIdleLeft[i].scale(100, 100);
        }
        
        // Starts animation timer
        animationTimer.mark();
    }
    
    // Variable for which image of the elephant the animation is on
    int animationIndex = 0;
    
    /**
     * Method to animate the elephant
     */
    public void animateElephant(){
        if(animationTimer.millisElapsed() > 150){
            if(facing.equals("right")){
                setImage(elephantIdleRight[animationIndex]);
                animationIndex = (animationIndex + 1) % elephantIdleRight.length;
            }
            else{
                setImage(elephantIdleLeft[animationIndex]);
                animationIndex = (animationIndex + 1) % elephantIdleLeft.length;
            }
            animationTimer.mark();
        }
    }
    
    /*
     * Method to move the elephant right
     */
    public void moveRight(){
        facing = "right";
        setRotation(0);
        move(4);
    }
    
    /*
     * Method to move the elephant left
     */
    public void moveLeft(){
        facing = "left";
        move(-4);
    }
    
    /**
     * Method to 'eat' the apple or rather removes the apple and creates
     * a new one in a random spot
     */
    public void eat(){
        removeTouching(Apple.class);
        MyWorld world = (MyWorld) getWorld();
        world.placeApple();
        world.updateScore();
    }
}
