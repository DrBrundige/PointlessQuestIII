package moves;

import base.Character;

//Move.Java, from Pointless Quest III
//Copywrite 2017 Thomas Jones
//This class describes the basic attack move. All other moves extend this class

public class Move {

	//Caster - the base.Character who uses this move
	//Target - the base.Character on which this move is used
	//Speed	 - the speed of the Caster, used to define the order
	//base.Round  - the round in which this iteration of the move was used
	protected Character caster;
	protected Character target;
	protected String 	moveName;
	protected int 		speed;
	protected int 		round;


	//Default constructor the use of which I cannot imagine.
	public Move() {
		this.caster = null;
		this.target = null;
		this.moveName = "";
		this.speed = 0;
		this.round = 0;
	}

	public Move(Character caster, Character target, int round) {
		this.caster = caster;
		this.target = target;
		this.moveName = "Basic Attack";
		this.speed 	= caster.getsSpeed();
		this.round 	= round;
	}

	public Character getCaster() {
		return caster;
	}

	public void setCaster(Character caster) {
		this.caster = caster;
	}

	public Character getTarget() {
		return target;
	}

	public void setTarget(Character target) {
		this.target = target;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getMoveName() {
		return moveName;
	}

	public void setMoveName(String moveName) {
		this.moveName = moveName;
	}

	public int getCalcedSpeed(){

		int newSpeed = speed + caster.calcBuff(2);

		return newSpeed;
	}



	public String toString(){

		String coolString = caster.getName() + " uses basic attack on " + target.getName();
		coolString += "\nAttack: " + caster.getsAttack();
		coolString += "\nDefense " + target.getsDefense();

		return coolString;
	}

	//Fires the move. This is overriden by other moves
	public void fire(){

		//Calculates damage dealt
		int damage = calcDamage();

		int remaining = target.getCurrentHP() - damage;
		target.setCurrentHP(remaining);

		System.out.println();
		System.out.println(caster.getName() + " hits " +
				target.getName() + " for " + damage + " damage!");

		printHealthRemaining();

	}

	//Calculates damage of the move. I may need to change en masse later
	protected int calcDamage(){

		//Damage is calculated by cutting targets defense in half, then subtracting it from user's attack
		//The damage is then cut in half again.

		int attack = caster.getsAttack() + caster.calcBuff(0);
		int defense = target.getsDefense() + target.calcBuff(1);
		int damage = attack - (defense/2);

		damage = damage / 2;
		damage = damage - (damage % 5);		// Rounds damage down to nearest multiple of five
		damage = (damage > 10) ? damage : 10; // Sets damage to ten, if it is less than ten

		/*
		System.out.println("Attack: " + attack);
		System.out.println("Defense: " + defense);
		System.out.println("Damage: " + damage);
		//*/

		return damage;
	}

	//Prints target health remaining to finish out move
	protected void printHealthRemaining(){

		if(target.getCurrentHP() <= 0){

			target.setCurrentHP(0);

			System.out.println(target.getName() + " now has ZERO health remaining.");
			System.out.println(target.getName() + " is dead as shit, bro!");

			//Increments caster's kill count appropriately
			caster.setKills((caster.getKills() + 1));
		}else{

			System.out.println(target.getName() + " now has " +
					target.getCurrentHP() + " health remaining.");
		}

	}

}
