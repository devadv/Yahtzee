package yahtzee;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class TestWithJUnit {

	

	@Test
	public void testFullHouse() {
		// Given
		for (int i = 1; i < 7; i++) {
			for (int j = 6; j > 0; j--) {
				Dice[] FH = { 
						new Dice().setValue(i), 
						new Dice().setValue(i),
						new Dice().setValue(j), 
						new Dice().setValue(j),
						new Dice().setValue(j) };

				// When

				Yahtzee yahtzee = new Yahtzee();
				/*for (Dice dice: FH){
					System.out.println(dice.getValue());
					
				}
				System.out.println("-----------------------------------------");
				*/
				// Then
				if(!(i==j)){
					Assert.assertTrue(yahtzee.isFullHouse(FH));
				}

			}
		}
	}
	@Test
	public void testYahtzee() {

		// Given
		for (int i = 1; i < 7; i++) {
			Dice[] YTrue = { new Dice().setValue(i), new Dice().setValue(i),
					new Dice().setValue(i), new Dice().setValue(i),
					new Dice().setValue(i) };

			// When

			Yahtzee yahtzee = new Yahtzee();

			// Then

			Assert.assertTrue(yahtzee.isSameDices(YTrue, 5));
		}

	}
	@Test
	public void testSmallStraight(){
		//Given
		
		ArrayList<Dice[]>  arrayListDices = new ArrayList<Dice[]>();
		
		Dice[] SM1 = { 
				new Dice().setValue(1), 
				new Dice().setValue(2),
				new Dice().setValue(3), 
				new Dice().setValue(4),
				new Dice().setValue(1) };
		
		arrayListDices.add(SM1);
		
		Dice[] SM2 = { 
				new Dice().setValue(2), 
				new Dice().setValue(3),
				new Dice().setValue(4), 
				new Dice().setValue(5),
				new Dice().setValue(2) };
		
		arrayListDices.add(SM2);
		
		Dice[] SM3 = { 
				new Dice().setValue(3), 
				new Dice().setValue(4),
				new Dice().setValue(5), 
				new Dice().setValue(6),
				new Dice().setValue(3) };

		arrayListDices.add(SM3);
		
		//When
		
		Yahtzee yahtzee = new Yahtzee();
		int streetLenght = 4; // small straight
		//Then
		for(Dice[] dices:arrayListDices){
			
			Assert.assertTrue(yahtzee.isStraight(dices, streetLenght));
		}
		
	
		
	}
	@Test
	public void testLargeStraight(){
		//Given
		
		ArrayList<Dice[]>  arrayListDices = new ArrayList<Dice[]>();
		
		Dice[] LM1 = { 
				new Dice().setValue(1), 
				new Dice().setValue(2),
				new Dice().setValue(3), 
				new Dice().setValue(4),
				new Dice().setValue(5) };
		
		arrayListDices.add(LM1);
		
		Dice[] LM2 = { 
				new Dice().setValue(2), 
				new Dice().setValue(3),
				new Dice().setValue(4), 
				new Dice().setValue(5),
				new Dice().setValue(6) };
		
		arrayListDices.add(LM2);
		
		
		
		//When
		
		Yahtzee yahtzee = new Yahtzee();
		int streetLenght = 5; // small straight
		//Then
		for(Dice[] dices:arrayListDices){
			
			Assert.assertTrue(yahtzee.isStraight(dices, streetLenght));
		}
		
	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}