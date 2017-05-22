package yahtzee;

public class ScoreFormYahtzee {

	private int[] scorePosition;
	private Player player;

	public ScoreFormYahtzee(Player player) {
		this.scorePosition = new int[14];
		this.player = player;
	}
	
	public void addScore(int score, int scorePosition) {
		this.scorePosition[scorePosition] = score;
	}
	
	String s;
	public void printScoreForm() {

		String s = String.format("List of score %s", player.getName());
		s += "\n 1. Ones: " + scorePosition[1];
		s += "\n 2. Twos: " + scorePosition[2];
		s += "\n 3. Threes: " + scorePosition[3];
		s += "\n 4. Fours: " + scorePosition[4];
		s += "\n 5. Fives: " + scorePosition[5];
		s += "\n 6. Sixes: " + scorePosition[6];
		s += "\n 7. Total of ThreeOfKind: " + scorePosition[7];
		s += "\n 8. Total of FourOfKind: " + scorePosition[8];
		s += "\n 9. Total of FullHouse: " + scorePosition[9];
		s += "\n10. Total of Small Straight: " + scorePosition[10];
		s += "\n11. Total of Large Straight: " + scorePosition[11];
		s += "\n12. Total of Yahtzee: " + scorePosition[12];
		s += "\n13. Total of Chance:: " + scorePosition[13];
		
		System.out.println(s);
	}
	
	public void setPrintScoreForm() {
		System.out.println(s);
	}
	
	public boolean isYahtzeeFilled() {
		if(scorePosition[12] != 0){
			return true;
		}
		return false;
	}

}
