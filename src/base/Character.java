package base;

// base.Character.Java, from Pointless Quest III
// Copywrite 2018 Thomas Jones
// This slightly important class describes Characters

import java.util.ArrayList;

public class Character {

	// Static character fields
	private int classID;
	private String className;
	private String name;

	// Dynamic fields
	private int level;
	private int exp;
	private int currentHP;
	private int currentSP;
	private int kills;
	private boolean isDead;

	private int team; // range: 0-7

	// Stats
	private int sMaxHP;
	private int sMaxSP;
	private int sHPRegen;
	private int sSPRegen;
	private int sAttack;
	private int sDefense;
	private int sSpeed;

	// Active Effects
	private ArrayList<Affect> characterAffects = new ArrayList<Affect>();


	// ***CONSTRUCTORS***

	// Empty Constructor - sets the class to Berserk, name to nothing and stats to 0
	public Character() {

		this.classID = 0;
		this.className = "";
		this.name = "";

		this.resetCharacter();

	}

	//	Constructor - sets the character's name and class, and level to zero
//	This is used for creating new player characters
//	@param ClassId, numeric value that determines the character's class
//	@param Name, the character's name
	public Character(int ClassID, String Name) {

		this.classID = ClassID;
		this.className = CharacterCreator.getClassNames(ClassID);
		this.name = Name;
		this.team = 0;

		this.resetCharacter();
		this.levelUp();

	}

	// Deprecated constructor that doesn't assign team
	public Character(int ClassID, String Name, int level) {
		this.classID = ClassID;
		this.className = CharacterCreator.getClassNames(ClassID);
		this.name = Name;
		this.isDead = false;
		this.team = 0;

		this.resetCharacter();
		this.hardSetLevel(level);
	}

//		Constructor - sets the character's name, class and level
//	This is used for creating new enemies and having them jump directly to a specified level
//	@param level, hard sets the character's level to that value
	public Character(int ClassID, String Name, int level, int team) {

		this.classID = ClassID;
		this.className = CharacterCreator.getClassNames(ClassID);
		this.name = Name;
		this.isDead = false;
		this.team = team;

		this.resetCharacter();
		this.hardSetLevel(level);

	}

	private void resetCharacter() {

		this.setLevel(0);
		this.setExp(0);
		this.setCurrentHP(10);
		this.setCurrentSP(10);

		this.setsMaxHP(10);
		this.setsMaxSP(10);
		this.setsHPRegen(10);
		this.setsSPRegen(10);
		this.setsAttack(10);
		this.setsDefense(10);
		this.setsSpeed(10);

		this.isDead = false;
		this.kills = 0;

	}

	protected void hardSetLevel(int level) {

		System.out.println("Setting the level of " + this.getName() + " to " + level
				+ ". Level is currently " + this.getLevel());

		if (level < 0) {
			System.out.println("ERROR: int level is less than 0");
			return;
		}

		//System.out.println("Chungus");

		int i = this.getLevel();

		//If i is less than level, it is presumed the intent is to lower character's level
		if (i > level) {
			System.out.println("i is less than level, resetting base.Character");
			this.resetCharacter();
			i = this.getLevel();
		}

		while (i < level) {

			this.levelUp();
			i = this.getLevel();
		}


	}


	// ***INTERFACE***


	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public int getCurrentSP() {
		return currentSP;
	}

	public void setCurrentSP(int currentSP) {
		this.currentSP = currentSP;
	}

	public boolean isDead() {
		return isDead;
	}

	public void hardsetDead(boolean dead) {
		isDead = dead;
	}

	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public void checkDead() {
		if (this.sMaxHP <= 0) {

			this.isDead = true;
		} else {

			this.isDead = false;
		}

	}

	public int getsMaxHP() {
		return sMaxHP;
	}

	public void setsMaxHP(int sMaxHP) {
		this.sMaxHP = sMaxHP;
	}

	public int getsMaxSP() {
		return sMaxSP;
	}

	public void setsMaxSP(int sMaxSP) {
		this.sMaxSP = sMaxSP;
	}

	public int getsHPRegen() {
		return sHPRegen;
	}

	public void setsHPRegen(int sHPRegen) {
		this.sHPRegen = sHPRegen;
	}

	public int getsSPRegen() {
		return sSPRegen;
	}

	public void setsSPRegen(int sSPRegen) {
		this.sSPRegen = sSPRegen;
	}

	public int getsAttack() {
		return sAttack;
	}

	public void setsAttack(int sAttack) {
		this.sAttack = sAttack;
	}

	public int getsDefense() {
		return sDefense;
	}

	public void setsDefense(int sDefense) {
		this.sDefense = sDefense;
	}

	public int getsSpeed() {
		return sSpeed;
	}

