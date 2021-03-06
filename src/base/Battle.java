package base;

import moves.Move;

import java.util.ArrayList;

// base.Character.Java, from Pointless Quest III
// Copyright 2018 T. Brundige Jones
// This class describes an encounter between two or more opposing characters

public class Battle {

	private ArrayList<Character> combatants = new ArrayList<Character>();
	private boolean keepFighting;
	private int noTeams;

	// Empty constructor
	public Battle() {
		this.combatants = null;
		keepFighting = true;
		noTeams = 0;
	}

	// Constructor. Receives an array list of combatants
	public Battle(ArrayList<Character> combatants, int noTeams) {
		this.combatants = combatants;
		keepFighting = true;
		this.noTeams = noTeams;
	}

	// Getters and setters

	public ArrayList<Character> getCombatants() {
		return combatants;
	}

	public void setCombatants(ArrayList<Character> combatants) {
		this.combatants = combatants;
	}

	public void fight() {

		int rnds = 1;

//		While keepFighting is true
		while(keepFighting){

			Round newRound = new Round(rnds);

			addPlayerMoves(newRound);

			newRound.sortSpeeds();
			newRound.fireAll();

			rnds += 1;
			if(rnds > 16) break;

			keepFighting = shouldKeepFighting();
		}
//
//		Create new round
//		Add player moves
//      Add AI moves
//
//		round1.sortSpeeds();
//		round1.fireAll();

//		check to see if all combatants are dead

	}

	// Test method. Plans for interface to draw players moves. For now, adds basic attacks
	public void addPlayerMoves(Round niceRound){

		Move move1 = new Move(combatants.get(0), combatants.get(1), 0);
		niceRound.addMove(move1);
		move1 = new Move(combatants.get(1), combatants.get(0), 0);
		niceRound.addMove(move1);

	}

	private boolean shouldKeepFighting() {

		// creates an int[] where each element represents one team
		int[] teams = new int[noTeams];
		int aliveTeams = 0; // number of teams with active characters

		// Assigns all elements in teams to 0
		for (int team : teams) {
			team = 0;
		}

		// cycles through combatants. If combatant is alive, increment int[team]
		for (Character c : combatants) {

			if (c.isDead() == false) {
				teams[c.getTeam()] += 1;
			}

		}

		// cycles through int[]. If number of teams with characters alive is greater than 1
		//  the battle continues

		for (int team : teams) {
			if (team > 0) aliveTeams += 1;
		}

		if (aliveTeams > 1) {
			return true;
		} else {
			return false;
		}
	}

}
