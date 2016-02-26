
package zombiewar.impl;

import zombiewar.intf.ICharacter;
import zombiewar.intf.ICharacterFactory;
/**
 *
 * @author thaoc
 */
public class CharacterFactory implements ICharacterFactory{
  
	/* Zombie's */
	public static final String TANK = "TANK";
	public static final String PREDATOR = "PREDATOR";
	public static final String COMMON = "COMMON";
	
	/* Survivors */
	public static final String SOLDIER = "SOLDIER";
	public static final String TEACHER = "TEACHER";
	public static final String CHILD = "CHILD";
	public static final String INVESTIGATOR = "INVESTIGATOR";
	
  public static final ICharacterFactory instance = new CharacterFactory();
  
  private CharacterFactory(){
   
  }

  /**
   * Make the character.  To support more characters,
   * simply implement a type and then add a case statement
   * to this method.
   * 
   * @param type The type of character to make.
   * @return 
   */
  
  @Override
  public ICharacter make(String type) {
    switch(type){
      case TANK     : return new Tank();
      case PREDATOR : return new Predator();
      case COMMON   : return new CommonInfected();
      case SOLDIER  : return new Soldier();
      case TEACHER  : return new Teacher();
      case CHILD    : return new Child();
      case INVESTIGATOR : return new Investigator();
    }
    return null;
  }
  
}
