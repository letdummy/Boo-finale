import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Female here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Female extends Actor
{
    /**
     * Act - do whatever the Female wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    //default value is female_select.gif, but once this object clicked
    //the value is updated into female_right.gif
    GifImage female = new GifImage("female_select.gif");
    GifImage female_mirror = new GifImage("female_left.gif");
    
    public void act()
    {
        setImage(female.getCurrentImage());
        
        //to select character female
        //edit gender and gender_mirror value in World_Gender 
        //into new GifImage("female_right.gif");
        //and new GifImage("female_left.gif");          
        if(Greenfoot.mouseClicked(this)){
            World_Gender.gender = new GifImage("female_right.gif");
            World_Gender.gender_mirror = female_mirror;
            World_Gender.selector.stop();
            Greenfoot.setWorld(new ScrollingWorld());
        }
    }
}
