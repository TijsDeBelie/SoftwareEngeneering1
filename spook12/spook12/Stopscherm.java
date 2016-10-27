import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GAME OVER!
 */
public class Stopscherm extends World
{

    /**
     * Constructor for objects of class Stopscherm.
     * 
     */
    public Stopscherm()
    {    
         super(560, 560, 1);
         addObject(HeksWorld.counter, 100, 40);
    }
    /**
     * als er geklikt wordt willen we nog eens spelen
     */
     public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Startscherm());
        }
    }
}
 