package implementation.capacity;

import abstracts.capacity.ICapacity;
import exceptions.capacity.IllegalInitialCharcValue;

public abstract class Capacity implements ICapacity{
	
	public static final int MIN_CHARC_VALUE = 20;
	public static final int MAX_CHARC_VALUE = 100;
	
	private int charc; //characteristic
	
	public Capacity(int charc) {
		this.charc = charc;
		validateCharc();
	}

	private void validateCharc() {
		if(this.charc < MIN_CHARC_VALUE || this.charc > MAX_CHARC_VALUE) throw new IllegalInitialCharcValue(IllegalInitialCharcValue.CHARC_VALUE_OOB); 
	}

	public int getCharc() {
		return this.charc;
	}
}