	public void setsSpeed(int sSpeed) {
		this.sSpeed = sSpeed;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public ArrayList<Affect> getCharacterAffects() {
		return characterAffects;
	}

	public void setCharacterAffects(ArrayList<Affect> characterAffects) {
		this.characterAffects = characterAffects;
	}

	//Returns an individual affect at index i
	public Affect getAffect(int i) {

		return characterAffects.get(i);
	}

	//Returns characterAffects.size
	public int getNumAffects() {

		return characterAffects.size();
	}

	//Other stuff

	//Prints a detailed stats list
	public void printCharacter() {

		System.out.println();
		System.out.println("CHARACTER DETAILS");
		System.out.println("classID: 	" + this.classID);
		System.out.println("className: 	" + this.className);
		System.out.println("name: 		" + this.name);
		System.out.println("level:		" + this.level);
		System.out.println("experience:	" + this.exp);
		System.out.println("kills:	    " + this.kills);
		System.out.println();
		System.out.println("STATS");
		System.out.println("maxHP:		" + this.sMaxHP);
		System.out.println("maxSP:		" + this.sMaxSP);
		System.out.println("attack:		" + this.sAttack);
		System.out.println("defense:	" + this.sDefense);
		System.out.println("speed:		" + this.sSpeed);
		System.out.println();

	}

	//Condensed version of printCharacter
	public void printStats() {

		System.out.println("name: 		" + this.name);
		System.out.println("maxHP:		" + this.sMaxHP);
		System.out.println("maxSP:		" + this.sMaxSP);
		System.out.println("attack:		" + this.sAttack);
		System.out.println("defense:	" + this.sDefense);
		System.out.println("speed:		" + this.sSpeed);
		System.out.println();

	}

	//Returns the character's name, level and class
	public String toString() {
		String returnString = this.getName();
		returnString += ": Lv. " + this.getLevel() + " " + this.getClassName();

		return returnString;
	}

	//Increments the character's stats
	public void levelUp() {

		//System.out.println("Levelling up " + this.getName() +
		//		" Level is now: " + (this.getLevel() + 1));

		int ID = this.getClassID();

		int[] maxHP = {40, 40, 40, 40, 20, 30, 20, 20, 30, 30, 30, 30};
		int[] maxSP = {20, 30, 30, 30, 30, 30, 40, 40, 50, 40, 40, 40};
		int[] attck = {50, 30, 40, 30, 30, 40, 30, 30, 10, 20, 30, 30};
		int[] def = {20, 50, 20, 40, 20, 20, 20, 20, 20, 20, 30, 30};
		int[] speed = {20, 10, 30, 20, 50, 40, 40, 40, 30, 20, 30, 30};

		int x = this.getLevel() + 1;
		this.setLevel(x);

		//x = person.getExp() - 100;
		//person.setExp(x);

		x = this.getsMaxHP() + (maxHP[ID] * 2);
		this.setsMaxHP(x);

		x = this.getsMaxSP() + maxSP[ID];
		this.setsMaxSP(x);

		x = this.getsAttack() + attck[ID];
		this.setsAttack(x);

		x = this.getsDefense() + def[ID];
		this.setsDefense(x);

		x = this.getsSpeed() + speed[ID];
		this.setsSpeed(x);

	}

	//Returns character's health and stamina to maximum
	public void fullRestore() {

		this.setCurrentHP(this.getsMaxHP());
		this.setCurrentSP(this.getsMaxSP());

	}

	//Affect Stuff

	//Adds a new affect to character
	public void addAffect(int duration, int stat, int intensity) {

		Affect newAffect = new Affect(duration, stat, intensity, this);
		characterAffects.add(newAffect);
	}

	//Calculates the total affect all buffs and debuffs have on a given stat
	public int calcBuff(int stat) {

		//Closes out loop early if characterAffects is empty
		if (characterAffects.isEmpty()) {

			//System.out.println("base.Character has no active affects!");
			return 0;
		}

		int buff = 0;

		//For loop cycles through the contents of characterAffects
		for (int x = 0; x < characterAffects.size(); x++) {
			if (characterAffects.get(x).getStat() == stat) {

				buff += characterAffects.get(x).getIntensity();

			}
		}

		return buff;
	}

	//Deincrements all transient affects, removes expired affects
	public void deincrementAffects() {

		for (int x = 0; x < characterAffects.size(); x++) {
			characterAffects.get(x).tickDown();

			//If remove is true, removes the affect from the ArrayList
			if (characterAffects.get(x).getRemove()) {

				System.out.println("Removing affect for: " + this.name);
				characterAffects.remove(x);
			}
		}
	}

	//Clears character of all normal affects
	public void clearAffects() {

		for (int x = 0; x < characterAffects.size(); x++) {

			//If duration is >= -1, removes the affect from the ArrayList
			if (characterAffects.get(x).getDuration() >= -1) {
				characterAffects.remove(x);
			}
		}

	}


}
