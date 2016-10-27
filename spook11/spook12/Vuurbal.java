import greenfoot.*;

/**
 * Vuurbal die de heks naar het spook afschiet
 */
public class Vuurbal extends Animal
{
    private boolean rotated = false;
    private boolean isCountingDown = false;
    private boolean isMoving = true;
    private int explosieTimer = 10;
    
    private static GreenfootImage explosion = new GreenfootImage("explosie.png");
    
    /**
     * Constructor for objects of class Vuurbal
     */
    public Vuurbal()
    {
    }
    /**
     * Draaien richting spook als dat nog niet gebeurt is, vliegen en ontploffen
     */
    public void act()
    {
        if (!rotated)
        {
            Spook spook = getWorld().getObjects(Spook.class).get(0);
            turnTowards(spook.getX(), spook.getY());
            rotated = true;
        }
        if (isMoving)
        {
            move();
        }
        checkImpact();
        if (isCountingDown)
        {
            explosieTimer--;
        }
    }
    /**
     * check of we moeten ontploffen
     */
     public void checkImpact()
    {
        if ( canSee(Spook.class) ) 
        {
            eat(Spook.class);
            Greenfoot.playSound("explosie.wav");
            GreenfootSound sound = new GreenfootSound("heksGeluid.wav");
            sound.setVolume(80);
            sound.play();
            Greenfoot.setWorld(new Stopscherm());        
        } else {
            if ( atWorldEdge() ) 
            {
                GreenfootSound sound = new GreenfootSound("explosie.wav");
                sound.setVolume(75);
                sound.play();
                setImage(explosion);
                isCountingDown = true;
                isMoving = false;
                    if (explosieTimer == 0)
                    {
                        getWorld().removeObject(this);
                    }  
                }
            }
        }
}

