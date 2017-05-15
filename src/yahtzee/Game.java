package yahtzee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	private Dice[] dices;
	private int rounds = 2;
	private Player player1;
	private Player player2;
	private boolean repeat;
	private int numberOfthrows;
	private static final int FULL_HOUSE_VALUE = 25;
	private static final int SMALL_STRAIGHT_VALUE = 30;
	private static final int LARGE_STRAIGHT_VALUE = 40;
	private static final int YAHTZEE_VALUE = 50;
	private Yahtzee yahtzee;

	public Game() {
		this.dices = new Dice[5];
		for (int i = 0; i < dices.length; i++) {
			dices[i] = new Dice();
		}
		player1 = new Player("player1");
		player2 = new Player("player2");
		yahtzee = new Yahtzee();
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
		
		System.out.println();
		System.out.println("It is " + player.getName() + "'s turn");
		System.out.println("type dice number to hold/onhold");
		System.out.println("type 7 to hold all dices");
		System.out.println("zero to roll dices");
		System.out.println("and 10 to end turn");
		roll();
		numberOfthrows=1;
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
			if(numberOfthrows <3){
				roll();
				numberOfthrows++;
				System.out.println("Throw " +numberOfthrows + " of "  + player.getName());
				printDicesValue();
			}else{
				System.out.println("End of turn: you have to choose 10 to end turn");
			}
			
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
			try {
				chooseScore(player);
			} catch (InputMismatchException e) {
				System.out.println("Only number from 1 to 13 are allowed.");
				chooseScore(player);
			}
			
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

	public void chooseScore(Player player) throws InputMismatchException {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Choose score: ");
		player.displayScoreForm();
		int score = keyboard.nextInt();	
		
		switch (score) {
		case 1:
			printScore(player, "Total of Aces: ", score);
			break;
		case 2:
			printScore(player, "Total of Twos: ", score);
			break;
		case 3:
			printScore(player, "Total of Threes: ", score);
			break;
		case 4:
			printScore(player, "Total of Fours: ", score);
			break;
		case 5:
			printScore(player, "Total of Fives: ", score);
			break;
		case 6:
			printScore(player, "Total of Sixes: ", score);
			break;
		case 7:
			System.out.println("Total of ThreeOfKind: " + yahtzee.countAllDices(dices));
			if(yahtzee.isThreeOfKind(dices)){
				player.addScore(yahtzee.countAllDices(dices),score);
			}
			else{
				System.out.println("This is not ThreeOfKind choose again.");
			}
			break;
		case 8:
			System.out.println("Total of FourOfKind: " + yahtzee.countAllDices(dices));
			if(yahtzee.isFourOfKind(dices)){
				
			}
			break;
		case 9:
			System.out.println("Total of FullHouse: " + FULL_HOUSE_VALUE);
			if(yahtzee.isFullHouse(dices)){
				
			}
			break;
		case 10:
			System.out.println("Total of Small Straight: " + SMALL_STRAIGHT_VALUE);
			if(yahtzee.isSmallStraight(dices)){
				
			}
			break;
		case 11:
			System.out.println("Total of Large Straight: " + LARGE_STRAIGHT_VALUE);
			if(yahtzee.isLargeStraight(dices)){
				
			}
			break;
		case 12:
			System.out.println("Total of Yahtzee: " + YAHTZEE_VALUE);
			if(yahtzee.isYahtzee(dices)){
				
			}
			break;
		case 13:
			printScore(player, "Total of Chance: ", score);
		default:
			System.out.println("Only number from 1 to 13 are allowed.");
			chooseScore(player);
		}
		
	}
	
	private void printScore(Player player, String scoreText, int score){
		System.out.println(scoreText + yahtzee.countValueDices(dices, score));
		player.getForm().addScore(yahtzee.countValueDices(dices, score), score);
	}

	public static void main(String[] args) {

		Game game = new Game();
		game.start();
		
	}

}