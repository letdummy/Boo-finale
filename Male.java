import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Male here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Male extends Actor
{
    /**
     * Act - do whatever the Male wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    //default value is male_select.gif, but once this object clicked
    //the value is updated into male_right.gif
    GifImage male = new GifImage("male_select.gif");
    GifImage male_mirror = new GifImage("male_left.gif");
    
    public void act()
    {
        setImage(male.getCurrentImage());
        
        //to select character male
        //edit gender and gender_mirror value in World_Gender 
        //into new GifImage("male_right.gif");
        //and new GifImage("male_left.gif");        
        if(Greenfoot.mouseClicked(this)){
            GifImage male = new GifImage("male_right.gif");
            World_Gender.gender = male;
            World_Gender.gender_mirror = male_mirror;
            World_Gender.selector.stop();
            Greenfoot.setWorld(new ScrollingWorld());
        }        
    }
}
