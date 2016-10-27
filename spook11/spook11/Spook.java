import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
/**
 * 
 */
public class Spook extends Animal
{
    private GreenfootImage afbeelding1;
    private GreenfootImage afbeelding2;
    private int pumpkinsEaten = 0;
    private int counter = 0;
    
    /**
     * Maak een nieuwe Spook-object en initialiseer de twee afbeeldingen
     */
    public Spook()
    {
        afbeelding1 = new GreenfootImage("spookje.png");
        afbeelding2 = new GreenfootImage("spookje2.png");
    }
    
    /** 
     * de act: beweeg, animeer en eten
     */
    public void act()
    {
        checkKeypress();
        switchImage();
        tryToEat();
    }
    
    /**
     * het spel wordt moeilijker, toevoegen van pompoenen, heksen, snellere heksen en andere achtergronden
     */
    private void makeHarder() {
        HeksWorld world = (HeksWorld) getWorld();
        if (pumpkinsEaten % 3 == 0) {
            world.setBackground(HeksWorld.background2);
            world.addPumpkins(3);
        }
        if (pumpkinsEaten % 6 == 0) {
            world.setBackground(HeksWorld.background3);
            world.addWitches(1);
        }
        if (pumpkinsEaten % 9 == 0) {
            world.setBackground(HeksWorld.background1);
            Heksje.speed +=2;
        }
    }
    
    /**
     * eet de pompoenen als we kunnen
     */
    public void tryToEat() {
        if(canSee(Pompoen.class)){
             HeksWorld world =(HeksWorld) getWorld();
            eat(Pompoen.class);
            pumpkinsEaten++;
            world.getCounter().addScore();
            Greenfoot.playSound("eetGeluid.wav");
            makeHarder();
        }
    }
    
    /**
     * Verander de afbeeling van het spook zodat het beweegt
     */
    public void switchImage()
    {
        counter++;
        if (counter == 4) {
            counter = 0;
            if(getImage() == afbeelding1)
            {
                setImage(afbeelding2);
            }
            else
            {
                setImage(afbeelding1);
            }
        }
    }
    /**
     * Check whether a control key on the keyboard has been pressed.
     * If it has, react accordingly.
     */
    public void checkKeypress()
    {
        if (Greenfoot.isKeyDown("up")) 
        {
            this.setLocation(this.getX(), this.getY() - 5);
        }
        if (Greenfoot.isKeyDown("down")) 
        {
            this.setLocation(this.getX(), this.getY() + 5);
        }
        
        if (Greenfoot.isKeyDown("left")) 
        {
           this.setLocation(this.getX() - 5, this.getY());
        }
        if (Greenfoot.isKeyDown("right")) 
        {
            this.setLocation(this.getX() + 5, this.getY());            
        }
    }
}
