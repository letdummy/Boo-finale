import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{

    GreenfootSound blastSound = new GreenfootSound("blast.wav");
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

    public void getHit(){
        if(isTouching(Player.class)){
            blastSound.play();
            getWorld().addObject(new Enemy(), 620 + Greenfoot.getRandomNumber(200), 240 + Greenfoot.getRandomNumber(100));
            getWorld().addObject(new Blast(), getX(), getY());
            ScrollingWorld.health.add(-1);   
            checkLives();
            getWorld().removeObject(this);
            
        }else if(getX() < -300){
            getWorld().addObject(new Enemy(), 620 + Greenfoot.getRandomNumber(200), 240 + Greenfoot.getRandomNumber(100));
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
            //if nyawa == 1, then it will stop bgm.wav playLoop,
            //and change current world into World_End
            getWorld().addObject(new Hp0(), ScrollingWorld.lives1.getX(),
                                            ScrollingWorld.lives1.getY());
            ScrollingWorld.bgm.stop();
            Greenfoot.setWorld(new World_End());
        }        
    }
}
