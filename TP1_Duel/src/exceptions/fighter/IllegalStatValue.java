package exceptions.fighter;

import implementation.fighter.FighterStat;

@SuppressWarnings("serial")
public class IllegalStatValue extends IllegalArgumentException {
	public static final String TOTAL_STAT_VALUE_TOO_HIGH = "Total stat values must be <= " + FighterStat.INITIAL_STAT_LIMIT;
	
	public IllegalStatValue(String s) {
		super(s);
	}
}
