package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

public class CommonInfected extends Character implements IZombie {
	/**
	 * A common infected zombie starts with 30 points of health
	 */
	public CommonInfected() {
		super(30);
	}

	/**
	 * An attack from a common infected zombie decrease a survivor's health by 5 points.
	 * @param survivor 
	 */
	@Override
	public void attack(ISurvivor survivor) {
		survivor.decreaseHealth(5);
	}
}
