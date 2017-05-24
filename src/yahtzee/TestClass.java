package yahtzee;

import java.util.ArrayList;
import java.util.Collections;

public class TestClass {
	static Yahtzee yahtzee;
	static Dice[] dices;
	static Player player;
	static Game game;
	static ScoreFormYahtzee scoreFormYahtzee;
	
	public static void main(String[] args) {
		yahtzee = new Yahtzee();
		game = new Game();
		player = new Player("Jan");
		scoreFormYahtzee = new ScoreFormYahtzee(player);
		
		
		TestClass testClass = new TestClass();
		
		for(int j = 0; j < 1; j++){
			dices = new Dice[5];
			
			for (int i = 0; i < dices.length; i++) {
				dices[i] = new Dice();
				dices[i].roll();
			}
			
			//testClass.testIsSamedices();
			//testClass.testIsSmallStraight();
			//testClass.testIslargeStraight();
			//testClass.testIsFullHouse();	
						
		}
		
		game.setdices(dices);
		printDices(dices);
		game.testGameClass(false);
		
		for(int i = 1; i < 14; i++){
			game.executeScore(player, i);
		}
		
		player.getScoreForm().printScoreForm();
		
	}
	
	public void testIsSamedices() {
		if(yahtzee.isSameDices(dices, 2)){
			printMessgeDices("2 dices are the same.");
		}
		else if(yahtzee.isSameDices(dices, 3)){
			printMessgeDices("3 dices are the same.");
		}
		else if(yahtzee.isSameDices(dices, 4)){
			printMessgeDices("4 dices are the same.");
		}
		else if(yahtzee.isSameDices(dices, 5)){
			printMessgeDices("5 dices are the same.");
		}
		else{
			printMessgeDices("No dices are the same.");
		}
	}
	
	public void testIsSmallStraight() {
		if(yahtzee.isStraight(dices, 4)){
			printMessgeDices("Small straight.");		
		}
		else{
			//printMessgeDices("No small straight.");
		}
	}
	
	public void testIslargeStraight() {
		if(yahtzee.isStraight(dices, 5)){
			printMessgeDices("Large straight.");		
		}
		else{
			//printMessgeDices("No large straight.");
		}
	}
	
	public void testIsFullHouse() {
		
		if(yahtzee.isFullHouse(dices)){
			printMessgeDices("Full House.");
		}
		else{
			//printCategorYAndDiceDigits("No Full House.");
		}
	}
	
	public void printMessgeDices(String name) {
		System.out.println(name);
		printDices(dices);
	}
	
	public static void printDices(Dice[] dices){
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < dices.length; i++){
			list.add(dices[i].getValue());
		}
		
		Collections.sort(list);
		
		for(int j = 0; j < list.size(); j++){
			System.out.print(list.get(j) + " ");
		}
		
		System.out.println();
		System.out.println();
	}

}// end class Testclass

