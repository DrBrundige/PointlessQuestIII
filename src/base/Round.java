package base;

import moves.Move;

import java.util.ArrayList;

public class Round {

	protected ArrayList<Move> niceMoves = new ArrayList<Move>();

	public Round() {
		this.niceMoves = null;
	}

	public Round(ArrayList<Move> niceMoves) {
		this.niceMoves = niceMoves;
	}

	public ArrayList<Move> getNiceMoves() {
		return niceMoves;
	}

	public void setNiceMoves(ArrayList<Move> niceMoves) {
		this.niceMoves = niceMoves;
	}

	public void sortSpeeds(){

		System.out.println("BEGIN: SORT SPEEDS");
		this.printMoves();

		ArrayList<Move> temp = new ArrayList<Move>();
		int i = 1;
		int x = 0;
		boolean y = true;

		temp.add(niceMoves.get(0));
		int size = niceMoves.size();

		while(i < niceMoves.size()){

			System.out.println("Reiterating.");
			y = true;

			while(y){

				//System.out.println("I: " + i + " X: " + x);

				try {

					if (niceMoves.get(i).getSpeed() > temp.get(x).getCalcedSpeed()) {

						System.out.println("Adding " + niceMoves.get(i).getCaster() + " to spot " + x);
						temp.add(x, niceMoves.get(i));
						y = false;
					}
					//X has cycled through temp, meaning nicemoves.i should be added to the end
					//The only way to check for this is to let it overflow lol
				} catch (Exception E){
					System.out.println("Adding " + niceMoves.get(i).getCaster() + " to spot " + x);
					temp.add(x, niceMoves.get(i));
					y = false;

				}

				x += 1;
			}

			i += 1;
			x = 0;
		}

		niceMoves = temp;

		System.out.println();
		System.out.println("Sorting Complete! New Order: ");
		this.printMoves();
		//end of sort speeds
	}

	public void fireAll(){

		System.out.println("Round 1: BEGIN");

		for (Move ready : niceMoves) {
			ready.fire();
		}

	}

	public void printMoves()
	{

		int i = 0;

		while(i < niceMoves.size()){

			System.out.println((i+1) + ": " + niceMoves.get(i).getCaster() +
					" using " + niceMoves.get(i).getMoveName() + ". Speed: " + niceMoves.get(i).getCalcedSpeed());

			i += 1;
		}

	}

	//@todo affect cycler: reduces duration of active affects of combatants, removes expired effects
	//reduces duration of active affects of combatants, removes expired effects
	//Warning - this
	//This needs to remade in a new Battle class



}
