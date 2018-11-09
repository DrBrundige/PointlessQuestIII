package base;

import moves.Move;

public class AffectTester {

	public static void main(String args[]) {

		//testBasicAffects();
		testDeincrement();

	}

	public static void testBasicAffects() {

		Character Jormund = new Character(3, "Jormund", 9);
		Character Joanna = new Character(1, "Joanna", 9);

		Jormund.fullRestore();
		Joanna.fullRestore();

		Move newMove = new Move(Jormund, Joanna, 0);

		System.out.println();
		newMove.fire();

		//Adds a defensive buff to Joanna
		Joanna.addAffect(3, 1, (10 * Joanna.getLevel()));

		System.out.println("Defensive buff: " + Joanna.calcBuff(1));

		System.out.println("\nFiring, this time with defensive buff\n");
		newMove.fire();

		Jormund.addAffect(3, 0, (-10 * Jormund.getLevel()));

		System.out.println("Attack debuff: " + Jormund.calcBuff(0));

		System.out.println("\nFiring, this time with attack debuff\n");
		newMove.fire();

	}

	public static void testDeincrement() {

		Character Vanguard = new Character(3, "Xentsin Mao", 9);
		Character Necromancer = new Character(10, "Xoktugol", 9);

		Vanguard.fullRestore();
		Necromancer.fullRestore();

		Move newMove = new Move(Vanguard, Necromancer, 0);

		System.out.println();
		newMove.fire();

		//Adds a defensive buff to Necromancer
		Necromancer.addAffect(1, 1, (20 * Necromancer.getLevel()));
		Vanguard.addAffect(-1, 0, (10 * Vanguard.getLevel()));

		System.out.println("Defensive buff: " + Necromancer.calcBuff(1));
		System.out.println("Attack buff: " + Vanguard.calcBuff(0));

		Necromancer.deincrementAffects();
		Vanguard.deincrementAffects();

		System.out.println("Deincrementing");
		System.out.println("Defensive buff: " + Necromancer.calcBuff(1));
		System.out.println("Attack buff: " + Vanguard.calcBuff(0));

	}

}
