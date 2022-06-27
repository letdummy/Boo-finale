import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GifImage bat = new GifImage("bat.gif");
    public void act()
    {
        // Add your action code here.
        int mv = ScrollingWorld.movement;
        move(mv + (-1));    
        
        setImage(bat.getCurrentImage());
        
        getHit();
    }


    public void setPending(int pendingValue){
        
        
        if(pendingValue == 0){

        }else{
            
        }

    }
    
    public void getHit(){
        if(isTouching(Player.class)){
            ScrollingWorld.blast.play();
            getWorld().addObject(new Enemy(), Greenfoot.getRandomNumber(600)+400, 
                                300);
            
            getWorld().addObject(new Blast(), getX(), getY());
            
            //MyWorld.score.add(5);          
            getWorld().removeObject(this);
            
        }
    }     
}
