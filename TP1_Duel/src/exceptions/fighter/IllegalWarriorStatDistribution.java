package exceptions.fighter;

import implementation.fighter.Warrior;

@SuppressWarnings("serial")
public class IllegalWarriorStatDistribution extends IllegalArgumentException{
	public static final String ILLEGAL_STAT_DISTRIBUTION = "Strengh must have at least " + Warrior.MIN_SP_DP_DIFFERENCE + " more points than Dexterity, and Dexterity must have at least " + Warrior.MIN_DP_IP_DIFFERENCE + " more points than Intelligence";
	
	public IllegalWarriorStatDistribution(String s) {
		super(s);
	}
}
