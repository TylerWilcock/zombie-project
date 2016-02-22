
package zombiewar.impl;

import zombiewar.intf.ICharacter;
import zombiewar.intf.ICharacterFactory;
/**
 *
 * @author thaoc
 */
public class CharacterFactory implements ICharacterFactory{
  
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
      case "tank"     : 	  return new Tank();
      case "predator" :       return new Predator();
      case "commonInfected" : return new CommonInfected();
      case "soldier"  : 	  return new Soldier();
      case "student"  : 	  return new Teacher();
      case "child"    : 	  return new Child();
    }
    return null;
  }
  
}
