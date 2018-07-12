package base;

import moves.Move;
import moves.MoveAxeThrow;
import moves.MoveBladeDance;
import moves.MoveFireball;

import java.util.ArrayList;

public class RoundTester {

	public static void main(String args[])
	{

		//testRoundConstructor();
		//testRoundSorter();
		testRoundSorterAffects();

	}

	public static void testRoundConstructor(){

		Character Vanguard 	= new Character(3, "Wei", 3);
		Character Pyromancer= new Character(11, "Lady Vanessa", 3);

		Vanguard.fullRestore();
		Pyromancer.fullRestore();

		Vanguard.printCharacter();
		Pyromancer.printCharacter();

		Move move1 = new Move(Vanguard,Pyromancer,0);
		Move move2 = new MoveFireball(Pyromancer,Vanguard,0);

		ArrayList<Move> niceMoves = new ArrayList<Move>();
		niceMoves.add(move1);
		niceMoves.add(move2);

		Round round1 = new Round(niceMoves);

		round1.printMoves();

	}

	public static void testRoundSorter(){

		Character Vanguard 	= new Character(3, "Wei", 3);
		Character Pyromancer= new Character(11, "Lady Vanessa", 3);
		Character Berserk 	= new Character(0, "Jormund", 3);
		Character Assassin	= new Character(4, "Julius", 3);


		Vanguard.fullRestore();
		Pyromancer.fullRestore();
		Berserk.fullRestore();
		Assassin.fullRestore();


		Move move1 = new Move(Vanguard,Berserk,0);
		Move move2 = new MoveFireball(Pyromancer,Berserk,0);
		Move move3 = new MoveAxeThrow(Berserk,Vanguard,0);
		Move move4 = new MoveBladeDance(Assassin,Pyromancer,0);

		ArrayList<Move> niceMoves = new ArrayList<Move>();
		niceMoves.add(move1);
		niceMoves.add(move2);
		niceMoves.add(move3);
		niceMoves.add(move4);

		System.out.println();

		Round round1 = new Round(niceMoves);

		round1.sortSpeeds();
		round1.fireAll();

	}

	public static void testRoundSorterAffects(){

		Character Vanguard 	= new Character(3, "Wei", 3);
		Character Pyromancer= new Character(11, "Lady Vanessa", 3);
		Character Berserk 	= new Character(0, "Jormund", 3);
		Character Assassin	= new Character(4, "Julius", 3);


		Vanguard.fullRestore();
		Pyromancer.fullRestore();
		Berserk.fullRestore();
		Assassin.fullRestore();


		Move move1 = new Move(Vanguard,Berserk,0);
		Move move2 = new Move(Pyromancer,Berserk,0);
		Move move3 = new Move(Berserk,Vanguard,0);
		Move move4 = new Move(Assassin,Pyromancer,0);

		ArrayList<Move> niceMoves = new ArrayList<Move>();
		niceMoves.add(move1);
		niceMoves.add(move2);
		niceMoves.add(move3);
		niceMoves.add(move4);

		System.out.println();

		Round round1 = new Round(niceMoves);

		//round1.sortSpeeds();
		//round1.fireAll();

		System.out.println("\n Sorting speeds again, now with speed changes");

		Vanguard.addAffect(3,2,30);
		Pyromancer.addAffect(3,2,-20);
		round1.sortSpeeds();

	}


}
