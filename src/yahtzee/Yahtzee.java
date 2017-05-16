package yahtzee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Yahtzee {
	private final int rounds = 1;
	private final int turns = 3;
	private final int amountDices = 5;
	public final static int FULLHOUSE = 25;
	public final static int SMALLSTRAIGHT = 30;
	public final static int LARGESTRAIGHT = 40;
	public final static int YAHTZEE = 50;

	public Yahtzee() {

	}

	/*
	 * Drie gelijke: De score is het totaal van alle ogen, 
	 * als er minstens 3 dobbelstenen met hetzelfde aantal ogen zijn.
	 * 
	 * Vier gelijke: De score is het totaal van alle ogen, 
	 * als er minstens 4 dobbelstenen met hetzelfde aantal ogen zijn.
	 * 
	 * Yahtzee: 50 punten als alle dobbelstenen hetzelfde aantal ogen hebben.
	 */

	/*
	 * Full House: 25 punten voor 3 gelijke en één paar. (5 gelijke telt niet
	 * als Full House, tenzij het vak Yahtzee reeds ingevuld is).
	 */
	public boolean isFullHouse(Dice[] dice) {
		
		if(isSameDices(dice, 3) && isSameDices(dice, 2)){
			return true;
		}
		
		return false;
	}

	/*
	 * Kleine straat: 30 punten voor 4 oplopende dobbelstenen. (de volgorde
	 * speelt geen rol 1234, 2345, 3456 )
	 */
	public boolean isSmallStraight(Dice[] dice) {
		List<String> list = new ArrayList<>(dice.length);
		
		for(int i = 0; i < dice.length; i++){
			list.add(String.valueOf(dice[i].getValue()));
		}
		
		Collections.sort(list);
		
		if(String.valueOf(list) == "1234" | String.valueOf(list) == "2345" | String.valueOf(list) == "3456" ){
			return true;
		}
					
		return false;
	}

	/*
	 * Grote straat: 40 punten voor 5 oplopende dobbelstenen. (de volgorde
	 * speelt geen rol)
	 */
	public boolean isLargeStraight(Dice[] dice) {
		List<String> list = new ArrayList<>(dice.length);
				
		for(int i = 0; i < dice.length; i++){
			list.add(String.valueOf(dice[i].getValue()));
		}
		
		Collections.sort(list);
		
		if(String.valueOf(list) == "12345" | String.valueOf(list) == "23456"){
			return true;
		}
			
		return false;
	}


	/*
	 * 
	 */

	public int countValueDices(Dice[] dice, int digit) {
		int total = 0;
		for (int i = 0; i < dice.length; i++) {
			if (dice[i].getValue() == digit) {
				total += dice[i].getValue();
			}
		}

		return total;
	}

	/*
	 * 
	 */
	public int countAllDices(Dice[] dice) {
		int total = 0;
		for (int i = 0; i < dice.length; i++) {
			total += dice[i].getValue();
		}

		return total;
	}

	public boolean isSameDices(Dice[] dice, int digitOfDice) {
		int[] n = new int[7];
		
		for (int i = 0; i < dice.length; i++) {
			n[dice[i].getValue()]++;
		}
		for (int j = 1; j < n.length; j++) {
			if (n[j] == digitOfDice) {
				return true;
			}
		}
		return false;
	}
}
