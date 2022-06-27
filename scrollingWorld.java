import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class scrollingWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class ScrollingWorld extends World
{
    //why static? because we want remove this later
    static Hp lives1 = new Hp();
    static Hp lives2 = new Hp();
    static Hp lives3 = new Hp();    
    static Counter health = new Counter();
    static Counter scores = new Counter("Score: ");
    
    private GreenfootImage bg0 = new GreenfootImage("bg/1.png");
    private GreenfootImage bg1 = new GreenfootImage("bg/2.png");
    private GreenfootImage bg2 = new GreenfootImage("bg/3.png");
    private GreenfootImage bg3 = new GreenfootImage("bg/4.png");
    private GreenfootImage bg4 = new GreenfootImage("bg/5.png");
    private GroundLong groundlong =  new GroundLong();
    
    
    public static int movement = 0;
    public static int actorMovement = 0;
    public static final int WIDE = 600; // world width (viewport)
    public static final int HIGH = 400; // world height (viewport)

    //Scroller scroller; // the object that performs the scrolling
    Actor scrollActor; // an actor to stay in view
        
    private ArrayList<Tree>trees = new ArrayList<Tree>();

    static Tree tree1, tree2, tree3, tree4, tree5;

    static GreenfootSound bgm = new GreenfootSound("bgm.wav");
    
    public ScrollingWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        health.setValue(3);
        scores.setValue(0);
        prepare();
        
        addObject(scores, 100, 20);
        addObject(lives1, 500, 20);
        addObject(lives2, 530, 20);
        addObject(lives3, 560, 20);  
        
    }
    
    void prepare(){
        actorMovement = 0;
        //create paralax bg 
        
        tree1 = new Tree();
        tree2 = new Tree();
        tree3 = new Tree();
        tree4 = new Tree();
        tree5 = new Tree();

        // treeFront = new Tree1();
        addObject(tree1, 300, 200);
        addObject(tree2, 300, 200);
        addObject(tree3, 300, 200);
        addObject(tree4, 300, 200);
        addObject(tree5, 300, 200);
        // addObject(treeFront, 300, 200);

        tree1.setBG(bg0);
        tree2.setBG(bg1);
        tree3.setBG(bg2);
        tree4.setBG(bg3);
        tree5.setBG(bg4);
        
        addObject(groundlong, 0, getHeight()-20);
        addObject(new Player(), 300, 200);
        addObject(new Enemy(),600, 320);
        addObject(new Candy(), 500, 300);
        
        setPaintOrder(Player.class, GroundLong.class);
        bgm.playLoop();
        
    }

      public void scrollGround(int dx){
            groundlong.move(dx);
       
    }


    public void paralaxBackground(int dx){
        trees.add(tree1);
        trees.add(tree2);
        trees.add(tree3);
        trees.add(tree4);
        trees.add(tree5);

        if(dx > 0){
            trees.get(4).setLocation(trees.get(4).getX()+dx-1, trees.get(4).getY());
            trees.get(3).setLocation(trees.get(3).getX()+dx-2, trees.get(3).getY());
            trees.get(2).setLocation(trees.get(2).getX()+dx-3, trees.get(2).getY());
        }else{
            trees.get(4).setLocation(trees.get(4).getX()+dx+1, trees.get(4).getY());
            trees.get(3).setLocation(trees.get(3).getX()+dx+2, trees.get(3).getY());
            trees.get(2).setLocation(trees.get(2).getX()+dx+3, trees.get(2).getY());
        }   
        }


    //getter setter for movement
    public int getMovement(){
        return movement;
    } 

    public void setMovement(int param){
        movement = param;
    }

    }