package yahtzee;

import java.util.ArrayList;

public class Data {
	
	private ArrayList<Dice[]>    arrayListDices;

	public Data(){
	    arrayListDices = new ArrayList<Dice[]>();
		
	    Dice[] ss = {
				new Dice().setValue(2), 
				new Dice().setValue(2), 
				new Dice().setValue(5), 
				new Dice().setValue(3),
				new Dice().setValue(4)};
		arrayListDices.add(ss);
		Dice[] ss1 = {
				new Dice().setValue(6), 
				new Dice().setValue(6), 
				new Dice().setValue(5), 
				new Dice().setValue(3),
				new Dice().setValue(4)};
		arrayListDices.add(ss1);
		Dice[] ss2 = {
				new Dice().setValue(1), 
				new Dice().setValue(2), 
				new Dice().setValue(3), 
				new Dice().setValue(4),
				new Dice().setValue(1)};	
		arrayListDices.add(ss2);
		
		Dice[] fullHouse = {
				new Dice().setValue(6), 
				new Dice().setValue(6), 
				new Dice().setValue(5), 
				new Dice().setValue(5),
				new Dice().setValue(5)};
		arrayListDices.add(fullHouse);
		
		Dice[] fullHouse1 = {
				new Dice().setValue(3), 
				new Dice().setValue(1), 
				new Dice().setValue(3), 
				new Dice().setValue(1),
				new Dice().setValue(1)};	
		arrayListDices.add(fullHouse1);
		
		Dice[] ls = {
				new Dice().setValue(1), 
				new Dice().setValue(2), 
				new Dice().setValue(3), 
				new Dice().setValue(4),
				new Dice().setValue(5)};	
		arrayListDices.add(ls);
		Dice[] ls1 = {
				new Dice().setValue(2), 
				new Dice().setValue(3), 
				new Dice().setValue(4), 
				new Dice().setValue(5),
				new Dice().setValue(6)};	
		arrayListDices.add(ls1);
		Dice[] _4K = {
				new Dice().setValue(4), 
				new Dice().setValue(4), 
				new Dice().setValue(4), 
				new Dice().setValue(4),
				new Dice().setValue(5)};	
		arrayListDices.add(_4K);
		Dice[] Y = {
				new Dice().setValue(5), 
				new Dice().setValue(5), 
				new Dice().setValue(5), 
				new Dice().setValue(5),
				new Dice().setValue(5)};	
		arrayListDices.add(Y);
	}

	public ArrayList<Dice[]> getArrayListDices() {
		return arrayListDices;
	}

}

