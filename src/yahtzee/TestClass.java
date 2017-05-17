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
			System.out.printf("%5s " , yahtzee.isStraight(dices, 4));
			System.out.printf("%5s " , yahtzee.isStraight(dices, 5));
			System.out.printf("%5s \n" , yahtzee.isSameDices(dices, 5));
			
		}
		
		
		for(int j = 0; j < 100; j++){
			Dice[] dices = new Dice[5];
			for (int i = 0; i < dices.length; i++) {
				dices[i] = new Dice();
				dices[i].roll();
			}
			
			// test method isSameDices
			if(yahtzee.isSameDices(dices, 2) | yahtzee.isSameDices(dices, 3) | yahtzee.isSameDices(dices, 4)|
					yahtzee.isSameDices(dices, 5) | yahtzee.isSameDices(dices, 6)){
				
			}
			else{
				System.out.println("No same dices.");
				for(int k = 0; k < dices.length; k++){
					System.out.println("Dice " + (k + 1) + "  "  + dices[k].getValue());
				}
				System.out.println();
			}// end test method isSameDices
			
			// test Full House
			if(yahtzee.isFullHouse(dices)){
				System.out.println("Full House.");
				for(int k = 0; k < dices.length; k++){
					System.out.println("Dice " + (k + 1) + "  "  + dices[k].getValue());
				}
				System.out.println();
			}
			else{
				//System.out.println("No Full House.");
			}
			
			// test Small Straight
			if(yahtzee.isStraight(dices, 4)){
				System.out.println("Small Straight.");
				for(int k = 0; k < dices.length; k++){
					System.out.println("Dice " + (k + 1) + "  "  + dices[k].getValue());
				}
				System.out.println();
			}
			else{
				//System.out.println("No Small Straight.");
			}
			
		}// end outer for
	}
	
	
	

}

