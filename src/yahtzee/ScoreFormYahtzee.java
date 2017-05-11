package yahtzee;

public class ScoreFormYahtzee {

	private int[] scorePos;
	private Player player;

	public ScoreFormYahtzee(Player player) {
		this.scorePos = new int[14];
		this.player = player;
	}
	
	public void addScore(int score, int scorePosition) {
		scorePos[scorePosition] = score;
	}

	public void printScoreForm() {

		String s = String.format("List of score %s", player.getName());
		s += "\n 1. Ones: " + scorePos[1];
		s += "\n 2. Twos: " + scorePos[2];
		s += "\n 3. Threes: " + scorePos[3];
		s += "\n 4. Fours: " + scorePos[4];
		s += "\n 5. Fives: " + scorePos[5];
		s += "\n 6. Sixes: " + scorePos[6];
		s += "\n 7. Total of ThreeOfKind: " + scorePos[7];
		s += "\n 8. Total of FourOfKind: " + scorePos[8];
		s += "\n 9. Total of FullHouse: " + scorePos[9];
		s += "\n10. Total of Small Straight: " + scorePos[10];
		s += "\n11. Total of Large Straight: " + scorePos[11];
		s += "\n12. Total of Yahtzee: " + scorePos[12];
		s += "\n13.Total of Chance:: " + scorePos[13];
		
		System.out.println(s);
	}

}
