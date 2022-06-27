import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spark extends Actor
{
    /**
     * Act - do whatever the Spark wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GifImage spark = new GifImage("spark.gif");
    
    int pending = 15;
    public void act()
    {
        setImage(spark.getCurrentImage());
        
        pending--;
        if(pending == (0)){
            getWorld().removeObject(this);
        }
    }
}
