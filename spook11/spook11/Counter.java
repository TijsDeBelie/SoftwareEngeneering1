import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Ruebn: Importeer de mogelijkheid om kleur toe te voegen
 */
import java.awt.Color;

/**
 *De Class Counter
 */
public class Counter extends Actor
{
    /**
     * Ruben: Declareer een variabele die de counter op 0 zet bij de start, binnen de eigen Klasse
     */
    int score = 0;
    private int lastScore = -1;
    
    /**
       * Ruben: Stel de afbeelding in, vervang de afbeelding door, tekst, variabelen, en geef deze een grootte,
       * fontkleur en achtergrondkleur mee
       */
  public void act()
  {
      if (lastScore != score) {
          setImage(new GreenfootImage("Score : " + score, 24, Color.GREEN, Color.BLACK));
          lastScore = score;
        }
     
      
  }   
  public void addScore()
  {
      /**
       * Ruben: Verhoog de score met 1 elke keer deze methode wordt aangeroepen
       */
      score++;
    }
}
 

