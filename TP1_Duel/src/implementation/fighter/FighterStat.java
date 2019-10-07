package implementation.fighter;

import exceptions.fighter.IllegalStatValue;

public class FighterStat {
	public int sp; //StrengthPoints
	public int dp; //DexterityPoints
	public int ip; //IntelligencePoints
	public int cp; //ConcentrationPoints
	public int hp; //HealthPoints
	
	public final static int INITIAL_HP = 200;
	public final static int INITIAL_STAT_LIMIT = 100;
	protected final static int STAT_REWARD = 1;
	protected final static int STAT_LOSS = 1;
	
	public FighterStat(int sp, int dp, int ip, int cp) {
		validateStats(sp, dp, ip, cp);
		this.sp = sp;
		this.dp = dp;
		this.ip = ip;
		this.cp = cp;
		initialHpCalculation();
	}
	
	private void validateStats(int sp, int dp, int ip, int cp) {
		if((sp + dp + ip + cp) > INITIAL_STAT_LIMIT) throw new IllegalStatValue(IllegalStatValue.TOTAL_STAT_VALUE_TOO_HIGH);
	}
	
	private void initialHpCalculation() {
		this.hp = INITIAL_HP - (this.sp + this.dp + this.ip + this.cp);
	}
}
