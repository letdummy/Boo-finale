import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Blast here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blast extends Actor
{
    /**
     * Act - do whatever the Blast wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GifImage blast = new GifImage("blast.gif");
    int pending = 15;
    public void act()
    {
        setImage(blast.getCurrentImage());
        
        pending--;
        if(pending == (0)){
            getWorld().removeObject(this);
        }        
    }
}
