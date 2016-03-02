package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

public class ZombieDog extends Character implements IZombie {
	/**
	 * A zombie dog starts with 40 points of health
	 */
	public ZombieDog() {
		super(20);
	}

	/**
	 * An attack from the zombie dog decrease a survivor's health by 10 points.
	 * @param survivor 
	 */
	@Override
	public void attack(ISurvivor survivor) {
		survivor.decreaseHealth(30);
	}
	
	public String zombieType(){
		return "Zombie Dog";
	}
}

