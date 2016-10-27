import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * De heks, heksen jagen graag op spoken
 */

public class Heksje extends Animal
{
    
    private GreenfootSound geluid;
    public static int speed = 5;
    
    public Heksje() {
        geluid = new GreenfootSound("heksGeluid.wav");
        geluid.setVolume(80);
    }
    
    /**
     * De act brengt de heks tot leven (draaien, vliegen, schieten, eten)
     */
    public void act()
    {
        turnAtEdge();
        randomTurn();
        move(speed);
        vuurbal();
        lookForSpook();        
    }

    /**
     * Check whether we are at the edge of the world. If we are, turn a bit.
     * If not, do nothing.
     */
    public void turnAtEdge()
    {
        if ( atWorldEdge() ) 
        {
            turn(17);
        }
    }

    /**
     * Randomly decide to turn from the current direction, or not. If we turn
     * turn a bit left or right by a random degree.
     */
    public void randomTurn()
    {
        if(Greenfoot.getRandomNumber(100) > 90) {
            turn(Greenfoot.getRandomNumber(90)-45);
        }
    }

    /**
     * Check of we een spook te pakken hebben, hebben we hem dan is het game over
     */
    public void lookForSpook()
    {
        if ( canSee(Spook.class) ) 
        {
            eat(Spook.class);
            geluid.play();            
            Greenfoot.setWorld(new Stopscherm());      
        }
   }
    
    
   /**
    * Schiet random vuurballen naar het spook
    */
   private void vuurbal()
   {
        if (Greenfoot.getRandomNumber(1000) < 4)
        {
            getWorld().addObject(new Vuurbal(), this.getX(), this.getY());
            GreenfootSound sound = new GreenfootSound("vuurbal.wav");
            sound.setVolume(75);
            sound.play();
        }
   }
}

