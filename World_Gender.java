import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
   Created by:
   Agus Ardiansyah Nh
   Aldin Nasrun Minalloh
   Hanifah Afkar Nabila
*/
public class World_Gender extends World
{
    //created static empty variable so that we can use/edit its value later
    static GifImage gender;
    static GifImage gender_mirror;
    
    static GreenfootSound selector = new GreenfootSound("selector.wav");

    
    public World_Gender()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);         
        prepare();
    }

    private void prepare()
    {
        
        //simply, this will executed before world played(run)
        
        //Create a letter
        GreenfootImage textTitle = new GreenfootImage("Select Gender", 32, Color.BLACK, new Color(0,0,0,0));
        getBackground().drawImage(textTitle, 219, 100); 
        
        Female female = new Female();
        female.setImage("images/female_select.gif");
        addObject(female,200,200);
        Male male = new Male();
        male.setImage("images/male_select.gif");
        addObject(male,400,200);
             
    }    
    
    public void started(){
        selector.playLoop();
    }
}
