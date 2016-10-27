import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)


public class HeksWorld extends World
{
   public static Counter counter;
   public static GreenfootImage background1 = new GreenfootImage("kat.png");
   public static GreenfootImage background2 = new GreenfootImage("pompoenAchtergrond.png");
   public static GreenfootImage background3 = new GreenfootImage("heksAchtergrond.png");
   public static GreenfootImage backgroundGameOver = new GreenfootImage("game over.png");
   
   
   public static Spook spook;
   
   
    /**
     * Create the world. Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    public HeksWorld() 
    {
        super(560, 560, 1);
        counter = new Counter();
        populateWorld();
        Heksje.speed = 5;
        setPaintOrder(Counter.class, Heksje.class, Vuurbal.class, Spook.class, Pompoen.class);
    }
    
    /**
    * Schrijf een methode in de overkoepeling "wereld" om de counter in de wereld te returnen
    * (ophalen uit het origineel voor wie hem ook nodig mag hebben met de naam getCounter
    */
    public Counter getCounter()
    {
        return counter;
        
    }
    
    /**
     * zet alle objecten op de wereld
     */
    public void populateWorld()
    {
        spook = new Spook();
        
        addObject(spook, 280, 280);
        addObject(counter, 100, 40);
        
        addWitches(2);
        addPumpkins(10);
    }
    
    /**
     * voeg pompoenen toe
     */
    public void addPumpkins(int amount) {
        for (int i = 0; i < amount; i++) {
            addObject(new Pompoen(), Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
        }
    }
    
    /**
     * voeg heksen toe, heksen zullen niet binnen de 50px van het spook gezet worden
     */
    public void addWitches(int amount) {
        for (int i = 0; i < amount; i++) {
            int x = Greenfoot.getRandomNumber(560);
            int y = Greenfoot.getRandomNumber(560);
            while (x > spook.getX() - 50 && x < spook.getX() + 50) {
                x = Greenfoot.getRandomNumber(560);
            }
            while (y > spook.getY() - 50 && y < spook.getY() + 50) {
                y = Greenfoot.getRandomNumber(560);
            }
            addObject(new Heksje(), x, y);
        }
    }
}

