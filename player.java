import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    ScrollingWorld world = (ScrollingWorld) getWorld();
    private int fSpeed = 0;
    private int acceleration = 1;
    private int speed = 4;

    public void act()
    {
        GifImage img = World_Gender.gender;
        setImage(img.getCurrentImage());
        
        ScrollingWorld world = (ScrollingWorld) getWorld(); 
        if(Greenfoot.isKeyDown("left")){
            setImage(World_Gender.gender_mirror.getCurrentImage());
            if(ScrollingWorld.actorMovement > -400){
                ScrollingWorld.actorMovement -= speed;
                if(getX() >= +40 ){
                    move(-speed);
                    
                }else{
                        if(ScrollingWorld.actorMovement > -400){
                        ScrollingWorld.movement = speed;
                        world.scrollGround(speed);
                        world.paralaxBackground(speed);    
                        }else{
                            ScrollingWorld.movement = 0;  
                            world.scrollGround(0);
                            world.paralaxBackground(0);
                        }
                }
            }
        }
        
        else if(Greenfoot.isKeyDown("right")){
            setImage(World_Gender.gender.getCurrentImage());
            if(ScrollingWorld.actorMovement < 400){
                ScrollingWorld.actorMovement += speed;
                if(getX() <= (world.getWidth() -40)){
                    move(speed);
                    
                    }else{
                        if(ScrollingWorld.actorMovement < 400){
                            ScrollingWorld.movement = -speed;  
                            world.scrollGround(-speed);
                            world.paralaxBackground(-speed);
                        }else{
                            ScrollingWorld.movement = 0;  
                            world.scrollGround(0);
                            world.paralaxBackground(0);
                        }
                    }
            }
        }
        
        else{
                ScrollingWorld.movement = 0;
        }
        
        if(Greenfoot.isKeyDown("up")){
            if(getY()> world.getHeight()/4){
                setLocation(getX(), getY()-speed*4);
            }
            
        }
        
        chekFall();
        
    }

    public void chekFall(){
        if(onGround()){
            fSpeed = 0;
        }else{
            makeGrafity();
        }
    }

    public boolean onGround(){
        // Actor below = getOneObjectAtOffset(0, getImage().getHeight()/2 -4, Ground.class);
        boolean below = isTouching(GroundLong.class);
        return below;
    }

    void makeGrafity(){
        setLocation(getX(), getY() + fSpeed);
        fSpeed = fSpeed + acceleration;
    }

    }

