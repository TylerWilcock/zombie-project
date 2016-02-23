package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

public class Child extends Character implements ISurvivor {
	/**
	 * A child starts with 20 points of health
	 */
	public Child() {
		super(20);
	}

	@Override
	public void attack(IZombie zombie) {
		zombie.decreaseHealth(2);
	}
	
	public String survivorType(){
		return "Child";
	}
}
