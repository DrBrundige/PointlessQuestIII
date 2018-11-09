package base;

import moves.Move;

import java.util.ArrayList;

public class Round {

	// Class Round: represents a single round of combat
	// Receives moves performed by characters, sorts them by speed, and fires in sequence

	// an ArrayList of Moves. These will be fired in sequence
	protected ArrayList<Move> niceMoves = new ArrayList<Move>();
	private int roundNo; // The round number, displays at start of round.

	// Basic constructor
	public Round() {
		this.niceMoves = null;
		this.roundNo = 1;
	}

	// Deprecated constructor. Receives niceMoves but defaults roundNo to 1
	public Round(ArrayList<Move> niceMoves) {
		this.niceMoves = niceMoves;
		this.roundNo = 1;
	}

	// Constructor, receives niceMoves and round number
	public Round(ArrayList<Move> niceMoves, int roundNo) {
		this.niceMoves = niceMoves;
		this.roundNo = roundNo;
	}

	// Constructor, creates empty niceMoves. Using this method, moves will be added individually
	public Round(int roundNo) {
		this.niceMoves = new ArrayList<Move>();
		this.roundNo = roundNo;
	}

	// Getters and setters for niceMoves
	public ArrayList<Move> getNiceMoves() {
		return niceMoves;
	}

	public void setNiceMoves(ArrayList<Move> niceMoves) {
		this.niceMoves = niceMoves;
	}

	public void addMove(Move move){
		niceMoves.add(move);
	}

	// Creates new ArrayList temp, adds moves from niceMoves to it ordered by caster's speed
	//  reassigns temp to niceMoves
	// Called by Battle, returns nothing, recieves nothing
	public void sortSpeeds() {

//		System.out.println("BEGIN: SORT SPEEDS");
		this.printMoves();

		ArrayList<Move> temp = new ArrayList<Move>();
		int i = 1;
		int x = 0;
		boolean y = true;

		temp.add(niceMoves.get(0));
		int size = niceMoves.size();

		while (i < niceMoves.size()) {

//			System.out.println("Reiterating.");
			y = true;

			while (y) {

				//System.out.println("I: " + i + " X: " + x);

				try {

					if (niceMoves.get(i).getSpeed() > temp.get(x).getCalcedSpeed()) {

//						System.out.println("Adding " + niceMoves.get(i).getCaster() + " to spot " + x);
						temp.add(x, niceMoves.get(i));
						y = false;
					}
					//X has cycled through temp, meaning nicemoves.i should be added to the end
					//The only way to check for this is to let it overflow lol
				} catch (Exception E) {
//					System.out.println("Adding " + niceMoves.get(i).getCaster() + " to spot " + x);
					temp.add(x, niceMoves.get(i));
					y = false;

				}

				x += 1;
			}

			i += 1;
			x = 0;
		}

		niceMoves = temp;

//		System.out.println();
//		System.out.println("Sorting Complete! New Order: ");
//		this.printMoves();
		//end of sort speeds
	}

	// Begins the round by calling fire() on all moves in niceMoves
	// Called by Battle, returns nothing, recieves nothing
	public void fireAll() {

		System.out.println("Round " + roundNo + ": BEGIN!");

		for (Move ready : niceMoves) {
			ready.fire();
		}

	}

	//
	public void printMoves() {

		int i = 0;

		for (Move move : niceMoves) {
			move.print();
		}

	}

	// @todo affect cycler: reduces duration of active affects of combatants,
	// removes expired effects
	// reduces duration of active affects of combatants, removes expired effects
	// This needs to remade in a new Battle class


}
