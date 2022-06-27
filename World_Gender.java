import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World_Gender here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World_Gender extends World
{

    static GifImage gender;
    static GifImage gender_mirror;
    
    /**
     * Constructor for objects of class World_Gender.
     * 
     */
    public World_Gender()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        prepare();
    }
    
    private void prepare()
    {
        //simply, this will executed before world played(run)
        showText("Select Gender",300,100);
        Female female = new Female();
        addObject(female,200,200);
        Male male = new Male();
        addObject(male,400,200);
    }    
}
