package moves;

import base.Character;

//Moves.MoveAxeThrow, from Pointless Quest III
//Copywrite 2017 Thomas Jones
//This class describes a thrown weapon move
//This is a dynamic move - the flavor text changing based on the caster's classid,
// but the guts remain the same

public class MoveAxeThrow extends Move{

	private String weapon;

	//Default constructor the use of which I cannot imagine.
	public MoveAxeThrow() {
		this.caster = null;
		this.target = null;
		this.moveName = "";
		this.weapon   = "";
		this.speed = 0;
		this.round = 0;
	}

	public MoveAxeThrow(Character caster, Character target, int round) {
		this.caster = caster;
		this.target = target;

		switch (this.caster.getClassID()){

			case 0:
			case 1:
			case 2:
			case 3:

				this.weapon = "throwing axe";
				this.moveName = "Axe Throw";
				break;

			case 4:
			case 5:
			case 6:
			case 7:

				this.weapon = "throwing knife";
				this.moveName = "Knife Throw";
				break;

			case 8:
			case 9:
			case 10:
			case 11:

				this.weapon = "stick";
				this.moveName = "stick throw";
				break;

			default:

				this.weapon = "rock";
				this.moveName = "Rock Throw";

				break;
		}

		this.speed 	= caster.getsSpeed() + 1000; //Increases move speed by 1000
		this.round 	= round;
	}

	public String toString(){

		String coolString = caster.getName() + " uses basic attack on " + target.getName();
		coolString += "\nAttacks first";
		coolString += "\nAttack: " + caster.getsAttack();
		coolString += "\nDefense " + target.getsDefense();

		return coolString;
	}

	//Performs the move
	public void fire(){

		int damage = calcDamage();

		int remaining = target.getCurrentHP() - damage;
		target.setCurrentHP(remaining);

		System.out.println();
		System.out.println(caster.getName() + " hits " + target.getName() + " with a " + this.weapon +" for " + damage + " damage!");

		printHealthRemaining();

	}


}
