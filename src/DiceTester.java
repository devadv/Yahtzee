
public class DiceTester {
	
	
	
public static void main(String[] args) {
		
		Dice dice  = new Dice();
		int[] freq = new int[7];
		int count = 1000;
		for(int i = 0 ; i < count; i++){
			dice.roll();
			++freq[dice.getValue()];
		}
		
		System.out.printf("Dobbesteen %d keer gegooid\n" , count);
		for(int j = 1; j < freq.length; j++){
			System.out.printf("Aantal keer %d : %d \n" ,j , freq[j]);
		}
		
			
	}

}
