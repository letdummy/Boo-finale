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
    /**
     * Constructor for objects of class scrollingWorld.
     * Add image bg for background
     */
    
    
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
    
    /**
     * Constructor for objects of class scrollingWorld.
     * 
     */
        
    private ArrayList<Tree>trees = new ArrayList<Tree>();
    private ArrayList<Tree1>treeFronts = new ArrayList<Tree1>(); 
    static Counter counter = new Counter();
    static Counter counter2 = new Counter();

    static Tree tree1, tree2, tree3, tree4, tree5, tree1F, tree1L, tree2F, tree2L ;
    Tree1 treeFront;
    private ArrayList<Ground> grounds = new ArrayList<Ground>();
    Ground first,last;

    static GreenfootSound point = new GreenfootSound("point.wav");
    static GreenfootSound blast = new GreenfootSound("blast.wav");
    
    public ScrollingWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        prepare();
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
        
        addObject(counter,72,37);
        addObject(counter2,72,60);
        counter.setValue(actorMovement);
    }

    

    public void addGround(boolean addToRight){
        int _x, _y;
        
        Ground ground = new Ground();

        if(last.getX() > 800){

        }else{
            if(addToRight){
                _x = last.getX() + ground.getWidth();
                _y = last.getY();
                last = ground;
            }else{
                _x = first.getX()- ground.getWidth();
                _y = first.getY();
                first = ground;
            }

            addObject(ground, _x, _y);
            grounds.add(ground);
        }

    }


      public void scrollGround(int dx){
            groundlong.move(dx);
       
    }


    public void paralaxBackground(int dx){

        counter2.setValue(dx);

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