package moves;

import base.Character;

public class MoveBladeDance extends Move {

	public MoveBladeDance(Character caster, Character target, int round) {
		this.caster = caster;
		this.target = target;
		this.moveName = "Blade Dance";
		this.speed 	= caster.getsSpeed();
		this.round 	= round;
	}

	@Override
	public void fire() {

		int damage = calcDamage();
		double speedRatio = caster.getsSpeed() / target.getsSpeed();

		System.out.println(caster.getName() + " a lets loose a flurry of sword strikes at " + target.getName());

		if(speedRatio < 2){

			System.out.println(caster.getName() + " Attacks once for " + damage + " damage!");
		}else if (speedRatio >= 2 && speedRatio < 3) {

			damage *= 2;
			System.out.println(caster.getName() + " Attacks twice for " + damage + " damage!");
		}else if(speedRatio >= 3){

			damage *= 3;
			System.out.println(caster.getName() + " Attacks three times for " + damage + " damage!");
		}

		int remaining = target.getCurrentHP() - damage;
		target.setCurrentHP(remaining);

		printHealthRemaining();

	}

	@Override
	public String toString() {
		String coolString = caster.getName() + " a lets loose a flurry of sword strikes at " + target.getName();
		coolString += "Attacks a number of times based on ratios of caster and target's SPEED \nSPEED: " + caster.getsSpeed();
		coolString += "Costs 40 STAMINA";

		return coolString;
	}

}
