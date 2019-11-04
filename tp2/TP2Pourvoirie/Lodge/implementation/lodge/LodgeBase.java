package implementation.lodge;

import abstracts.lodge.ILodge;

public abstract class LodgeBase implements ILodge{
	
	private int price;
	protected int numberOfDays;
	protected int numberOfPeople;

	
	public LodgeBase(int numberOfDays, int numberOfPeople) {
		this.numberOfDays = numberOfDays;
		this.numberOfPeople = numberOfPeople;
	}
	
	public int getNbPeople() {
		return numberOfPeople;
		
	}
	
	public int calculateCost() {
		return price;
	}
	
}

