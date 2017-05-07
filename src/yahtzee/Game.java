package yahtzee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	private Dice[] dices;
	private int rounds = 2;
	private Player player1;
	private Player player2;
	private boolean repeat;

	public Game() {
		this.dices = new Dice[5];
		for (int i = 0; i < dices.length; i++) {
			dices[i] = new Dice();
		}
		player1 = new Player("player1");
		player2 = new Player("player2");
	}

	public void start() {
		System.out.println("The players are: " + player1.getName() + " en "
				+ player2.getName());
		for (int i = rounds; i > 0; i--) {
			playerTurn(player1);
			playerTurn(player2);
		}
	}

	public void playerTurn(Player player) {
		System.out.println("It is " + player.getName() + "'s turn");
		System.out.println("type dice number to hold/onhold");
		System.out.println("type 7 to hold all dices");
		System.out.println("zero to roll dices");
		System.out.println("and 10 to end turn");
		roll();
		printDicesValue();
		repeat = true;
		while (repeat) {
			try {
				holdDices(player);
			} catch (InputMismatchException ex) {
				System.out
						.println("Only numbers form 0 to 7 and 10 are allowed");
				playerTurn(player);
			}
		}
	}

	public void holdDices(Player player) throws InputMismatchException {
		Scanner keyboard = new Scanner(System.in);
		repeat = true;
		int numberofDice = keyboard.nextInt();
		keyboard.nextLine();

		switch (numberofDice) {
		case 1:
			dices[0].setHold();
			printDicesValue();
			break;
		case 2:
			dices[1].setHold();
			printDicesValue();
			break;
		case 3:
			dices[2].setHold();
			printDicesValue();
			break;
		case 4:
			dices[3].setHold();
			printDicesValue();
			break;
		case 5:
			dices[4].setHold();
			printDicesValue();
			break;
		case 0:// roll
			roll();
			printDicesValue();
			break;
		case 7:// hold all dices
			for (int i = 0; i < dices.length; i++) {
				if (!dices[i].isHold()) {
					dices[i].setHold();
				}
			}
			printDicesValue();
			break;
		case 10:
			System.out.println("Choose score!");
			chooseScore();
			player.displayScoreForm();
			reset();
			repeat = false;
			break;
		}

	}

	public void roll() {
		for (int i = 0; i < dices.length; i++) {
			dices[i].roll();
		}
	}

	public void printDicesValue() {
		for (int i = 0; i < dices.length; i++) {
			System.out.printf("Dice %d. %10d %10s\n", i + 1,
					dices[i].getValue(), dices[i].isHold() ? "Hold" : "");
		}

	}

	public void reset() {
		for (int i = 0; i < dices.length; i++) {
			if (dices[i].isHold()) {
				dices[i].setHold();
			}
		}
	}

	public void chooseScore() {
		Scanner keyboard = new Scanner(System.in);
		// TODO print options form ScoreForm
		int score = keyboard.nextInt();
		switch (score) {
		case 1:
			System.out.println("Aces");
			break;
		case 2:
			System.out.println("Twos");
			break;
		case 3:
			System.out.println("Threes");
			break;
		case 4:
			System.out.println("Fours");
			break;
		case 5:
			System.out.println("Fives");
			break;
		case 6:
			System.out.println("Sixes");
			break;
		case 7:
			System.out.println("ThreeOfKind");
			break;
		case 8:
			System.out.println("Carre");
			break;
		case 9:
			System.out.println("FullHouse");
			break;
		case 10:
			System.out.println("Small Straight");
			break;
		case 11:
			System.out.println("Large Straight");
			break;
		case 12:
			System.out.println("Yahtzee");
			break;
		case 13:
			System.out.println("Chance");
			break;

		}

	}

	public static void main(String[] args) {

		Game game = new Game();
		game.start();

	}

}