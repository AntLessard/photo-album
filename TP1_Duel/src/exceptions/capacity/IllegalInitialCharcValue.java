package exceptions.capacity;

import implementation.capacity.Capacity;

@SuppressWarnings("serial")
public class IllegalInitialCharcValue extends IllegalArgumentException{
	public static final String CHARC_VALUE_OOB = "Characteristic must be a number >= " + Capacity.MIN_CHARC_VALUE + " and <= " + Capacity.MAX_CHARC_VALUE + ".";
	
	public IllegalInitialCharcValue(String s) {
		super(s);
	}
	
}
