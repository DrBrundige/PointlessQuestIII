package base;

//base.Affect.Java, from Pointless Quest III
//Copywrite 2018 Thomas Jones
//This class describes affects added to characters in battle

public class Affect {

	private int duration; 	//Number of turns the affect has remaining.
	// Affects with -1 duration are permanent, but can be removed externally,
	// Affects with -2 duration are granted by abilities or enchantments, and cannot be removed in battle


	private Character user; //base.Character with this affect

	private int stat;		//Numerical representation of stat effected
	private int intensity;	//Amount raised or lowered
	private Boolean remove;

	//STAT:
	// 00 - Attack
	// 01 - Defense
	// 02 - Speed
	// 03 - MaxHP
	// 04 - MaxSP
	// 05 - HPRegen
	// 06 - SPRegen
	// 11 - Fire resistance
	// 12 - Light resistance
	// 13 - Dark resistance


	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Character getUser() {
		return user;
	}

	public void setUser(Character user) {
		this.user = user;
	}

	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

	public int getIntensity() {
		return intensity;
	}

	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}

	public boolean getRemove() {
		return remove;
	}

	public void setRemove(boolean remove) {
		this.remove = remove;
	}

	// *** Constructors ***
	public Affect(int duration, int stat, int intensity, Character user) {
		this.duration = duration;
		this.user = user;
		this.stat = stat;
		this.intensity = intensity;
		this.remove = false;
	}

	//De-increments this instance's duration
	//Can be overridden for more advanced affects
	public void tickDown(){

		//Ticks down duration if it is greater than zero
		if(this.duration > 0){

			this.duration -= 1;
		}

		//Marks affect for removal if its duration is zero
		if(this.duration == 0){

			this.remove = true;
			this.intensity = 0;
		}

	}

}
