package yahtzee;

import java.util.Scanner;

public class Game {
	private Dice[] dices;
	private int rounds;
	private int turns;
	private Player[] namePlayer;
	
	public Game(int rounds, int turns, int dices) {
		this.dices = new Dice[dices];
		this.rounds = rounds;
		this.turns = turns;
	}
	
	public void setPlayers() {
		
		int numberOfPlayers = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of players: ");
		numberOfPlayers = input.nextInt();
		
		namePlayer = new Player[numberOfPlayers];
		
		for (int i = 0; i < numberOfPlayers; i++) {
			System.out.print("Enter name of player of " + (i + 1) + ": ");
			String name = input.next();
			namePlayer[i] = new Player(name, turns, dices);
			
		}
		
	}
		
	public void start() {
		
		for(int i = 0; i < rounds; i++){
				
			for(int p = 0; p < namePlayer.length; p++){
				System.out.println("Player " + namePlayer[p].getName() + " turn.");
				namePlayer[p].playerTurn();
			}
		}
	}

}
