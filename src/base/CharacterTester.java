package base;

public class CharacterTester {

	public static void main(String args[]) {

		classTester();

	}

	//A basic test of common character methods
	public static void basicTest() {

		Character person = new Character(1, "Lady Vanessa");

		person.printCharacter();

		person.levelUp();

		System.out.println();

		person.printCharacter();

		System.out.println();

		person.hardSetLevel(9);
		person.printCharacter();

		person.hardSetLevel(3);
		person.printCharacter();
		System.out.println(person.toString());

	}

	//A test to ensure each class is assigned the correct stats
	public static void classTester() {

		Character Berserk = new Character(0, "Berserk", 9);

		///*
		Character Paladin = new Character(1, "Paladin", 9);
		Character Battlemage = new Character(2, "Battlemage", 9);
		Character Vanguard = new Character(3, "Vanguard", 9);
		Character Assassin = new Character(4, "Assassin", 9);
		Character BladeMaster = new Character(5, "BladeMaster", 9);
		Character NightMage = new Character(6, "NightMage", 9);
		Character Spellsword = new Character(7, "Spellsword", 9);
		Character Cleric = new Character(8, "Cleric", 9);
		Character Druid = new Character(9, "Druid", 9);
		Character Necromancer = new Character(10, "Necromancer", 9);
		Character Pyromancer = new Character(11, "Pyromancer", 9);
		//*/

		System.out.println("");

//		/*
		Berserk.printStats();
		Paladin.printStats();
		Battlemage.printStats();
		Vanguard.printStats();
		Assassin.printStats();
		BladeMaster.printStats();
		NightMage.printStats();
		Spellsword.printStats();
		Cleric.printStats();
		Druid.printStats();
		Necromancer.printStats();
		Pyromancer.printStats();
//		*/

	}

}
