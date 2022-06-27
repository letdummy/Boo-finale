import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World_End here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World_End extends World
{
    static GreenfootSound end = new GreenfootSound("end.wav");
    public World_End()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        logic();
    }
    
    public void logic(){
        end.playLoop();
        
        //Create dark situation look
        addObject(new BgEnd(), 300, 200);
        addObject(new GameOver(), 295, 150);
    
        //Create empty health look
        addObject(new Hp0(), ScrollingWorld.lives3.getX(), 
                             ScrollingWorld.lives3.getY());         
        addObject(new Hp0(), ScrollingWorld.lives2.getX(), 
                             ScrollingWorld.lives2.getY()); 
        addObject(new Hp0(), ScrollingWorld.lives1.getX(), 
                             ScrollingWorld.lives1.getY());  
                             
        //Add graveyard
        addObject(new Rip(), 300, 250);
        addObject(ScrollingWorld.scores, 300, 300);
        
        //Add retry button
        addObject(new Door(), 550, 350);
    }    
}
