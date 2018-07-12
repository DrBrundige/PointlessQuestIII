package moves;

import base.Character;

public class MoveFireball extends Move {

	public MoveFireball(Character caster, Character target, int round) {
		this.caster = caster;
		this.target = target;
		this.moveName = "Fireball";
		this.speed 	= caster.getsSpeed();
		this.round 	= round;
	}

	@Override
	public void fire() {

		int damage = 15 * caster.getLevel();

		int remaining = target.getCurrentHP() - damage;
		target.setCurrentHP(remaining);

		System.out.println();
		System.out.println(caster.getName() + " throws a fireball at " + target.getName() + " for " + damage + " damage!");

		printHealthRemaining();

	}

	@Override
	public String toString() {
		String coolString = caster.getName() + " throws a fireball at " + target.getName();
		coolString += "Deals damage based caster's LEVEL times 15\nLEVEL: " + caster.getLevel();
		coolString += "Costs 20 STAMINA";

		return coolString;
	}
}
