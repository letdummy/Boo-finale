import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Actor
{
    /**
     * Act - do whatever the Door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GifImage door = new GifImage("door.gif");
    public void act()
    {
        setImage(door.getCurrentImage());
        
        //when it is clicked, it will stop end.wav playLoop, change current world into World_Gender.
        //and start to playLoop the selector.wav
        if(Greenfoot.mouseClicked(this)){
            World_End.end.stop();
            Greenfoot.setWorld(new World_Gender());
            World_Gender.selector.playLoop();
        }
        
        getWorld().showText("retry", getX(), getY()+30);        
    }
}
