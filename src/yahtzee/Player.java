package yahtzee;

import java.util.Scanner;

public class Player {

	private String name;
	private int turns;
	private ScoreFormYahtzee form;
	private int[] scorePos;

	public Player(String name) {
		this.name = name;
		this.form = new ScoreFormYahtzee(this);
		this.scorePos = new int[14];
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void displayScoreForm() {
		ScoreFormYahtzee.printScoreForm();
	}

	public void addScore(int score, int scorePosition) {
		form.addScore(score, scorePosition);
	}

}