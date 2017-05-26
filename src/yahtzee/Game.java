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
	private Yahtzee yahtzee;
	private boolean tries = true;

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
				executeScore(player, 10);
			} catch (InputMismatchException e) {
				System.out.println("Only number from 1 to 13 are allowed.");
				executeScore(player, 10);
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
	
	public void chooseScore(Player player) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Choose score: ");
		int score = keyboard.nextInt();
		executeScore(player, score);
	}
	
	public void executeScore(Player player, int score) throws InputMismatchException {
		//player.displayScoreForm();
		
		switch (score) {
		case 1:
			addScore(player, score);
			break;
		case 2:
			addScore(player, score);
			break;
		case 3:
			addScore(player, score);
			break;
		case 4:
			addScore(player, score);
			break;
		case 5:
			addScore(player, score);
			break;
		case 6:
			addScore(player, score);
			break;
		case 7:
			if(yahtzee.isSameDices(dices, 3)){
				player.getScoreForm().addScore(yahtzee.countAllDices(dices),score);
			}
			else{
				System.out.println("This is not ThreeOfKind choose again.");
				if(tries){
					executeScore(player, score);
				}
			}
			break;
		case 8:
			if(yahtzee.isSameDices(dices, 4)){
				player.getScoreForm().addScore(yahtzee.countAllDices(dices),score);
			}
			else{
				System.out.println("This is not FourOfKind choose again.");
				if(tries){
					executeScore(player, score);
				}
			}
			break;
		case 9:
			if(yahtzee.isFullHouse(dices)){
				player.getScoreForm().addScore(Yahtzee.FULLHOUSE, 9);
			}
			else if(yahtzee.isSameDices(dices, 5) && player.getScoreForm().isYahtzeeFilled()){
				player.getScoreForm().addScore(Yahtzee.FULLHOUSE, 9);
			}
			else{
				System.out.println("This is not Fullhouse choose again.");
				if(tries){
					executeScore(player, score);
				}
			}
			break;
		case 10:
			if(yahtzee.isStraight(dices, 4)){
				player.getScoreForm().addScore(Yahtzee.SMALLSTRAIGHT, 10);
			}
			else{
				System.out.println("This is not Small Straight choose again.");
				if(tries){
					chooseScore(player);
				}
			}
			break;
		case 11:
			if(yahtzee.isStraight(dices, 5)){
				player.getScoreForm().addScore(Yahtzee.LARGESTRAIGHT, 11);
			}
			else{
				System.out.println("This is not Large Straight choose again.");
				if(tries){
					chooseScore(player);
				}
			}
			break;
		case 12:
			if(yahtzee.isSameDices(dices, 5)){
				if(player.getScoreForm().isYahtzeeFilled() == false){
					player.getScoreForm().addScore(Yahtzee.YAHTZEE, 12);
				}
				else{
					player.getScoreForm().addScore(Yahtzee.YAHTZEEBONUS, 12);
					System.out.println("Fill the score also in another catagory.");
					if(tries){
						chooseScore(player);
					}
				}
			}
			else{
				System.out.println("This is not Yahtzee choose again.");
				if(tries){
					chooseScore(player);
				}
			}
			break;
		case 13:
			if(player.getScoreForm().canAddScore(yahtzee.countAllDices(dices), 13)){
				player.getScoreForm().addScore(yahtzee.countAllDices(dices), 13);
			}
			
			break;
		default:
			System.out.println("Only number from 1 to 13 are allowed.");
			if(tries){
				chooseScore(player);
			}
		}
		
	}
	
	public void addScore(Player player,int score) {
		if( player.getScoreForm().canAddScore(yahtzee.countValueDices(dices, score), score) ){
			player.getScoreForm().addScore(yahtzee.countValueDices(dices, score), score);
		}
		else{
			System.out.println("Position in score form is filled choose again.");
			if(tries){
				chooseScore(player);
			}
		}
	}
	
	public void setdices(Dice[] dices) {
		this.dices = dices;
	}
	
	public void testGameClass(boolean tries) {
		this.tries = tries;
	}
	

	public static void main(String[] args) {

		Game game = new Game();
		game.start();
		
	}

}