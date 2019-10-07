package implementation.fighter;

import abstracts.capacity.ICapacity;
import abstracts.fighter.IAthlete;
import exceptions.fighter.IllegalAthleteStatValue;

public class Athlete extends Fighter implements IAthlete{
	
	public final static int MIN_SP_REQ = 20;
	public final static int MIN_DP_REQ = 20;
	public final static int MIN_IP_REQ = 20;
	public final static int MIN_CP_REQ = 20;
	
	public Athlete(int sp, int dp, int ip, int cp, ICapacity cap1, ICapacity cap2) {
		super(sp, dp, ip, cp, cap1, cap2);
		validateStats(sp, dp, ip, cp);
	}

	private void validateStats(int sp, int dp, int ip, int cp) {
		if(sp < MIN_SP_REQ || dp < MIN_DP_REQ || ip < MIN_IP_REQ || cp < MIN_CP_REQ) throw new IllegalAthleteStatValue(IllegalAthleteStatValue.ILLEGAL_STAT_VALUE);
	}

}
