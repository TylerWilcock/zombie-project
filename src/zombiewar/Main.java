package zombiewar;

import zombiewar.impl.CharacterFactory;
import zombiewar.intf.ICharacter;
import zombiewar.intf.ICharacterFactory;
import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 *
 * @author thaoc
 */

public class Main {
  
  private static final ICharacterFactory factory = CharacterFactory.instance;
  
  static int commonCount = 0;
  static int tankCount = 0;
  static int predatorCount = 0;
  static int soldierCount = 0;
  static int teacherCount = 0;
  static int childCount = 0;
  static int investigatorCount = 0;
  
  public static IZombie[] randomZombies() {
    int numZombies = (int) (Math.random() * 10);
    IZombie[] zombies = new IZombie[numZombies];
    for (int i = 0; i < zombies.length; i++) {
      int zombieType = (int) (Math.random() * 3);
      switch(zombieType){
        case 0: zombies[i] = (IZombie) factory.make(CharacterFactory.COMMON); commonCount++; break;
        case 1: zombies[i] = (IZombie) factory.make(CharacterFactory.TANK); tankCount++; break;
        case 2: zombies[i] = (IZombie) factory.make(CharacterFactory.PREDATOR); predatorCount++; break;
      }
    }
    return zombies;
  }

  public static ISurvivor[] randomSurvivors() {
    int numSurvivors = (int) (Math.random() * 20);
    ISurvivor[] survivors = new ISurvivor[numSurvivors];
    for (int i = 0; i < survivors.length; i++) {
      int type = (int) (Math.random() * 3);
      switch(type){
        case 0: survivors[i] = (ISurvivor) factory.make(CharacterFactory.SOLDIER); soldierCount++; break;
        case 1: survivors[i] = (ISurvivor) factory.make(CharacterFactory.TEACHER); teacherCount++; break;
        case 2: survivors[i] = (ISurvivor) factory.make(CharacterFactory.CHILD); childCount++; break;
	case 3: survivors[i] = (ISurvivor) factory.make(CharacterFactory.INVESTIGATOR); investigatorCount++; break;
      }
    }
    return survivors;
  }

  public static boolean allDead(ICharacter[] characters){
    boolean allDead = true;
    for(int i=0; i<characters.length; i++){
      allDead &= !characters[i].isAlive();
    }
    return allDead;
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    IZombie[] zombies = randomZombies();
    ISurvivor[] survivors = randomSurvivors();

    System.out.println("We have " + survivors.length + " survivors trying to make it to safety (" +childCount + " children, " + teacherCount + " teachers, " + investigatorCount + " investigators, " + soldierCount + " soldiers).");
    System.out.println("But there are " + zombies.length + " zombies waiting for them (" +commonCount + " common infected, " + predatorCount + " predators, " + tankCount + " tanks).\n");
    
    while(!allDead(zombies) && !allDead(survivors)) {
    	for(int i = 0; i < survivors.length; i++) {
    		if(survivors[i].isAlive()) {
    			for(int j = 0; j < zombies.length; j++) {
    				if(zombies[j].isAlive()) {
    					survivors[i].attack(zombies[j]);
    					if(!zombies[j].isAlive()){ //survivor has killed the zombie
    						String zombieType = zombies[j].zombieType();
    						String survivorType = survivors[i].survivorType();
    						System.out.println(survivorType + " killed " + zombieType);
    					}
    				}
    			}
    		}
    	}
    	
    	for(int i = 0; i < zombies.length; i++) {
    		if(zombies[i].isAlive()) {
    			for(int j = 0; j < survivors.length; j++) {
    				if(survivors[j].isAlive()) {
    					zombies[i].attack(survivors[j]);
    					if(!survivors[j].isAlive()){ //zombie has killed the survivor
    						String survivorType = survivors[j].survivorType();
    						String zombieType = zombies[i].zombieType();
    						System.out.println(zombieType + " killed " + survivorType);
    					}
    				}
    			}
    		}
    	}
    }
    
    
    //TODO: the survivors attack first.  One characte attack each zombie.
    //      When all the survivors have done attacking, it's the zombies' 
    //      turn to attack.  For each zombie that is still alive, attack
    //      each suvivor that is still alive.  Repeat this cycle until
    //      all the zombies are all dead or all the survivors are all dead.
    

    

    if (allDead(survivors)) {
      System.out.println("\nNone of the survivors made it.");
    } else {
      int count = 0;
      for(int i=0; i<survivors.length; i++) {
        if (survivors[i].isAlive()) count++;
      }
      System.out.println("\nIt seems " + count + " have made it to safety.");
    }
  }

}
