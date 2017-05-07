package yahtzee;

import java.util.Scanner;

public class Player {

	private String name;
	private int turns;
	private ScoreFormYahtzee form;

	public Player(String name) {
		this.name = name;
		this.form = new ScoreFormYahtzee(this);

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void displayScoreForm() {
		System.out.println(form);
	}

	public void addScore(int score, int scorePosition) {

	}

}