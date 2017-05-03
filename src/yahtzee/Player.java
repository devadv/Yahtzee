package yahtzee;

import java.util.Scanner;

import org.xml.sax.HandlerBase;

public class Player {

	private String name;
	private	int turns;
	private Dice[] dices;
	private boolean[] holdDice;
	private ScoreFormYahtzee form;
	
	public Player(String name, int turn, Dice[] dices){
		this.name = name;
		this.turns = turn;
		this.dices = dices;
		this.form = new ScoreFormYahtzee();
		holdDice = new boolean[dices.length];
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void playerTurn(){
		int[] diceNum = new int[dices.length];
		
		
		for(int i = 0; i < turns; i++){
			
			for(int j = 0; j < diceNum.length; j++){
				
				if(holdDice[j] == false){
					dices[j] = new Dice();
					dices[j].roll();
					diceNum[j] = dices[j].getDiceValue();
					System.out.println( "dice " + (j + 1) + "   " + diceNum[j]);
				}
				
			}
			
			holdDices();
		}
	}
	
	private void holdDices() {
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < dices.length; i++){
			int n = 0;
			System.out.print("Enter number wich dice must remain or 0 to continue. ");
			n = input.nextInt() - 1;
			if(n == -1){
				break;
			}
			holdDice[n] = true;
		}
		
	}
	
}
