package implementation.fighter;

import java.util.ArrayList;
import java.util.List;

import abstracts.capacity.ICapacity;
import abstracts.fighter.IFighter;
import implementation.capacity.Capacity;

public class Fighter implements IFighter{
	public List<ICapacity> capacityList;
	public FighterStat fighterStat;
	
	public Fighter(int sp, int dp, int ip, int cp, ICapacity cap1, ICapacity cap2) {
		this.fighterStat = new FighterStat(sp, dp, ip, cp);
		this.capacityList = new ArrayList<ICapacity>();
		addCapacity(cap1);
		addCapacity(cap2);
	}
	
	public int getSP() {
		return fighterStat.sp;
	}
	
	public int getDP() {
		return fighterStat.dp;
	}
	
	public int getIP() {
		return fighterStat.ip;
	}

	public int getCP() {
		return fighterStat.cp;
	}
	
	public int getHP() {
		return fighterStat.hp;
	}
	
	public Capacity selectCapacity(int i) {
		return (Capacity) this.capacityList.get(i);
		
	}
	
	public void addCapacity(ICapacity capacityToAdd) {
		this.capacityList.add(capacityToAdd);
	}
	
	public int getPower(ICapacity capacity) {
		return capacity.calculatePower(capacity, fighterStat);
	}
	
	public void statUp() {
		fighterStat.sp = fighterStat.sp + FighterStat.STAT_REWARD;
		fighterStat.dp = fighterStat.dp + FighterStat.STAT_REWARD;
		fighterStat.ip = fighterStat.ip + FighterStat.STAT_REWARD;
		fighterStat.cp = fighterStat.cp + FighterStat.STAT_REWARD;
	}
	
	public void statDown() {
		fighterStat.sp = fighterStat.sp - FighterStat.STAT_LOSS;
		fighterStat.dp = fighterStat.dp - FighterStat.STAT_LOSS;
		fighterStat.ip = fighterStat.ip - FighterStat.STAT_LOSS;
		fighterStat.cp = fighterStat.cp - FighterStat.STAT_LOSS;
	}
}
