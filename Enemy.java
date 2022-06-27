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
    int nyawa = ScrollingWorld.health.getValue();
    
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
            
            ScrollingWorld.health.add(-1);   
            checkLives();
            getWorld().removeObject(this);
            
        }
    }     
    
    public void checkLives(){
        if(nyawa == (3)){
            //Replace or menimpa Hp to Hp0 in exact same location
            //to create effect that Hp reduced            
            getWorld().addObject(new Hp0(), ScrollingWorld.lives3.getX(),
                                            ScrollingWorld.lives3.getY());
        }
        
        else if(nyawa ==(2)){
            //Replace or menimpa Hp to Hp0 in exact same location
            //to create effect that Hp reduced 
            getWorld().addObject(new Hp0(), ScrollingWorld.lives2.getX(),
                                            ScrollingWorld.lives2.getY());
        }
        
        else if(nyawa == (1)){
            getWorld().addObject(new Hp0(), ScrollingWorld.lives1.getX(),
                                            ScrollingWorld.lives1.getY());
            Greenfoot.setWorld(new World_End());
        }        
    }
}
