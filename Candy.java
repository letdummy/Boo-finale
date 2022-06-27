import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Candy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Candy extends Actor
{
    /**
     * Act - do whatever the Candy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound pointSound = new GreenfootSound("point.wav");
    GifImage candy = new GifImage("candy.gif");
    public void act()
    {
        setImage(candy.getCurrentImage());
        int mv = ScrollingWorld.movement;
        move(mv); 
        getScore();
        
        
    }
    
    //create sound effect, create new Candy, create Spark for fancy look, adding 5 point to scored, and delete this(Candy)
    public void getScore(){
        if(isTouching(Player.class)){
            pointSound.play();
            getWorld().addObject(new Candy(), Greenfoot.getRandomNumber(600), 300);
            
            getWorld().addObject(new Spark(), getX(), getY());
            
            ScrollingWorld.scores.add(5);          
            getWorld().removeObject(this);
            
        }
    }    
}
