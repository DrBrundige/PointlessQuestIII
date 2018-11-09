package base;

// Tests the Battle class

import java.util.ArrayList;

public class BattleTester {

	public static void main(String args[])
	{
		System.out.println("Test of the battle system.");

		ArrayList<Character> Characters = new ArrayList<Character>();

		Character Berserk = new Character(0, "Berserk", 9, 0);
		Character Vanguard = new Character(3, "Vanguard", 9, 1);

		Berserk.fullRestore();
		Vanguard.fullRestore();

		Characters.add(Berserk);
		Characters.add(Vanguard);

		Battle niceBattle = new Battle(Characters, 2);

		niceBattle.fight();

	}

}
