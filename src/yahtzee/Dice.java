package yahtzee;

import java.util.Random;

public class Dice {
	
	private int diceValue;
	private Random random;
	
	public Dice(){
		random = new Random();
	}
	
	public void roll() {
		diceValue = 1 + random.nextInt(6);
	}
	
	public int getDiceValue() {
		return diceValue;
		
	}

}
