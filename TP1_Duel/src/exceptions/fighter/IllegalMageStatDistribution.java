package exceptions.fighter;

import implementation.fighter.Mage;

@SuppressWarnings("serial")
public class IllegalMageStatDistribution extends IllegalArgumentException{

	public final static String ILLEGAL_STAT_DISTRIBUTION = "Intelligence must have >= " + Mage.MIN_IP_STAT_DIFF + " points than either Strength or Dexterity, and Concentration must have >=" + Mage.MIN_CP_STAT_DIFF + " points than either Strength or Dexterity.";

	public IllegalMageStatDistribution(String s) {
		super(s);
	}
}
