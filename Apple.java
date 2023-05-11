import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage apple = new GreenfootImage("apple.png");
    public void act()
    {
        move(1);
    }
    
    public Apple(){
        apple.rotate(-90);
        setImage(apple);
        setRotation(90);
    }
}
