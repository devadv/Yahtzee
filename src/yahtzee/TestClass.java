package yahtzee;

import java.util.ArrayList;

public class TestClass {
	
	
	public static void printDices(Dice[] dices){
	
		for(int i = 0; i< dices.length;i++){
			System.out.printf("%5d ", dices[i].getValue());
		}
		
	}
	

	public static void main(String[] args) {
		
		Data data = new Data();
		Yahtzee yahtzee = new Yahtzee();
		
		ArrayList<Dice[]> listArrayDices = data.getArrayListDices();
		System.out.printf("%20s %14s %5s %5s %5s %5s %5s %5s\n" , 
				"Dices" , "Pair" ,"3K" , "4K" ,"FH" , "SS" ,"LS" , "Y");
		for( Dice[] dices: listArrayDices){
			
			TestClass.printDices(dices);
			System.out.printf("|%5s " , yahtzee.isSameDices(dices, 2));
			System.out.printf("%5s " , yahtzee.isSameDices(dices, 3));
			System.out.printf("%5s " , yahtzee.isSameDices(dices, 4));
			System.out.printf("%5s " , yahtzee.isFullHouse(dices));
			System.out.printf("%5s " , yahtzee.isSmallStraight(dices));
			System.out.printf("%5s " , yahtzee.isLargeStraight(dices));
			System.out.printf("%5s \n" , yahtzee.isSameDices(dices, 5));
			
		}
		
		
		
		
		
			}

}

