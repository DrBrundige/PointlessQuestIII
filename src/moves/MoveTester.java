package moves;

import base.Character;

public class MoveTester {

	public static void main(String args[])
	{

		//testBasicAttack();
		//testFireball();
		//testBladeDance();
		testDynamicMoves();

	}

	public static void testBasicAttack(){

		base.Character Vanguard 	= new Character(3, "Wei", 9);
		Character Berserk 	= new Character(0, "Jormund", 9);

		Vanguard.fullRestore();
		Berserk.fullRestore();

		Vanguard.printCharacter();
		Berserk.printCharacter();

		Move move1 = new Move(Vanguard,Berserk,0);
		Move move2 = new Move(Berserk,Vanguard,0);

		//System.out.println(move1.toString());

		move1.fire();
		move1.fire();
		move1.fire();

		move2.fire();
		move2.fire();
		move2.fire();


	}

	public static void testFireball(){

		Character Vanguard 	= new Character(3, "Wei", 9);
		Character Pyromancer 	= new Character(11, "Lady Vanessa", 9);

		Vanguard.fullRestore();
		Pyromancer.fullRestore();

		Vanguard.printCharacter();
		Pyromancer.printCharacter();

		Move move1 = new Move(Vanguard,Pyromancer,0);
		Move move2 = new MoveFireball(Pyromancer,Vanguard,0);

		move1.fire();
		move1.fire();
		move1.fire();

		move2.fire();
		move2.fire();
		move2.fire();
	}

	public static void testBladeDance(){

		Character Assassin	= new Character(4, "Assassin", 9);
		Character Berserk 	= new Character(0, "Berserk", 9);
		Character Paladin	= new Character(1, "Paladin", 9);

		Assassin.fullRestore();
		Berserk.fullRestore();
		Paladin.fullRestore();

		Move bladeDance1 = new MoveBladeDance(Assassin,Berserk,0);
		Move bladeDance2 = new MoveBladeDance(Assassin,Paladin,0);

		///*
		System.out.println();
		bladeDance1.fire();
		System.out.println();
		bladeDance2.fire();
		//*/


	}

	public static void testDynamicMoves(){

		Character Assassin	= new Character(4, "Assassin", 9);
		Character Berserk 	= new Character(0, "Berserk", 9);

		Assassin.fullRestore();
		Berserk.fullRestore();

		Move knifeThrow = new MoveAxeThrow(Assassin,Berserk,0);
		Move axeThrow = new MoveAxeThrow(Berserk,Assassin,0);

		///*
		System.out.println();
		knifeThrow.fire();
		System.out.println();
		axeThrow.fire();
		//*/



	}

}
