package yahtzee;

public class Yahtzee {
	private final int rounds = 1;
	private final int turns = 3;
	private final int dices = 5;
	
	public Yahtzee() {
		Game game = new Game(rounds, turns, dices);
		game.setPlayers();
		game.start();
	}
	
	public void rules() {
		
	}

}
