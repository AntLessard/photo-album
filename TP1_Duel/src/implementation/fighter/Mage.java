package implementation.fighter;

import abstracts.capacity.ICapacity;
import abstracts.fighter.IMage;
import exceptions.fighter.IllegalMageStatDistribution;

public class Mage extends Fighter implements IMage{
	public static final int MIN_IP_STAT_DIFF = 15;
	public static final int MIN_CP_STAT_DIFF = 15;

	public Mage(int sp, int dp, int ip, int cp, ICapacity cap1, ICapacity cap2) {
		super(sp, dp, ip, cp, cap1, cap2);
		validateStats(sp, dp, ip, cp);
	}

	private void validateStats(int sp, int dp, int ip, int cp) {
		if(ip < (Math.max(sp, dp) + MIN_IP_STAT_DIFF) || cp < (Math.max(sp, dp) + MIN_CP_STAT_DIFF)) throw new IllegalMageStatDistribution(IllegalMageStatDistribution.ILLEGAL_STAT_DISTRIBUTION);
	}

}
