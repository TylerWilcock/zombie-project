package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

public class Predator extends Character implements IZombie {
	/**
	 * A predator starts with 80 points of health
	 */
	public Predator() {
		super(80);
	}

	/**
	 * An attack from the predator decrease a survivor's health by 10 points.
	 * @param survivor 
	 */
	@Override
	public void attack(ISurvivor survivor) {
		survivor.decreaseHealth(10);
	}
}
