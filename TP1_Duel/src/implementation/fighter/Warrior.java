package implementation.fighter;

import abstracts.capacity.ICapacity;
import abstracts.fighter.IFighter;
import exceptions.fighter.IllegalWarriorStatDistribution;

public class Warrior extends Fighter implements IFighter{

	public final static int MIN_SP_DP_DIFFERENCE = 10;
	public final static int MIN_DP_IP_DIFFERENCE = 10;
	
	
	public Warrior(int sp, int dp, int ip, int cp, ICapacity cap1, ICapacity cap2) {
		super(sp, dp, ip, cp, cap1, cap2);
		validateStats(sp, dp, ip, cp);
	}
	
	
	private void validateStats(int sp, int dp, int ip, int cp){
		if(fighterStat.sp < fighterStat.dp + MIN_SP_DP_DIFFERENCE || fighterStat.dp < fighterStat.ip + MIN_DP_IP_DIFFERENCE || fighterStat.ip < fighterStat.cp) throw new IllegalWarriorStatDistribution(IllegalWarriorStatDistribution.ILLEGAL_STAT_DISTRIBUTION);
	}
	
}
