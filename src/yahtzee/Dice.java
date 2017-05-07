package yahtzee;

import java.util.Random;

public class Dice {

	private int diceValue;
	private Random random;
	private boolean hold = false;

	public Dice() {
		random = new Random();
	}

	public void roll() {
		if (!hold) {
			diceValue = 1 + random.nextInt(6);
		}
	}

	public int getValue() {
		return diceValue;

	}

	public void setHold() {
		hold = !hold;
	}

	public boolean isHold() {
		return hold;

	}

}
