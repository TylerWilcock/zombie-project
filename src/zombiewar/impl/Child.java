package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

public class Child extends Character implements ISurvivor {
	/**
	 * A soldier starts with 100 points of health
	 */
	public Child() {
		super(100);
	}

	@Override
	public void attack(IZombie zombie) {
		zombie.decreaseHealth(10);
	}
}
