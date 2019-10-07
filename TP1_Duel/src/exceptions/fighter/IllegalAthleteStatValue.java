package exceptions.fighter;

import implementation.fighter.Athlete;

@SuppressWarnings("serial")
public class IllegalAthleteStatValue extends IllegalArgumentException{
	public static final String ILLEGAL_STAT_VALUE = "Strength must be >=" + Athlete.MIN_SP_REQ + " points, Dexterity must be >=" + Athlete.MIN_DP_REQ + " points, Intelligence must be >=" + Athlete.MIN_IP_REQ + " points and Concentration must be >=" + Athlete.MIN_CP_REQ + " points.";
	
	public IllegalAthleteStatValue(String s) {
		super(s);
	}
}
