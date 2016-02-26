package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

public class Investigator extends Character implements ISurvivor {
	/**
	 * An investigator starts with 60 points of health
	 */
	public Investigator() {
		super(60);
	}

	@Override
	public void attack(IZombie zombie) {
		zombie.decreaseHealth(10);
	}
	
	public String survivorType(){
		return "Investigator";
	}
}