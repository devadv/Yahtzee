package yahtzee;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

public class Game {
	private Dice[] dices;
	private int rounds = 2;
	private Player player1;
	private Player player2;
	private boolean repeat;
	private int numberOfthrows;

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
			System.out.println("Total of Aces: " + Yahtzee.countValueDices(dices, 1));
			//player.getForm().addScore(score, scorePosition);
			player.addScore(Yahtzee.countValueDices(dices, 1), 1);
			break;
		case 2:
			System.out.println("Total of Twos: " + Yahtzee.countValueDices(dices, 2));
			player.addScore(Yahtzee.countValueDices(dices, 2), 2);
			break;
		case 3:
			System.out.println("Total of Threes: " + Yahtzee.countValueDices(dices, 3));
			player.addScore(Yahtzee.countValueDices(dices, 3), 3);
			break;
		case 4:
			System.out.println("Total of Fours: " + Yahtzee.countValueDices(dices, 4));
			player.addScore(Yahtzee.countValueDices(dices, 4), 4);
			break;
		case 5:
			System.out.println("Total of Fives: " + Yahtzee.countValueDices(dices, 5));
			player.addScore(Yahtzee.countValueDices(dices, 5), 5);
			break;
		case 6:
			System.out.println("Total of Sixes: " + Yahtzee.countValueDices(dices, 6));
			player.addScore(Yahtzee.countValueDices(dices, 6), 6);
			break;
		case 7:
			System.out.println("Total of ThreeOfKind: " + Yahtzee.countAllDices(dices));
			if(Yahtzee.isThreeOfKind(dices)){
				player.addScore(Yahtzee.countAllDices(dices), 7);
			}
			else{
				System.out.println("This is not ThreeOfKind choose again.");
			}
			break;
		case 8:
			System.out.println("Total of FourOfKind: " + Yahtzee.countAllDices(dices));
			if(Yahtzee.isFourOfKind(dices)){
				
			}
			break;
		case 9:
			System.out.println("Total of FullHouse: " + 25);
			if(Yahtzee.isFullHouse(dices)){
				
			}
			break;
		case 10:
			System.out.println("Total of Small Straight: " + 30);
			if(Yahtzee.isSmallStraight(dices)){
				
			}
			break;
		case 11:
			System.out.println("Total of Large Straight: " + 40);
			if(Yahtzee.isLargeStraight(dices)){
				
			}
			break;
		case 12:
			System.out.println("Total of Yahtzee: " + 50);
			if(Yahtzee.isYahtzee(dices)){
				
			}
			break;
		case 13:
			System.out.println("Total of Chance: " + Yahtzee.countAllDices(dices));
			if(Yahtzee.isChance(dices)){
				
			}
			break;
		default:
			System.out.println("Only number from 1 to 13 are allowed.");
			chooseScore(player);
		}
		
	}

	public static void main(String[] args) {

		Game game = new Game();
		game.start();

	}

}