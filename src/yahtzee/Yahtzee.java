package yahtzee;

public class Yahtzee {
	private final int rounds = 1;
	private final int turns = 3;
	private final int dices = 5;

	public Yahtzee() {

	}

	/*
	 * Drie gelijke: De score is het totaal van alle ogen, 
	 * als er minstens 3 dobbelstenen met hetzelfde aantal ogen zijn.
	 */
	public static boolean isThreeOfKind(Dice[] dices) {
		int[] n = new int[7];
		for(int i = 0; i < dices.length; i++){
			n[dices[i].getValue()]++;
		}
		
		for(int j = 1; j < n.length; j++){
			if(n[j] == 3){
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Vier gelijke: De score is het totaal van alle ogen,
	 *  als er minstens 4 dobbelstenen met hetzelfde aantal ogen zijn.
	 */
	public static boolean isFourOfKind(Dice[] dices) {
		
		return false;
	}
	
	/*
	 * Full House: 25 punten voor 3 gelijke en één paar. (5 gelijke telt niet als Full House, 
	 * tenzij het vak Yahtzee reeds ingevuld is).
	 */
	public static boolean isFullHouse(Dice[] dices) {
		
		return false;
	}
	
	/*
	 * Kleine straat: 30 punten voor 4 oplopende dobbelstenen. (de volgorde speelt geen rol)
	 */
	public static boolean isSmallStraight(Dice[] dices) {
		
		return false;
	}
	
	/*
	 * Grote straat: 40 punten voor 5 oplopende dobbelstenen. (de volgorde speelt geen rol)
	 */
	public static boolean isLargeStraight(Dice[] dices) {
		
		return false;
	}
	
	/*
	 * Yahtzee: 50 punten als alle dobbelstenen hetzelfde aantal ogen hebben.
	 */
	
	public static boolean isYahtzee(Dice[] dices) {
		
		return false;
	}
	
	/*
	 * Kans: De score is het totaal aantal ogen van alle dobbelstenen.
	 */
	public static boolean isChance(Dice[] dices) {
		
		return false;
	}


	
	public static int countValueDices(Dice[] dices, int value) {
		int total = 0;
		for(int i = 0; i < dices.length; i++){
			if(dices[i].getValue() == value){
				total += dices[i].getValue();
			}
		}
		
		return total;
	}
	
	public static int countAllDices(Dice[] dices) {
		int total = 0;
		for(int i = 0; i < dices.length; i++){
			total += dices[i].getValue();
		}
		
		return total;
	}

}
