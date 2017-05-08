package yahtzee;

public class ScoreFormYahtzee {

	private static int[] scorePos;

	public ScoreFormYahtzee(Player player) {
		this.scorePos = new int[14];
	}
	
	public void addScore(int score, int scorePosition) {
		scorePos[scorePosition] = score;
	}

	
	
	public static String printScoreForm() {

		String s = String.format("List of score");
		s += "\nOnes: " + scorePos[1];
		s += "\nTwos: " + scorePos[2];
		
		
		
		return s;
	}

}
