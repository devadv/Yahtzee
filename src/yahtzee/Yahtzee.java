package yahtzee;

public class Yahtzee {
	private final int rounds = 1;
	private final int turns = 3;
	private final int dices = 5;

	public Yahtzee() {

	}

	public void rules() {

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
